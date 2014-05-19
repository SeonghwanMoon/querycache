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
package org.apache.phoenix.expression;

import com.google.common.collect.Maps;
import org.apache.phoenix.expression.function.*;

import java.util.Map;

/**
 * 
 * Enumeration of all Expression types that may be evaluated on the server-side.
 * Used during serialization and deserialization to pass Expression between client
 * and server.
 *
 * 
 * @since 0.1
 */
public enum ExpressionType {
    ReverseFunction(ReverseFunction.class),
    RowKey(RowKeyColumnExpression.class),
    KeyValue(KeyValueColumnExpression.class),
    LiteralValue(LiteralExpression.class),
    RoundFunction(RoundFunction.class),
    FloorFunction(FloorFunction.class),
    CeilFunction(CeilFunction.class),
    RoundDateExpression(RoundDateExpression.class),
    FloorDateExpression(FloorDateExpression.class),
    CeilDateExpression(CeilDateExpression.class),
    RoundTimestampExpression(RoundTimestampExpression.class),
    CeilTimestampExpression(CeilTimestampExpression.class),
    RoundDecimalExpression(RoundDecimalExpression.class),
    FloorDecimalExpression(FloorDecimalExpression.class),
    CeilDecimalExpression(CeilDecimalExpression.class),
    TruncFunction(TruncFunction.class),
    ToDateFunction(ToDateFunction.class),
    ToCharFunction(ToCharFunction.class),
    ToNumberFunction(ToNumberFunction.class),
    CoerceFunction(CoerceExpression.class),
    SubstrFunction(SubstrFunction.class),
    AndExpression(AndExpression.class),
    OrExpression(OrExpression.class),
    ComparisonExpression(ComparisonExpression.class),
    CountAggregateFunction(CountAggregateFunction.class),
    SumAggregateFunction(SumAggregateFunction.class),
    MinAggregateFunction(MinAggregateFunction.class),
    MaxAggregateFunction(MaxAggregateFunction.class),
    LikeExpression(LikeExpression.class),
    NotExpression(NotExpression.class),
    CaseExpression(CaseExpression.class),
    InListExpression(InListExpression.class),
    IsNullExpression(IsNullExpression.class),
    LongSubtractExpression(LongSubtractExpression.class),
    DateSubtractExpression(DateSubtractExpression.class),
    DecimalSubtractExpression(DecimalSubtractExpression.class),
    LongAddExpression(LongAddExpression.class),
    DecimalAddExpression(DecimalAddExpression.class),
    DateAddExpression(DateAddExpression.class),
    LongMultiplyExpression(LongMultiplyExpression.class),
    DecimalMultiplyExpression(DecimalMultiplyExpression.class),
    LongDivideExpression(LongDivideExpression.class),
    DecimalDivideExpression(DecimalDivideExpression.class),
    CoalesceFunction(CoalesceFunction.class),
    RegexpReplaceFunction(RegexpReplaceFunction.class),
    SQLTypeNameFunction(SqlTypeNameFunction.class),
    RegexpSubstrFunction(RegexpSubstrFunction.class),
    StringConcatExpression(StringConcatExpression.class),
    LengthFunction(LengthFunction.class),
    LTrimFunction(LTrimFunction.class),
    RTrimFunction(RTrimFunction.class),
    UpperFunction(UpperFunction.class),
    LowerFunction(LowerFunction.class),
    TrimFunction(TrimFunction.class),
    DistinctCountAggregateFunction(DistinctCountAggregateFunction.class),
    PercentileContAggregateFunction(PercentileContAggregateFunction.class),
    PercentRankAggregateFunction(PercentRankAggregateFunction.class),
    StddevPopFunction(StddevPopFunction.class),
    StddevSampFunction(StddevSampFunction.class),
    PercentileDiscAggregateFunction(PercentileDiscAggregateFunction.class),
    DoubleAddExpression(DoubleAddExpression.class),
    DoubleSubtractExpression(DoubleSubtractExpression.class),
    DoubleMultiplyExpression(DoubleMultiplyExpression.class),
    DoubleDivideExpression(DoubleDivideExpression.class),
    RowValueConstructorExpression(RowValueConstructorExpression.class),
    MD5Function(MD5Function.class),
    SQLTableTypeFunction(SQLTableTypeFunction.class),
    IndexStateName(IndexStateNameFunction.class),
    InvertFunction(InvertFunction.class),
    ProjectedColumnExpression(ProjectedColumnExpression.class),
    TimestampAddExpression(TimestampAddExpression.class),
    TimestampSubtractExpression(TimestampSubtractExpression.class),
    ArrayIndexFunction(ArrayIndexFunction.class),
    ArrayLengthFunction(ArrayLengthFunction.class),
    ArrayConstructorExpression(ArrayConstructorExpression.class),
    SQLViewTypeFunction(SQLViewTypeFunction.class),
    ExternalSqlTypeIdFunction(ExternalSqlTypeIdFunction.class),
    AbsFunction(AbsFunction.class);
    
    ExpressionType(Class<? extends Expression> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Expression> getExpressionClass() {
        return clazz;
    }

    private final Class<? extends Expression> clazz;

    private static final Map<Class<? extends Expression>,ExpressionType> classToEnumMap = Maps.newHashMapWithExpectedSize(3);
    static {
        for (ExpressionType type : ExpressionType.values()) {
            classToEnumMap.put(type.clazz, type);
        }
    }

    /**
     * Return the ExpressionType for a given Expression instance
     */
    public static ExpressionType valueOf(Expression expression) {
        ExpressionType type = classToEnumMap.get(expression.getClass());
        if (type == null) { // FIXME: this exception gets swallowed and retries happen
            throw new IllegalArgumentException("No ExpressionType for " + expression.getClass());
        }
        return type;
    }

    /**
     * Instantiates a DataAccessor based on its DataAccessorType
     */
    public Expression newInstance() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
