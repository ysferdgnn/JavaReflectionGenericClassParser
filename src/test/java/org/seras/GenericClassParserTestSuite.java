package org.seras;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.seras.classes.bases.GenericClassParserBaseBoolean;
import org.seras.classes.tests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GenericClassParserTestInteger.class,
                GenericClassParserTestBigDecimal.class,
                GenericClassParserTestLong.class,
                GenericClassParserTestFloat.class,
                GenericClassParserTestByte.class,
                GenericClassParserTestDouble.class,
                GenericClassParserTestCharacter.class,
                GenericClassParserTestBoolean.class,
                GenericClassParserTestUtilDate.class,
                GenericClassParserTestSqlDate.class
        }
)
public class GenericClassParserTestSuite {
}
