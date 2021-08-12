package org.seras;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;

import java.util.HashMap;
import java.util.Map;

/*Test Generic Class Parser for Float Parse
 * @author Yusuf Erdoğan
 * @version 1.0
 *
 * test normal
 * test big number
 * test alphanumeric
 * test floating point
 * test dot
 * test multiple dots
 * test comma
 * test multiple commas
 * test start with zeros
 * test start with zeros and dots
 * test end with zeros
 * test start with zeros and end with zeros
 * test start with negative number
 * test start with negative number and contains multiple dots
 * start with negative number and contains alphanumeric and contains multiple dots
 * contains spaces
 * contains spaces and dots
 *
 * */
public class GenericClassParserTestByte {

    GenericClassParser<Map<String, String>, DestinationClass> genericClassParser;
    DestinationClass destinationClass;
    Map<String, String> valuesMap;
    Map<String, String> fieldMatchMap;


    @Before
    public void initDestinationClass() {
        destinationClass = new DestinationClass();
        valuesMap = new HashMap<>();
        fieldMatchMap = new HashMap<>();


        genericClassParser = new GenericClassParser<>();
    }


    @Test
    public void testMapToClassByteNormal() {
        valuesMap.put("byte", "1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 1, 0);
    }

    @Test
    public void testMapToClassByteBigNumber() {
        valuesMap.put("byte", "999");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteAlphanumeric() {
        valuesMap.put("byte", "14abc");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteFloatingPoint() {
        valuesMap.put("byte", "14.4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteDot() {
        valuesMap.put("byte", "14.4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }
    @Test
    public void testMapToClassByteMultipleDots() {
        valuesMap.put("byte", "14.4.4.4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteComma() {
        valuesMap.put("byte", "14,4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteMultipleCommas() {
        valuesMap.put("byte", "14,4");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteStartWithZeros() {
        valuesMap.put("byte", "0000000014");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 14, 0);
    }

    @Test
    public void testMapToClassByteStartWithZerosAndEndWithZeros() {
        valuesMap.put("byte", "000000001400000");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteStartWithNegativeNumber() {
        valuesMap.put("byte", "-15");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, -15, 0);
    }

    @Test
    public void testMapToClassByteStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("byte", "-15.1.1.1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteStartWithNegativeNumberAndContainsMultipleDotsAndAlphanumeric() {
        valuesMap.put("byte", "-15.1adads.1.1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

    @Test
    public void testMapToClassByteContainsSpaces() {
        valuesMap.put("byte", "1        1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 11, 0);
    }

    @Test
    public void testMapToClassByteContainsSpacesAndContainsDots() {
        valuesMap.put("byte", "1     .   1");
        fieldMatchMap.put("byte", "byteVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.byteVal, 0, 0);
    }

}
