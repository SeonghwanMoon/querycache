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
package org.apache.phoenix.parse;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.phoenix.schema.PDataType;



/**
 * 
 * Node representing literal expressions such as 1,2.5,'foo', and NULL in SQL
 *
 * 
 * @since 0.1
 */
public class LiteralParseNode extends TerminalParseNode {
    public static final List<ParseNode> STAR = Collections.<ParseNode>singletonList(new LiteralParseNode(1));
    private final Object value;
    private final PDataType type;
    
    LiteralParseNode(Object value) {
        this.value = value;
        this.type = PDataType.fromLiteral(value);
    }

    public PDataType getType() {
        return type;
    }
    
    public Object getValue() {
        return value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
    
    @Override
    public <T> T accept(ParseNodeVisitor<T> visitor) throws SQLException {
        return visitor.visit(this);
    }

    public byte[] getBytes() {
        return type == null ? null : type.toBytes(value);
    }
    
    @Override
    public String toString() {
        return type == PDataType.VARCHAR ? ("'" + value.toString() + "'") : value == null ? "null" : value.toString();
    }
}
