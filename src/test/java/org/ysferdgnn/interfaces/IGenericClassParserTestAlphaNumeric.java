package org.ysferdgnn.interfaces;

public interface IGenericClassParserTestAlphaNumeric {

    void initDestinationClass();
    void testEquals();
    void testStartWithSpaces();
    void testEndWithSpaces();
    void testMultipleSpaces();
    void testOverFlow();
    void testSpecialChars();
    void testCaseSensitive();
    void testNull();
    void testEmptyString();

}
