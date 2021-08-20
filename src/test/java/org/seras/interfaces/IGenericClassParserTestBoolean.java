package org.seras.interfaces;

public interface IGenericClassParserTestBoolean {

    void initDestinationClass();
    void testNormalAlpNumericTrue();
    void testNormalAlpNumericFalse();
    void testNormalNumericTrue();
    void testNormalNumericFalse();

    void testMultipleNumeric();
    void testMultipleAlphaNumeric();

    void testStartWithSpaceNumeric();
    void testStartWithSpaceAlphaNumeric();

    void testEndWithSpaceNumeric();
    void testEndWithSpaceAlphaNumeric();

    void testMultipleSpacesNumeric();
    void testMultipleSpacesAlphaNumeric();

    void testSpecialCharactersNumeric();
    void testSpecialCharactersAlphaNumeric();

    void testOverflowNumeric();
    void testOverflowAlphaNumeric();

    void testNumericAndAlphaNumeric();
    void testNumericException();
    void testAlpNumericException();
    void testNull();
    void testEmptyString();

}
