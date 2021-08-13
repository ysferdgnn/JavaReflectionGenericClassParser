package org.seras.classes.tests;

import org.junit.Assert;
import org.seras.classes.bases.GenericClassParserBaseBoolean;

public class GenericClassParserTestBoolean extends GenericClassParserBaseBoolean {
    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testNormalAlpNumericTrue() {
       valuesMap.put("bool","True");
       fieldMatchMap.put("bool","boolVal");

       genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testNormalAlpNumericFalse() {
        valuesMap.put("bool","False");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testNormalNumericTrue() {
        valuesMap.put("bool","1");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testNormalNumericFalse() {
        valuesMap.put("bool","0");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testMultipleNumeric() {
        valuesMap.put("bool","9999");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testMultipleAlphaNumeric() {
        valuesMap.put("bool","GANDALF");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testStartWithSpaceNumeric() {
        valuesMap.put("bool","   11");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testStartWithSpaceAlphaNumeric() {
        valuesMap.put("bool","   Y");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testEndWithSpaceNumeric() {
        valuesMap.put("bool","1     ");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testEndWithSpaceAlphaNumeric() {
        valuesMap.put("bool","Y     ");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testMultipleSpacesNumeric() {
        valuesMap.put("bool","1 1 1 1  ");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testMultipleSpacesAlphaNumeric() {
        valuesMap.put("bool","M E L K O R  ");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testSpecialCharactersNumeric() {
        valuesMap.put("bool","12.½$");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testSpecialCharactersAlphaNumeric() {
        valuesMap.put("bool","Y.½$\\US/,");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testOverflowNumeric() {
        valuesMap.put("bool","99999999999999999999999999999");
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertTrue(destinationClass.boolVal);
    }

    @Override
    public void testOverflowAlphaNumeric() {
        String value ="Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a " +
                "type specimen book. It has survived not only five centuries, but also the leap " +
                "into electronic typesetting, remaining essentially unchanged. It was popularised" +
                " in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,"+
                "and more recently with desktop publishing software like Aldus PageMaker including" +
                " versions of Lorem Ipsum.";

        valuesMap.put("bool",value);
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testNumericAndAlphaNumeric() {
        String value ="SHIRE123MORGOTH456";

        valuesMap.put("bool",value);
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testNumericException() {
        String value ="0,14.454599914,,,,48884444";

        valuesMap.put("bool",value);
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }

    @Override
    public void testAlpNumericException() {
        String value ="Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a " +
                "type specimen book. It has survived not only five centuries, but also the leap " +
                "into electronic typesetting, remaining essentially unchanged. It was popularised" +
                " in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,"+
                "and more recently with desktop publishing software like Aldus PageMaker including" +
                " versions of Lorem Ipsum.It is a long established fact that a reader will be distrac" +
                "ted by the readable content of a page when looking at its layout. The point of using" +
                " Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed " +
                "to using 'Content here, content here', making it look like readable English. Many deskt" +
                "op publishing packages and web page editors now use Lorem Ipsum as their default model" +
                " text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy" +
                ". Various versions have evolved over the years, sometimes by accident, sometimes on purpose" +
                " (injected humour and the like).";

        valuesMap.put("bool",value);
        fieldMatchMap.put("bool","boolVal");

        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertFalse(destinationClass.boolVal);
    }
}
