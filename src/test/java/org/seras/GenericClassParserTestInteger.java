package org.seras;

import org.seras.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GenericClassParserTestInteger {
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

}
