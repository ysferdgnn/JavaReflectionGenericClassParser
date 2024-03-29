package org.ysferdgnn.classes.tests;

import org.junit.Assert;
import org.ysferdgnn.classes.bases.GenericClassParserBaseNumeric;

public class GenericClassParserTestFloat extends GenericClassParserBaseNumeric {


    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("float", "1");
        fieldMatchMap.put("float", "floatVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(), 1f, 0);
    }

    @Override
    public void testBigNumber() {
        valuesMap.put("float","999999999999999999999999999999999999999999999999999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),0f,0);
    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("float","99a9,99a9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),0f,0);
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("float","9,999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),9.999999999f,0);
    }

    @Override
    public void testDot() {
        valuesMap.put("float","9.999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),9.999999999f,0);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("float","9.9.9.9.9.99999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),99999.99999f,0);
    }

    @Override
    public void testComma() {
        valuesMap.put("float","9,99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),9.99f,0);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("float","9,9,9,9,9,99999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),99999.99999f,0);
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("float","0000099,99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),99.99f,0);
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("float","0000099.99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),99.99f,0);
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("float","99.99000000");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),99.99f,0);
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("float","00099.99000000");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),99.99f,0);
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("float","-99.99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),-99.99f,0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("float","-99.9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),-999.9f,0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("float","-99abc.9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),0f,0);
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("float","9 99 9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),9999f,0);
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("float","9 9 9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getFloatVal(),999.9f,0);
    }

    @Override
    public void testNull() {
        valuesMap.put("float",null);
        fieldMatchMap.put("float","doubleVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getFloatVal());
    }

    @Override
    public void testEmptyString() {
        valuesMap.put("float","");
        fieldMatchMap.put("float","doubleVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getFloatVal());
    }
}
