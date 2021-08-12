package org.seras;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.seras.classes.tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GenericClassParserTestInteger.class,
                GenericClassParserTestBigDecimal.class,
                GenericClassParserTestLong.class,
                GenericClassParserTestFloat.class,
                GenericClassParserTestByte.class,
                GenericClassParserTestDouble.class
        }
)
public class GenericClassParserTestSuite {
}
