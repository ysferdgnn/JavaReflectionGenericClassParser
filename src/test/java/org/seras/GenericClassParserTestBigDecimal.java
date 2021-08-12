package org.seras;

import org.seras.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GenericClassParserTestBigDecimal {

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

}
