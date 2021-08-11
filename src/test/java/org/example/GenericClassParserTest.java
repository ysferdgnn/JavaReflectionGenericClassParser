package org.example;


import org.example.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;



public class GenericClassParserTest {

    GenericClassParser<Map<String, String>, DestinationClass> genericClassParser;
    DestinationClass destinationClass;
    Map<String, String> valuesMap;
    Map<String, String> fieldMatchMap;


    @Before
    public void initDestinationClass() {
        destinationClass = new DestinationClass();
        valuesMap = new HashMap<>();
        fieldMatchMap = new HashMap<>();


        genericClassParser = new GenericClassParser<Map<String, String>, DestinationClass>();
    }

    @Test
    public void testMapToClassIntegerMaxErrorCase() {
        // number bigger than integer max test
        valuesMap.put("integerValue", "12199354420");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }

    @Test
    public void testMapToClassIntegerMax() {
        valuesMap.put("integerValue", "1254");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 1254, 0);
    }

    @Test
    public void testMapToClassIntegerWithDoubleValue() {
        valuesMap.put("integerValue", "123.123");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 123, 0);
    }

    @Test
    public void testMapToClassIntegerWithDoubleValueMultipleComma() {
        valuesMap.put("integerValue", ",154123.123");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 154123, 0);
    }

    @Test
    public void testMapToClassIntegerWithAlphaNumericValue() {
        valuesMap.put("integerValue", "value");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);

    }

    @Test
    public void testMapToClassIntegerWithAlphanumericAndNumeric() {
        valuesMap.put("integerValue", "value546");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }

    @Test
    public void testMapToClassIntegerWithMultipleCommas() {
        valuesMap.put("integerValue", "1,2,1,1,11");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 1211, 0);
    }

    @Test
    public void testMapToClassIntegerWithStartsWithZeros() {
        valuesMap.put("integerValue", "0000000000015");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 15, 0);
    }

    @Test
    public void testMapToClassIntegerWithStartsWithZerosAndDotsAndCommas() {
        valuesMap.put("integerValue", "000.000,0000,015");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }

    @Test
    public void testMapToClassBigDecimalNormal() {
        valuesMap.put("decimalValue", "11111");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalBigNumber() {
        valuesMap.put("decimalValue", "9999999999999999999999999999999999999999999999999999999,99999999999999999999999999999999999");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("9999999999999999999999999999999999999999999999999999999.99999999999999999999999999999999999")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithComma() {
        valuesMap.put("decimalValue", "111.11111,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111111.231333123")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithMultipleComma() {
        valuesMap.put("decimalValue", "1.1.1.1.1.1.1.1,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("11111111.231333123")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithAlphaNumericAndNumericMixed() {
        valuesMap.put("decimalValue", "1abcde14,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("0")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithAlphaNumericAndNumericAndMultipleDotsMixed() {
        valuesMap.put("decimalValue", "1a.b.c.d,e,1,4,231333123");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("0")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithStartWithZeros() {
        valuesMap.put("decimalValue", "0000000015,95444");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("15.95444")) == 0);
    }

    @Test
    public void testMapToClassBigDecimalWithStartWithZerosAndCommasAndDots() {
        valuesMap.put("decimalValue", "000.00,00.015,9544400");
        fieldMatchMap.put("decimalValue", "decimal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertTrue(destinationClass.decimal.compareTo(new BigDecimal("15.95444")) == 0);
    }


    @Test
    public void testMapToClassLongNormal() {
        valuesMap.put("longValue", "154");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 154, 0);
    }

    @Test
    public void testMapToClassLongBigNumber() {
        valuesMap.put("longValue", "9999999999999999999999999999999999999999999999999999");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 0L, 0);
    }

    @Test
    public void testMapToClassLongWithFloatingPoint() {
        valuesMap.put("longValue", "99,899");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 99L, 0);
    }
    @Test
    public void testMapToClassLongAlphanumeric() {
        valuesMap.put("longValue", "99aavb,899");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 0L, 0);
    }

    @Test
    public void testMapToClassLongMultipleDots() {
        valuesMap.put("longValue", "990.0.0.0,8,99");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 9900008L, 0);
    }

    @Test
    public void testMapToClassLongStartsWithZeros() {
        valuesMap.put("longValue", "0000000000000017");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 17L, 0);
    }

    @Test
    public void testMapToClassLongStartsWithZerosWithDots() {
        valuesMap.put("longValue", "0000000000000.017");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 0L, 0);
    }

    @Test
    public void testMapToClassLongEndsWithZeros() {
        valuesMap.put("longValue", "17000000000");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 17000000000L, 0);
    }
}
