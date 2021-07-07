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
            case "java.lang.Integer": {
                return ColumnTypeEnum.INT.typeName;
            }
            case "float":
            case "java.lang.Float": {
                return ColumnTypeEnum.FLOAT.typeName;
            }
            case "long":
            case "java.lang.Long": {
                return ColumnTypeEnum.BIG_INT.typeName;
            }
            case "java.lang.String": {
                return ColumnTypeEnum.VARCHAR.typeName;
            }
            case "java.math.BigDecimal": {
                return ColumnTypeEnum.DECIMAL.typeName;
            }
            case "boolean":
            case "java.lang.Boolean": {
                return ColumnTypeEnum.BOOLEAN.typeName;
            }
            case "date":
            case "java.util.Date": {
                // datetime = "yyyy-MM-dd hh:mm:ss"
                return ColumnTypeEnum.DATE.typeName;
            }
            default: {
                return ColumnTypeEnum.VARCHAR.typeName;
            }
        }
    }
}
