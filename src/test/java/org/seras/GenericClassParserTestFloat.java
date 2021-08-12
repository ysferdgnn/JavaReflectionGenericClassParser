package org.seras;

import org.junit.Assert;
import org.seras.classes.GenericClassParserBase;

public class GenericClassParserTestFloat extends GenericClassParserBase {


    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("float", "1");
        fieldMatchMap.put("float", "floatVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal, 1f, 0);
    }

    @Override
    public void testBigNumber() {
        valuesMap.put("float","999999999999999999999999999999999999999999999999999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,0f,0);
    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("float","99a9,99a9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,0f,0);
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("float","9,999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9.999999999f,0);
    }

    @Override
    public void testDot() {
        valuesMap.put("float","9.999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9.999999999f,0);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("float","9.9.9.9.9.99999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99999.99999f,0);
    }

    @Override
    public void testComma() {
        valuesMap.put("float","9,99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9.99f,0);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("float","9,9,9,9,9,99999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99999.99999f,0);
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("float","0000099,99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("float","0000099.99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("float","99.99000000");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("float","00099.99000000");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("float","-99.99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,-99.99f,0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("float","-99.9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,-999.9f,0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("float","-99abc.9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,0f,0);
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("float","9 99 9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9999f,0);
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("float","9 9 9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,999.9f,0);
    }

}
