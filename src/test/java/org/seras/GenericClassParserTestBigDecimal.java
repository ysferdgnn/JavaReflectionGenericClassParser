package org.seras;

import org.seras.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seras.classes.GenericClassParserBase;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class GenericClassParserTestBigDecimal extends GenericClassParserBase {

    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("decimalValue", "11111");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("11111")));
    }

    @Override
    public void testBigNumber() {
        valuesMap.put("decimalValue", "9999999999999999999999999999999999999999999999999999999,99999999999999999999999999999999999");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("9999999999999999999999999999999999999999999999999999999.99999999999999999999999999999999999")));

    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("decimalValue", "111.111112313aaaa33123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(BigDecimal.ZERO));
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("decimalValue", "111,11111111111231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("111.11111111111231333123")));
    }

    @Override
    public void testDot() {
        valuesMap.put("decimalValue", "111.1");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("111.1")));
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("decimalValue", "111.1.1.111231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("11111.111231333123")));
    }

    @Override
    public void testComma() {
        valuesMap.put("decimalValue", "111.11111,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("11111111.231333123")));
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("decimalValue", "1.1.1.1.1.1.1.1,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("11111111.231333123")));
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("decimalValue", "0000000015,95444");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("15.95444")));
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("decimalValue", "000.00,00.015,9544400");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("15.95444")));
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("decimalValue", "1500,0000000");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("1500")));
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("decimalValue", "0001500,0000000");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("1500")));
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("decimalValue", "-1.000");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("-1")));
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("decimalValue", "-1.0.0.0");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("-100")));
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("decimalValue", "-1.0.0.ggggg0");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(BigDecimal.ZERO));
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("decimalValue", "  1   2  ");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("12")));
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("decimalValue", "  1.   2  ");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(0, destinationClass.decimal.compareTo(new BigDecimal("1.2")));
    }
}
