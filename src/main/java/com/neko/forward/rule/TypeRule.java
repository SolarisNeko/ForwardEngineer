package com.neko.forward.rule;

import com.neko.forward.constant.ColumnTypeEnum;

/**
 * @title:
 * @description:
 * @author: SolarisNeko
 * @date: 2021/7/4
 */
public class TypeRule {

    public static String chooseDefaultColumnTypeByType(String classType) {
        switch (classType) {
            case "int":
            case "Integer": {
                return ColumnTypeEnum.INT.typeName;
            }
            case "long":
            case "Long": {
                return ColumnTypeEnum.BIG_INT.typeName;
            }
            case "String": {
                return ColumnTypeEnum.VARCHAR.typeName;
            }
            case "BigDecimal": {
                return ColumnTypeEnum.DECIMAL.typeName;
            }
            case "boolean":
            case "Boolean": {
                return ColumnTypeEnum.BOOLEAN.typeName;
            }
            default: {
                return ColumnTypeEnum.VARCHAR.typeName;
            }
        }
    }
}
