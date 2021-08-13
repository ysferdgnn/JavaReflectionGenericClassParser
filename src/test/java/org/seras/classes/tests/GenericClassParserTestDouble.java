package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.classes.bases.GenericClassParserBaseNumeric;

public class GenericClassParserTestDouble extends GenericClassParserBaseNumeric {

    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("double", "1");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 1, 0);
    }

    @Override
    public void testBigNumber() {
        valuesMap.put("double", "999999999999999999999999999999999999999999999999999999999999999");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 999999999999999999999999999999999999999999999999999999999999999d, 0);
    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("double", "123abc123");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 0d, 0);
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("double", "12,123114455484848484");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 12.123114455484848484d, 0);
    }

    @Override
    public void testDot() {
        valuesMap.put("double", "12.123114455484848484");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 12.123114455484848484d, 0);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("double", "12.1.1.1.1.1");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 121111.1d, 0);
    }

    @Override
    public void testComma() {
        valuesMap.put("double", "12,11111");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 12.11111d, 0);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("double", "12,1,1,1,1,1");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 121111.1d, 0);
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("double", "0000000015.11");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 15.11d, 0);
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("double", "0000000.01.5.11");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 15.11, 0);
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("double", "15.00000000000000000");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 15d, 0);
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("double", "00000015.00000000000000000");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 15d, 0);
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("double", "-15.00000000000000000");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, -15d, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("double", "-15.0.0.0.0.0.000000000000");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, -1500000d, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("double", "-15.0.0.0.0.0.00asda0000000000");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, -0d, 0);
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("double", "  15  4  ");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 154d, 0);
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("double", "  15 . 4  ");
        fieldMatchMap.put("double", "doubleVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.doubleVal, 15.4d, 0);
    }
}
