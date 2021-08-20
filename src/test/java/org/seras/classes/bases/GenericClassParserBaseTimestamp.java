package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestTimestamp;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseTimestamp implements IGenericClassParserTestTimestamp {

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
    public void testLongNumber() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testLongNumberWithDot() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testLongNumberWithComma() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartYearWithTimeSlashFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartYearWithTimeDotFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartYearWithTimeCommaFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartDayWithTimeSlashFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartDayWithTimeDotFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDAteStartDayWithTimeCommaFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartYearWithoutTimeSlashFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartYearWithoutTimeDotFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartYearWithoutTimeCommaFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartDayWithoutTimeSlashFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartDayWithoutTimeDotFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNormalDateStartDayWithoutTimeCommaFormat() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testExcelDateWithDot() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testExcelDateWithComma() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEmptyString() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testFullAlphaNumeric() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleDots() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleCommas() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testSpecialChars() {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNullInput() {
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
    public void testIncludeMultipleSpaces() {
        throw new NotImplementedException();
    }

    @Override
    public void testNull() {
        throw new NotImplementedException();
    }
}
