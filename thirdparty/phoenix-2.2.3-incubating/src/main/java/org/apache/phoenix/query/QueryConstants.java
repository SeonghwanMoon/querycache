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
package org.apache.phoenix.query;


import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.BUFFER_LENGTH;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.CHAR_OCTET_LENGTH;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.COLUMN_COUNT;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.COLUMN_DEF;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.COLUMN_MODIFIER;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.COLUMN_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.COLUMN_SIZE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.DATA_TABLE_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.DATA_TYPE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.DECIMAL_DIGITS;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.IMMUTABLE_ROWS;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.INDEX_STATE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.IS_AUTOINCREMENT;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.IS_NULLABLE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.NULLABLE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.NUM_PREC_RADIX;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.ORDINAL_POSITION;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.PK_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.REF_GENERATION_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.REMARKS_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SALT_BUCKETS;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SCOPE_CATALOG;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SCOPE_SCHEMA;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SCOPE_TABLE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SELF_REFERENCING_COL_NAME_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SOURCE_DATA_TYPE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SQL_DATA_TYPE;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.SQL_DATETIME_SUB;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TABLE_CAT_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TABLE_NAME_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TABLE_SCHEM_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TABLE_SEQ_NUM;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TABLE_TYPE_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TYPE_NAME;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TYPE_SCHEMA;
import static org.apache.phoenix.jdbc.PhoenixDatabaseMetaData.TYPE_TABLE;

import java.math.BigDecimal;

import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.util.Bytes;

import org.apache.phoenix.coprocessor.MetaDataProtocol;
import org.apache.phoenix.schema.MetaDataSplitPolicy;
import org.apache.phoenix.schema.PName;
import org.apache.phoenix.schema.PNormalizedName;


/**
 * 
 * Constants used during querying
 *
 * 
 * @since 0.1
 */
public interface QueryConstants {
    public static final String NAME_SEPARATOR = ".";
    public final static byte[] NAME_SEPARATOR_BYTES = Bytes.toBytes(NAME_SEPARATOR);
    public static final byte NAME_SEPARATOR_BYTE = NAME_SEPARATOR_BYTES[0];
    public static final String NULL_SCHEMA_NAME = "";
    public static final String NULL_DISPLAY_TEXT = "<null>";
    public static final long UNSET_TIMESTAMP = -1;
    
    public enum JoinType {INNER, LEFT_OUTER}
    public final static String PHOENIX_SCHEMA = "system";
    public final static String PHOENIX_METADATA = "table";

    public final static PName SINGLE_COLUMN_NAME = new PNormalizedName("s");
    public final static PName SINGLE_COLUMN_FAMILY_NAME = new PNormalizedName("s");
    public final static byte[] SINGLE_COLUMN = SINGLE_COLUMN_NAME.getBytes();
    public final static byte[] SINGLE_COLUMN_FAMILY = SINGLE_COLUMN_FAMILY_NAME.getBytes();

    public static final long AGG_TIMESTAMP = HConstants.LATEST_TIMESTAMP;
    /**
     * Key used for a single row aggregation where there is no group by
     */
    public final static byte[] UNGROUPED_AGG_ROW_KEY = Bytes.toBytes("a");
    public final static PName AGG_COLUMN_NAME = SINGLE_COLUMN_NAME;
    public final static PName AGG_COLUMN_FAMILY_NAME = SINGLE_COLUMN_FAMILY_NAME;

    public static final byte[] TRUE = new byte[] {1};

    /**
     * Separator used between variable length keys for a composite key.
     * Variable length data types may not use this byte value.
     */
    public static final byte SEPARATOR_BYTE = (byte) 0;
    public static final byte[] SEPARATOR_BYTE_ARRAY = new byte[] {SEPARATOR_BYTE};
    
    public static final String DEFAULT_COPROCESS_PATH = "phoenix.jar";
    public final static int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

