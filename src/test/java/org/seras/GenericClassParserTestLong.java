package org.seras;

import org.seras.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GenericClassParserTestLong {

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
    @Test
    public void testMapToClassLongStartsWithZerosAndEndsWithZeros() {
        valuesMap.put("longValue", "00017000000000");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 17000000000L, 0);
    }

    @Test
    public void testMapToClassLongStartsWithNegativeNumber() {
        valuesMap.put("longValue", "-17000000000");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, -17000000000L, 0);
    }

    @Test
    public void testMapToClassLongStartsWithNegativeNumberContainsMultipleDots() {
        valuesMap.put("longValue", "-170000.0.00.00");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, -170000000L, 0);
    }

    @Test
    public void testMapToClassLongStartsWithNegativeNumberAndAlphanumericAndContainsMultipleDots() {
        valuesMap.put("longValue", "-170000adadwd.0.00.00");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 0L, 0);
    }

    @Test
    public void testMapToClassLongContainsSpaces() {
        valuesMap.put("longValue", "  5 5 5  ");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 555L, 0);
    }

    @Test
    public void testMapToClassLongContainsSpacesAndDots() {
        valuesMap.put("longValue", "  5. 5 5.  ");
        fieldMatchMap.put("longValue", "longval");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.longval, 555L, 0);
    }

}
