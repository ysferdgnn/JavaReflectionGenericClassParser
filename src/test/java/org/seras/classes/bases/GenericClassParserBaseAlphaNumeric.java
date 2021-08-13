package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestAlphaNumeric;

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

    }

    @Test
    @Override
    public void testStartWithSpaces() {

    }

    @Test
    @Override
    public void testEndWithSpaces() {

    }

    @Test
    @Override
    public void testMultipleSpaces() {

    }

    @Test
    @Override
    public void testOverFlow() {

    }

    @Test
    @Override
    public void testSpecialChars() {

    }

    @Test
    @Override
    public void testCaseSensitive() {

    }
}
