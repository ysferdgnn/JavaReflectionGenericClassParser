package org.seras.interfaces;



/*Test Generic Class Parser for Float Parse
 * @author Yusuf Erdoğan
 * @version 1.0
 *
 * test normal
 * test big number
 * test alphanumeric
 * test floating point
 * test dot
 * test multiple dots
 * test comma
 * test multiple commas
 * test start with zeros
 * test start with zeros and dots
 * test end with zeros
 * test start with zeros and end with zeros
 * test start with negative number
 * test start with negative number and contains multiple dots
 * start with negative number and contains alphanumeric and contains multiple dots
 * contains spaces
 * contains spaces and dots
 *
 * */
public interface iGenericClassParserTestNumeric {
     void initDestinationClass() ;
     void testNormal();
     void testBigNumber();
     void testAlphanumeric();
     void testFloatingPoint();
     void testDot();
     void testMultipleDots();
     void testComma();
     void testMultipleCommas();
     void testStartWithZeros();
     void testStartWithZerosAndDots();
     void testEndWithZeros();
     void testStartWithZerosAndEndWithZeros();
     void testStartWithNegativeNumber();
     void testStartWithNegativeNumberAndContainsMultipleDots();
     void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots();
     void testContainsSpaces();
     void testContainsSpacesAndDots();

}
