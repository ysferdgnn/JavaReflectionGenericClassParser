package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.Pojos.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestAlphaNumeric;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseAlphaNumeric implements IGenericClassParserTestAlphaNumeric {

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
    public void testEquals() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithSpaces() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithSpaces() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleSpaces() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testOverFlow() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testSpecialChars() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testCaseSensitive() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNull() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEmptyString() {
        throw new NotImplementedException();
    }
}
