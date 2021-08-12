package org.seras;

import org.seras.Classes.DestinationClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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


        genericClassParser = new GenericClassParser<>();
    }

    @Test
    public void testMapToClassIntegerNormal() {
        // number bigger than integer max test
        valuesMap.put("integerValue", "15");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 15, 0);
    }

    @Test
    public void testMapToClassIntegerBigNumber() {
        // number bigger than integer max test
        valuesMap.put("integerValue", "12199354420");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }

    @Test
    public void testMapToClassIntegerFloatingPoint() {
        valuesMap.put("integerValue", "125,4");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 125, 0);
    }


    @Test
    public void testMapToClassIntegerDot() {
        valuesMap.put("integerValue", ",154123.123");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 154123, 0);
    }

    @Test
    public void testMapToClassIntegerMultipleDots() {
        valuesMap.put("integerValue", "1.1.13");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 11, 0);
    }

    @Test
    public void testMapToClassIntegerComma() {
        valuesMap.put("integerValue", ",154123,123");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 154123, 0);
    }

    @Test
    public void testMapToClassIntegerMultipleCommas() {
        valuesMap.put("integerValue", "1,1,13");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 11, 0);
    }

    @Test
    public void testMapToClassIntegerWithAlphaNumeric() {
        valuesMap.put("integerValue", "value");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);

    }



    @Test
    public void testMapToClassIntegerWithStartsWithZeros() {
        valuesMap.put("integerValue", "0000000000015");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 15, 0);
    }

    @Test
    public void testMapToClassIntegerWithStartsWithZerosAndDots() {
        valuesMap.put("integerValue", "000.0000000.015");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }

    @Test
    public void testMapToClassIntegerWithStartsNegativeNumber(){
        valuesMap.put("integerValue", "-500");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, -500, 0);
    }

    @Test
    public void testMapToClassIntegerWithStartsNegativeNumberAndAlphaNumeric(){
        valuesMap.put("integerValue", "-500abc");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }
    @Test
    public void testMapToClassIntegerWithStartsNegativeNumberAndDot(){
        valuesMap.put("integerValue", "-500.000");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, -500, 0);
    }
    @Test
    public void testMapToClassIntegerWithStartsNegativeNumberAndMultipleDots(){
        valuesMap.put("integerValue", "-500.1.5");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, -5001, 0);
    }

    @Test
    public void testMapToClassIntegerWithStartsNegativeNumberAndAlphanumericAndMultipleDots(){
        valuesMap.put("integerValue", "-500aa.1.5");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, 0, 0);
    }

    @Test
    public void testMapToClassIntegerWithSpace(){
        valuesMap.put("integerValue", "-  10  .0 ");
        fieldMatchMap.put("integerValue", "integerValue");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.integerValue, -10, 0);
    }

}
