package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestBoolean;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalAlpNumericFalse() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalNumericTrue() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalNumericFalse() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithSpaceNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithSpaceAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithSpaceNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithSpaceAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleSpacesNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleSpacesAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Override
    public void testSpecialCharactersNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testSpecialCharactersAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testOverflowNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testOverflowAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNumericAndAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNumericException() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testAlpNumericException() {
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
