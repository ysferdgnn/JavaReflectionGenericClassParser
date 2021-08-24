package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.Pojos.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestNumeric;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseNumeric implements IGenericClassParserTestNumeric {

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
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testBigNumber() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testAlphanumeric() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testFloatingPoint() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testDot() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleDots() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testComma() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleCommas() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithZeros() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithZerosAndDots() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithZeros() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithZerosAndEndWithZeros() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithNegativeNumber() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testContainsSpaces() {
     throw new NotImplementedException();
    }

    @Test
    @Override
    public void testContainsSpacesAndDots() {
     throw new NotImplementedException();
    }

 @Override
 public void testNull() {
  throw new NotImplementedException();
 }

 @Override
 public void testEmptyString() {
  throw new NotImplementedException();
 }
}
