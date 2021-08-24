package org.seras.classes.bases;

import org.junit.Before;
import org.junit.Test;
import org.seras.Classes.Pojos.DestinationClass;
import org.seras.GenericClassParser;
import org.seras.interfaces.IGenericClassParserTestDate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class GenericClassParserBaseDate implements IGenericClassParserTestDate {


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
    public void testNormal() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEmptyString() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithSpaces() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithSpaces() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testMultipleSpaces() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearDottedWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearCommaWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearSlashedWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearHyphenWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayDottedWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayCommaWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDaySlashedWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayHyphenWithTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearDottedWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearCommaWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearSlashedWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearHyphenWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayDottedWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayCommaWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDaySlashedWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayHyphenWithoutTime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testReversedString() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDot() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithDot() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDotAndEndWithDot() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithComma() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testEndWithComma() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithCommaAndEndWithComma() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearHypenWithTimeWithoutSecs() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearDotWithTimeWithoutSecs() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithYearSlashWithTimeWithoutSecs() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayHypenWithTimeWithoutSecs() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDaySlashWithTimeWithoutSecs() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testStartWithDayDotWithTimeWithoutSecs() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testExcelDatetime() throws ParseException {
        throw new NotImplementedException();
    }

    @Test
    @Override
    public void testNull() {
        throw new NotImplementedException();
    }
}
