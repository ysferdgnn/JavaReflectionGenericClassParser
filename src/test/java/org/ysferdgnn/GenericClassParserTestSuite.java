package org.ysferdgnn;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.ysferdgnn.classes.tests.*;

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
                GenericClassParserTestSqlDate.class,
                GenericClassParserTestTimestamp.class,
                GenericClassParserTestClassToClass.class
        }
)
public class GenericClassParserTestSuite {
}
