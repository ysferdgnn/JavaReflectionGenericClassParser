package org.ysferdgnn.classes.tests;

import org.junit.Assert;
import org.ysferdgnn.classes.bases.GenericClassParserBaseNumeric;


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

public class GenericClassParserTestLong extends GenericClassParserBaseNumeric {

    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormal() {
        valuesMap.put("longValue", "154");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 154, 0);
    }

    @Override
    public void testBigNumber() {
        valuesMap.put("longValue", "9999999999999999999999999999999999999999999999999999");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 0L, 0);
    }

    @Override
    public void testAlphanumeric() {
        valuesMap.put("longValue", "99aavb,899");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 0L, 0);
    }

    @Override
    public void testFloatingPoint() {
        valuesMap.put("longValue", "99,899");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 99L, 0);
    }

    @Override
    public void testDot() {
        valuesMap.put("longValue", "0.99");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 0L, 0);
    }

    @Override
    public void testMultipleDots() {
        valuesMap.put("longValue", "990.0.0.0,8,99");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 9900008L, 0);
    }

    @Override
    public void testComma() {
        valuesMap.put("longValue", "1,99");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 1L, 0);
    }

    @Override
    public void testMultipleCommas() {
        valuesMap.put("longValue", "1,9,9");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 19L, 0);
    }

    @Override
    public void testStartWithZeros() {
        valuesMap.put("longValue", "0000000000000017");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 17L, 0);
    }

    @Override
    public void testStartWithZerosAndDots() {
        valuesMap.put("longValue", "0000000000000.017");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 0L, 0);
    }

    @Override
    public void testEndWithZeros() {
        valuesMap.put("longValue", "17000000000");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 17000000000L, 0);
    }

    @Override
    public void testStartWithZerosAndEndWithZeros() {
        valuesMap.put("longValue", "00017000000000");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 17000000000L, 0);
    }

    @Override
    public void testStartWithNegativeNumber() {
        valuesMap.put("longValue", "-17000000000");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), -17000000000L, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsMultipleDots() {
        valuesMap.put("longValue", "-170000.0.00.00");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), -170000000L, 0);
    }

    @Override
    public void testStartWithNegativeNumberAndContainsAlphanumericAndContainsMultipleDots() {
        valuesMap.put("longValue", "-170000adadwd.0.00.00");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 0L, 0);
    }

    @Override
    public void testContainsSpaces() {
        valuesMap.put("longValue", "  5 5 5  ");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 555L, 0);
    }

    @Override
    public void testContainsSpacesAndDots() {
        valuesMap.put("longValue", "  5. 5 5.  ");
        fieldMatchMap.put("longValue", "longVal");

        genericClassParser.parseMapToClass(valuesMap, destinationClass, fieldMatchMap);
        Assert.assertEquals(destinationClass.getLongVal(), 555L, 0);
    }

    @Override
    public void testNull() {
        valuesMap.put("longValue",null);
        fieldMatchMap.put("longValue","longVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getLongVal());
    }

    @Override
    public void testEmptyString() {
        valuesMap.put("longValue","");
        fieldMatchMap.put("longValue","longVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getLongVal());
    }
}
