package by.library.galkina.reader;

import by.library.galkina.exception.WrongFileNameException;
import junit.framework.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReaderTest {
    @Test
    public void testFileReading(){
        String rightPath = "src/main/resources/data.txt";
        List<String> actual = null;
        try {
            actual = TxtFileReader.readData(rightPath);
        } catch (WrongFileNameException e) {
            e.printStackTrace();
        }
        List<String> expected = new ArrayList<>();
        expected.add("Book, BookName, 200, publishingHouse, Author, fantasy");
        expected.add("Magazine, Magazine, 43, publishing house, 14");
        expected.add("Book54, BookName1, 45, publishingHouse1, Author1, novel");
        expected.add("Newspaper, Newspaper, 10, publishing house, 2");
        Assert.assertEquals(expected, actual);
    }
}
