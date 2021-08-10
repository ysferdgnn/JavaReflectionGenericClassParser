package org.example;

import org.example.Classes.DestinationClass;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GenericClassParserTest {

    GenericClassParser genericClassParser;
    DestinationClass destinationClass;
    Map<String,String> valuesMap;
    Map<String,String> fieldMatchMap;


    @Before
    public void initDestinationClass(){
        destinationClass=new DestinationClass();
        valuesMap = new HashMap<>();
        fieldMatchMap = new HashMap<>();


        genericClassParser = new GenericClassParser();
    }

    @Test
    public void testMapToClassIntegerMaxErrorCase(){
        // number bigger than integer max test
        valuesMap.put("integerValue","12199354420");
        fieldMatchMap.put("integerValue","integerValue");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        assertEquals(destinationClass.integerValue,0,0);
    }
    @Test
    public void testMapToClassIntegerMax(){
        valuesMap.put("integerValue","1254");
        fieldMatchMap.put("integerValue","integerValue");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        assertEquals(destinationClass.integerValue,1254,0);
    }
    @Test
    public void testMapToClassIntegerWithDoubleValue(){
        valuesMap.put("integerValue","123.123");
        fieldMatchMap.put("integerValue","integerValue");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        assertEquals(destinationClass.integerValue,123,0);
    }

    @Test
    public void testMapToClassIntegerWithDoubleValueMultipleComma(){
        valuesMap.put("integerValue","123.123,154");
        fieldMatchMap.put("integerValue","integerValue");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        assertEquals(destinationClass.integerValue,123123,0);
    }

}
