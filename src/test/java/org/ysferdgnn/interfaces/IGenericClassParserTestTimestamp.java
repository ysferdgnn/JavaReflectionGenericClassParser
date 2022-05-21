package org.ysferdgnn.interfaces;

import java.text.ParseException;

public interface IGenericClassParserTestTimestamp {

    void initDestinationClass() ;
    void testLongNumber();
    void testLongNumberWithDot() throws ParseException;
    void testLongNumberWithComma() throws ParseException;

    //start year
    void testNormalDateStartYearWithTimeSlashFormat() throws ParseException;
    void testNormalDateStartYearWithTimeDotFormat() throws ParseException;
    void testNormalDateStartYearWithTimeCommaFormat() throws ParseException;

    //start day
    void testNormalDateStartDayWithTimeSlashFormat() throws ParseException;
    void testNormalDateStartDayWithTimeDotFormat() throws ParseException;
    void testNormalDAteStartDayWithTimeCommaFormat() throws ParseException;

    //start year
    void testNormalDateStartYearWithoutTimeSlashFormat() throws ParseException;
    void testNormalDateStartYearWithoutTimeDotFormat() throws ParseException;
    void testNormalDateStartYearWithoutTimeCommaFormat() throws ParseException;

    //start day
    void testNormalDateStartDayWithoutTimeSlashFormat() throws ParseException;
    void testNormalDateStartDayWithoutTimeDotFormat() throws ParseException;
    void testNormalDateStartDayWithoutTimeCommaFormat() throws ParseException;

    void testExcelDateWithDot() throws ParseException;
    void testExcelDateWithComma() throws ParseException;

    void testEmptyString();
    void testFullAlphaNumeric();
    void testMultipleDots();
    void testMultipleCommas();
    void testSpecialChars();
    void testNullInput();
    void testStartWithSpaces();
    void testEndWithSpaces();
    void testIncludeMultipleSpaces();
    void testNull();

}
