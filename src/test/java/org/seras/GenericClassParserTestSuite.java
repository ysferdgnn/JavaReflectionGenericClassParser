package org.seras;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                GenericClassParserTestInteger.class,
                GenericClassParserTestBigDecimal.class,
                GenericClassParserTestLong.class,

        }
)
public class GenericClassParserTestSuite {
}
