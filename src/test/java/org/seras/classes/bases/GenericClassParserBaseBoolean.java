package org.seras.classes.bases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestBoolean;

import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseBoolean implements IGenericClassParserTestBoolean {


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
    public void testNormalAlpNumericTrue() {

    }

    @Test
    @Override
    public void testNormalAlpNumericFalse() {

    }

    @Test
    @Override
    public void testNormalNumericTrue() {

    }

    @Test
    @Override
    public void testNormalNumericFalse() {

    }

    @Test
    @Override
    public void testMultipleNumeric() {

    }

    @Test
    @Override
    public void testMultipleAlphaNumeric() {

    }

    @Test
    @Override
    public void testStartWithSpaceNumeric() {

    }

    @Test
    @Override
    public void testStartWithSpaceAlphaNumeric() {

    }

    @Test
    @Override
    public void testEndWithSpaceNumeric() {

    }

    @Test
    @Override
    public void testEndWithSpaceAlphaNumeric() {

    }

    @Test
    @Override
    public void testMultipleSpacesNumeric() {

    }

    @Test
    @Override
    public void testMultipleSpacesAlphaNumeric() {

    }

    @Override
    public void testSpecialCharactersNumeric() {

    }

    @Test
    @Override
    public void testSpecialCharactersAlphaNumeric() {

    }

    @Test
    @Override
    public void testOverflowNumeric() {

    }

    @Test
    @Override
    public void testOverflowAlphaNumeric() {

    }

    @Test
    @Override
    public void testNumericAndAlphaNumeric() {

    }

    @Test
    @Override
    public void testNumericException() {

    }

    @Test
    @Override
    public void testAlpNumericException() {

    }


}
