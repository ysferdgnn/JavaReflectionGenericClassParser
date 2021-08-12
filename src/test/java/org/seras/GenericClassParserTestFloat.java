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
public class GenericClassParserTestFloat {

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
    public void testMapToClassFloatNormal() {
        valuesMap.put("float", "1");
        fieldMatchMap.put("float", "floatVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal, 1f, 0);
    }

    @Test
    public void testMapToClassFloatBigNumber(){

        valuesMap.put("float","999999999999999999999999999999999999999999999999999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,0f,0);
    }

    @Test
    public void testMapToClassFloatWithFloatingPoint(){
        valuesMap.put("float","999,999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,999.999f,0);
    }

    @Test
    public void testMapToClassFloatWithAlphaNumeric(){
        valuesMap.put("float","99a9,99a9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,0f,0);
    }

    @Test
    public void testMapToClassFloatFloatingPoint(){
        valuesMap.put("float","9,999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9.999999999f,0);
    }

    @Test
    public void testMapToClassFloatWithDot(){
        valuesMap.put("float","9.999999999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9.999999999f,0);
    }

    @Test
    public void testMapToClassFloatWithMultipleDots(){
        valuesMap.put("float","9.9.9.9.9.99999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99999.99999f,0);
    }

    @Test
    public void testMapToClassFloatWithComma(){
        valuesMap.put("float","9,99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9.99f,0);
    }

    @Test
    public void testMapToClassFloatWithMultipleCommas(){
        valuesMap.put("float","9,9,9,9,9,99999");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99999.99999f,0);
    }

    @Test
    public void testMapToClassFloatStartWithZeros(){
        valuesMap.put("float","0000099,99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Test
    public void testMapToClassFloatStartWithZerosAndDots(){
        valuesMap.put("float","0000099.99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Test
    public void testMapToClassFloatEndWithZeros(){
        valuesMap.put("float","99.99000000");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Test
    public void testMapToClassFloatStartWithZerosAndEndWithZeros(){
        valuesMap.put("float","00099.99000000");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,99.99f,0);
    }

    @Test
    public void testMapToClassFloatStartWithNegativeNumber(){
        valuesMap.put("float","-99.99");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,-99.99f,0);
    }

    @Test
    public void testMapToClassFloatStartWithNegativeNumberAndContainsMultipleDots(){
        valuesMap.put("float","-99.9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,-999.9f,0);
    }

    @Test
    public void testMapToClassFloatStartWithNegativeNumberAndAlphanumericAndContainsMultipleDots(){
        valuesMap.put("float","-99abc.9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,0f,0);
    }

    @Test
    public void testMapToClassFloatContainsSpaces(){
        valuesMap.put("float","9 99 9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,9999f,0);
    }

    @Test
    public void testMapToClassFloatContainsSpacesAndDots(){
        valuesMap.put("float","9 9 9.9");
        fieldMatchMap.put("float","floatVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.floatVal,999.9f,0);
    }
}
