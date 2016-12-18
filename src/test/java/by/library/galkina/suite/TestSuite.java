package by.library.galkina.suite;

import by.library.galkina.factory.EditionFactoryTest;
import by.library.galkina.reader.TxtFileReaderTest;
import by.library.galkina.service.SearchingTest;
import by.library.galkina.service.SortingTest;
import by.library.galkina.validator.DataValidatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({TxtFileReaderTest.class, DataValidatorTest.class, EditionFactoryTest.class, SortingTest.class, SearchingTest.class})
@RunWith(Suite.class)
public class TestSuite {
}