    public static final String EMPTY_COLUMN_NAME = "_0";
    public static final byte[] EMPTY_COLUMN_BYTES = Bytes.toBytes(EMPTY_COLUMN_NAME);
    public static final String DEFAULT_COLUMN_FAMILY = EMPTY_COLUMN_NAME;
    public static final byte[] DEFAULT_COLUMN_FAMILY_BYTES = EMPTY_COLUMN_BYTES;
    public static final String ALL_FAMILY_PROPERTIES_KEY = "";
    public static final String SYSTEM_TABLE_PK_NAME = "pk";
    
    public static final double MILLIS_TO_NANOS_CONVERTOR = Math.pow(10, 6);
    public static final BigDecimal BD_MILLIS_NANOS_CONVERSION = BigDecimal.valueOf(MILLIS_TO_NANOS_CONVERTOR);
    public static final BigDecimal BD_MILLIS_IN_DAY = BigDecimal.valueOf(QueryConstants.MILLIS_IN_DAY);
    

    public static final String CREATE_METADATA =
            "CREATE TABLE " + TYPE_SCHEMA + ".\"" + TYPE_TABLE + "\"(\n" +
            // PK columns
            TABLE_SCHEM_NAME + " VARCHAR NULL," +
            TABLE_NAME_NAME + " VARCHAR NOT NULL," +
            COLUMN_NAME + " VARCHAR NULL," + // null only for table row
            TABLE_CAT_NAME + " VARCHAR NULL," + // using for CF - ensures uniqueness for columns
            // Table metadata (will be null for column rows)
            TABLE_TYPE_NAME + " CHAR(1)," +
            REMARKS_NAME + " VARCHAR," +
            DATA_TYPE + " INTEGER," +
            PK_NAME + " VARCHAR," +
            TYPE_NAME + " VARCHAR," +
            SELF_REFERENCING_COL_NAME_NAME + " VARCHAR," +
            REF_GENERATION_NAME + " VARCHAR," +
            TABLE_SEQ_NUM + " BIGINT," +
            COLUMN_COUNT + " INTEGER," +
            // Column metadata (will be null for table row)
            COLUMN_SIZE + " INTEGER," +
            BUFFER_LENGTH + " INTEGER," +
            DECIMAL_DIGITS + " INTEGER," +
            NUM_PREC_RADIX + " INTEGER," +
            NULLABLE + " INTEGER," +
            COLUMN_DEF + " VARCHAR," +
            SQL_DATA_TYPE + " INTEGER," +
            SQL_DATETIME_SUB + " INTEGER," +
            CHAR_OCTET_LENGTH + " INTEGER," +
            ORDINAL_POSITION + " INTEGER," +
            IS_NULLABLE + " VARCHAR," +
            SCOPE_CATALOG + " VARCHAR," +
            SCOPE_SCHEMA + " VARCHAR," +
            SCOPE_TABLE + " VARCHAR," +
            SOURCE_DATA_TYPE + " INTEGER," + // supposed to be SHORT
            IS_AUTOINCREMENT + " VARCHAR," +
            // Columns added in 1.2.1
            COLUMN_MODIFIER + " INTEGER," +
            SALT_BUCKETS + " INTEGER," +
            // Columns added in 2.0.0
            DATA_TABLE_NAME + " VARCHAR NULL," +
            INDEX_STATE + " CHAR(1)\n," +
            IMMUTABLE_ROWS + " BOOLEAN\n" +
            "CONSTRAINT " + SYSTEM_TABLE_PK_NAME + " PRIMARY KEY (" + TABLE_SCHEM_NAME + "," 
            + TABLE_NAME_NAME + "," + COLUMN_NAME + "," + TABLE_CAT_NAME + "))\n" +
            HConstants.VERSIONS + "=" + MetaDataProtocol.DEFAULT_MAX_META_DATA_VERSIONS + ",\n" +
            HTableDescriptor.SPLIT_POLICY + "='" + MetaDataSplitPolicy.class.getName() + "'\n";
}
