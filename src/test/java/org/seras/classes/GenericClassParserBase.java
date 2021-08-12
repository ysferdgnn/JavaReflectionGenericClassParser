package org.seras.classes;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTest;

import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBase implements IGenericClassParserTest {

   public GenericClassParser<Map<String, String>, DestinationClass> genericClassParser = null;
   public DestinationClass destinationClass = null;
   public Map<String, String> valuesMap = null;
   public Map<String, String> fieldMatchMap = null;

    @Before
    @Override
    public void initDestinationClass() {
        destinationClass = new DestinationClass();
        valuesMap = new HashMap<>();
        fieldMatchMap = new HashMap<>();


        genericClassParser = new GenericClassParser<>();
    }

    @Test
    @Override
    public void testNormal() {

    }

    @Test
    @Override
    public void testBigNumber() {

    }

    @Test
    @Override
    public void testAlphanumeric() {

    }

    @Test
    @Override
    public void testFloatingPoint() {

    }

    @Test
    @Override
    public void testDot() {

    }

    @Test
    @Override
    public void testMultipleDots() {

    }

    @Test
    @Override
    public void testComma() {

    }

    @Test
    @Override
    public void testMultipleCommas() {

    }

    @Test
    @Override
    public void testStartWithZeros() {

    }

    @Test
    @Override
    public void testStartWithZerosAndDots() {

    }

    @Test
    @Override
    public void testEndWithZeros() {

    }

    @Test
    @Override
    public void testStartWithZerosAndEndWithZeros() {

    }

    @Test
    @Override
    public void testStartWithNegativeNumber() {

    }

    @Test
    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {

    }

    @Test
    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {

    }

    @Test
    @Override
    public void testContainsSpaces() {

    }

    @Test
    @Override
    public void testContainsSpacesAndDots() {

    }
}
