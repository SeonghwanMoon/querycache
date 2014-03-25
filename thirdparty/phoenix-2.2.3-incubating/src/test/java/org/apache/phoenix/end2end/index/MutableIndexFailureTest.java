/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.end2end.index;

import static org.apache.phoenix.util.TestUtil.TEST_PROPERTIES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.hadoop.hbase.TableNotFoundException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.junit.Test;

import org.apache.phoenix.jdbc.PhoenixConnection;
import org.apache.phoenix.query.ConnectionQueryServices;
import org.apache.phoenix.schema.PIndexState;
import org.apache.phoenix.schema.PTableType;
import org.apache.phoenix.util.StringUtil;

/**
 * 
 * Test for failure of region server to write to index table. Keep in its own
 * separate test, as otherwise it makes tests run after it fail.
 *
 * 
 * @since 2.1
 */
public class MutableIndexFailureTest extends BaseMutableIndexTest {
    private static void destroyIndexTable() throws Exception {
        // Physically delete HBase table so that splits occur as expected for each test
        Properties props = new Properties(TEST_PROPERTIES);
        ConnectionQueryServices services = DriverManager.getConnection(getUrl(), props).unwrap(PhoenixConnection.class).getQueryServices();
        HBaseAdmin admin = services.getAdmin();
        try {
            admin.disableTable(INDEX_TABLE_FULL_NAME);
            admin.deleteTable(INDEX_TABLE_FULL_NAME);
        } catch (TableNotFoundException e) {
        } finally {
            admin.close();
        }
    }
    
    @Test
    public void testWriteFailureDisablesIndex() throws Exception {
        String query;
        ResultSet rs;
        
        Properties props = new Properties(TEST_PROPERTIES);
        Connection conn = DriverManager.getConnection(getUrl(), props);
        conn.setAutoCommit(false);
        conn.createStatement().execute("CREATE TABLE " + DATA_TABLE_FULL_NAME + " (k VARCHAR NOT NULL PRIMARY KEY, v1 VARCHAR, v2 VARCHAR)");
        query = "SELECT * FROM " + DATA_TABLE_FULL_NAME;
        rs = conn.createStatement().executeQuery(query);
        assertFalse(rs.next());
        
        conn.createStatement().execute("CREATE INDEX " + INDEX_TABLE_NAME + " ON " + DATA_TABLE_FULL_NAME + " (v1) INCLUDE (v2)");
        query = "SELECT * FROM " + INDEX_TABLE_FULL_NAME;
        rs = conn.createStatement().executeQuery(query);
        assertFalse(rs.next());

        // Verify the metadata for index is correct.
        rs = conn.getMetaData().getTables(null, StringUtil.escapeLike(SCHEMA_NAME), INDEX_TABLE_NAME, new String[] {PTableType.INDEX.toString()});
        assertTrue(rs.next());
        assertEquals(INDEX_TABLE_NAME, rs.getString(3));
        assertEquals(PIndexState.ACTIVE.toString(), rs.getString("INDEX_STATE"));
        assertFalse(rs.next());

        destroyIndexTable();
        
        PreparedStatement stmt = conn.prepareStatement("UPSERT INTO " + DATA_TABLE_FULL_NAME + " VALUES(?,?,?)");
        stmt.setString(1,"a");
        stmt.setString(2, "x");
        stmt.setString(3, "1");
        stmt.execute();
        try {
            conn.commit();
            fail();
        } catch (SQLException e) {
            
        }
        
        // Verify the metadata for index is correct.
        rs = conn.getMetaData().getTables(null, StringUtil.escapeLike(SCHEMA_NAME), INDEX_TABLE_NAME, new String[] {PTableType.INDEX.toString()});
        assertTrue(rs.next());
        assertEquals(INDEX_TABLE_NAME, rs.getString(3));
        assertEquals(PIndexState.DISABLE.toString(), rs.getString("INDEX_STATE"));
        assertFalse(rs.next());
    }
}