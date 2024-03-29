package org.ysferdgnn.classes.tests;

import org.junit.Assert;
import org.ysferdgnn.classes.bases.GenericClassParserBaseAlphaNumeric;

public class GenericClassParserTestCharacter extends GenericClassParserBaseAlphaNumeric {
    @Override
    public void initDestinationClass() {
        super.initDestinationClass();
    }

    @Override
    public void testEquals() {
        valuesMap.put("charVal","C");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'C',0);

    }

    @Override
    public void testStartWithSpaces() {
        valuesMap.put("charVal"," C");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'C',0);
    }

    @Override
    public void testEndWithSpaces() {
        valuesMap.put("charVal","C " );
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'C',0);
    }

    @Override
    public void testMultipleSpaces() {
        valuesMap.put("charVal","      C      ");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'C',0);
    }

    @Override
    public void testOverFlow() {
        valuesMap.put("charVal","SAURON!");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'S',0);
    }

    @Override
    public void testSpecialChars() {
        valuesMap.put("charVal","/.+$%\\");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'/',0);
    }

    @Override
    public void testCaseSensitive() {
        valuesMap.put("charVal","yY");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertEquals(destinationClass.getCharVal(),'y',0);
    }

    @Override
    public void testNull() {
        valuesMap.put("charVal",null);
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getCharVal());
    }

    @Override
    public void testEmptyString() {
        valuesMap.put("charVal","");
        fieldMatchMap.put("charVal","charVal");
        genericClassParser.parseMapToClass(valuesMap,destinationClass,fieldMatchMap);
        Assert.assertNull(destinationClass.getCharVal());
    }
}
