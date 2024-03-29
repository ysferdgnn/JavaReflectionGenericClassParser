package org.ysferdgnn.classes.tests;
import org.junit.Assert;
import org.ysferdgnn.classes.bases.GenericClassParserBaseNumeric;

public class GenericClassParserTestInteger extends GenericClassParserBaseNumeric {


    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("integerValue", "15");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 15, 0);
    }

    @Override
    public void testBigNumber() {
        // number bigger than integer max test
        valuesMap.put("integerValue", "12199354420");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 0, 0);
    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("integerValue", "value");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 0, 0);
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("integerValue", "125,4");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 125, 0);
    }

    @Override
    public void testDot() {
        valuesMap.put("integerValue", ",154123.123");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 154123, 0);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("integerValue", "1.1.13");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 11, 0);
    }

    @Override
    public void testComma() {
        valuesMap.put("integerValue", ",154123,123");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 154123, 0);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("integerValue", "1,1,13");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 11, 0);
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("integerValue", "0000000000015");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 15, 0);
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("integerValue", "000.0000000.015");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 0, 0);
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("integerValue", "150000");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 150000, 0);
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("integerValue", "000150000");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 150000, 0);
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("integerValue", "-500");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), -500, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("integerValue", "-500.0.0.0");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), -50000, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("integerValue", "-500aa.1.5");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 0, 0);
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("integerValue", "  10  0 ");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 100, 0);
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("integerValue", "  10  .0 ");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getIntegerValue(), 10, 0);
    }

    @Override
    public void testNull() {
        valuesMap.put("intVal",null);
        fieldMatchMap.put("intVal","integerValue");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getIntegerValue());
    }

    @Override
    public void testEmptyString() {
        valuesMap.put("intVal","");
        fieldMatchMap.put("intVal","integerValue");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getIntegerValue());
    }
}
