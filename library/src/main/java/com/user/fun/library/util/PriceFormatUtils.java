package com.user.fun.library.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created  on 2019/3/12.
 *
 * @author CPing
 * Email yy_cping@163.com
 * edit androidStudio
 */
public class PriceFormatUtils {
    public static String formatPrice(Double price) {
        if (price == null) {
            return "";
        }
        DecimalFormat decimalFormat;
        if (price == 0)
            decimalFormat = new DecimalFormat("###################.##");
        else
            decimalFormat = new DecimalFormat("##################0.00");
        return decimalFormat.format(price);
    }

    public static String formatPriceNoZero(Double price) {
        if (price == null) {
            return "";
        }
        DecimalFormat decimalFormat;
        if (price == 0)
            decimalFormat = new DecimalFormat("###################.##");
        else
            decimalFormat = new DecimalFormat("##################0.##");
        return decimalFormat.format(price);
    }
    /**
     * 提供精确加法计算的add方法
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确减法运算的sub方法
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static String mul(double value1, double value2) {
        return formatPrice(mulDouble(value1, value2));
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double mulDouble(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * * 提供精确的除法运算方法div
     * * @param value1 被除数
     * * @param value2 除数
     * * @param scale 精确范围
     * * @return 两个参数的商
     * * @throws IllegalAccessException
     */
    public static double div(double value1, double value2, int scale) throws
            IllegalAccessException {
        //如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.divide(b2, scale).doubleValue();
    }

}
