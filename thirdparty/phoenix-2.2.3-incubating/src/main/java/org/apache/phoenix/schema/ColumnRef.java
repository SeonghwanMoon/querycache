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
package org.apache.phoenix.schema;

import java.sql.SQLException;

import org.apache.http.annotation.Immutable;

import org.apache.phoenix.expression.ColumnExpression;
import org.apache.phoenix.expression.IndexKeyValueColumnExpression;
import org.apache.phoenix.expression.KeyValueColumnExpression;
import org.apache.phoenix.expression.RowKeyColumnExpression;
import org.apache.phoenix.util.IndexUtil;
import org.apache.phoenix.util.SchemaUtil;


/**
 * 
 * Class that represents a reference to a PColumn in a PTable
 *
 * 
 * @since 0.1
 */
@Immutable
public final class ColumnRef {
    private final TableRef tableRef;
    private final int columnPosition;
    private final int pkSlotPosition;
    
    public ColumnRef(ColumnRef columnRef, long timeStamp) {
        this.tableRef = new TableRef(columnRef.tableRef, timeStamp);
        this.columnPosition = columnRef.columnPosition;
        this.pkSlotPosition = columnRef.pkSlotPosition;
    }

    public ColumnRef(TableRef tableRef, int columnPosition) {
        if (tableRef == null) {
            throw new NullPointerException();
        }
        if (columnPosition < 0 || columnPosition >= tableRef.getTable().getColumns().size()) {
            throw new IllegalArgumentException("Column position of " + columnPosition + " must be between 0 and " + tableRef.getTable().getColumns().size() + " for table " + tableRef.getTable().getName().getString());
        }
        this.tableRef = tableRef;
        this.columnPosition = columnPosition;
        PColumn column = getColumn();
        int i = -1;
        if (SchemaUtil.isPKColumn(column)) {
            for (PColumn pkColumn : tableRef.getTable().getPKColumns()) {
                i++;
                if (pkColumn == column) {
                    break;
                }
            }
        }
        pkSlotPosition = i;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + columnPosition;
        result = prime * result + tableRef.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ColumnRef other = (ColumnRef)obj;
        if (columnPosition != other.columnPosition) return false;
        if (!tableRef.equals(other.tableRef)) return false;
        return true;
    }

    public ColumnExpression newColumnExpression() throws SQLException {
        boolean isIndex = tableRef.getTable().getType() == PTableType.INDEX;
        if (SchemaUtil.isPKColumn(this.getColumn())) {
            String name = this.getColumn().getName().getString();
            if (isIndex) {
                name = IndexUtil.getDataColumnName(name);
            }
            return new RowKeyColumnExpression(
                    getColumn(), 
                    new RowKeyValueAccessor(this.getTable().getPKColumns(), pkSlotPosition),
                    name);
        } else {
            return isIndex 
                    ? new IndexKeyValueColumnExpression(getColumn()) 
                    :  new KeyValueColumnExpression(getColumn());
        }
    }

    public int getColumnPosition() {
        return columnPosition;
    }
    
    public int getPKSlotPosition() {
        return pkSlotPosition;
    }
    
    public PColumn getColumn() {
        return tableRef.getTable().getColumns().get(columnPosition);
    }

    public PTable getTable() {
        return tableRef.getTable();
    }
    
    public TableRef getTableRef() {
        return tableRef;
    }
}
