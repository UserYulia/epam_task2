package by.library.galkina.service;

import by.library.galkina.entity.Edition;
import by.library.galkina.entity.Magazine;
import by.library.galkina.entity.Newspaper;
import by.library.galkina.exception.NotValidDataException;
import by.library.galkina.exception.NullableOrEmptyArgumentException;
import by.library.galkina.exception.WrongFileNameException;
import by.library.galkina.factory.EditionFactory;
import by.library.galkina.reader.TxtFileReader;
import by.library.galkina.validator.DataValidator;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchingTest {
    @Test
    public void testSearching() throws WrongFileNameException, NotValidDataException, NullableOrEmptyArgumentException {
        List<String> data = DataValidator.testData(TxtFileReader.readData("src/main/resources/data.txt"));
        List<Edition> editions = new ArrayList<>();
        for(String line: data){
            editions.add(EditionFactory.getEdition(line));
        }
        List<Edition> actual = EditionSearching.findEditionInParameter(editions, 9, 50);
        List<Edition> expected = new ArrayList<>();
        expected.add(new Magazine("Magazine", 43, "publishing house", 14));
        expected.add(new Newspaper("Newspaper", 10, "publishing house", 2));
        Assert.assertEquals(expected, actual);
    }
}
