package by.library.galkina.validator;


import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {
    @Test
    public void testValidator(){
        List<String> data = new ArrayList<>();
        data.add("Book, BookName, 200, publishingHouse, Author, fantasy");
        data.add("Book54, BookName1, 200, publishingHouse1, Author1, fantasy");
        List<String> actual = DataValidator.testData(data);
        List<String> expected = new ArrayList<>();
        expected.add("Book, BookName, 200, publishingHouse, Author, fantasy");
        Assert.assertEquals(expected,actual);
    }
}
