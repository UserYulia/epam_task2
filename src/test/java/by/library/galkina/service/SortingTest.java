package by.library.galkina.service;


import by.library.galkina.entity.*;
import by.library.galkina.exception.NotValidDataException;
import by.library.galkina.exception.NullableOrEmptyArgumentException;
import by.library.galkina.exception.WrongFileNameException;
import by.library.galkina.factory.EditionFactory;
import by.library.galkina.reader.TxtFileReader;
import by.library.galkina.validator.DataValidator;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingTest {
    private static List<Edition> editions = new ArrayList<>();
    @BeforeClass
    public static void init() throws WrongFileNameException, NotValidDataException, NullableOrEmptyArgumentException {
        List<String> data = DataValidator.testData(TxtFileReader.readData("src/main/resources/data.txt"));
        for(String line: data){
            editions.add(EditionFactory.getEdition(line));
        }
    }
    @AfterClass
    public static void destroy(){
        editions.clear();
    }
    @Test
    public void testSortingByName(){
        List<Edition> actual = EditionsSort.sortByName(editions);
        List<Edition> expected = new ArrayList<>();
        expected.add(new Book("BookName", 200, "publishingHouse", "Author", Genre.FANTASY));
        expected.add(new Magazine("Magazine", 43, "publishing house", 14));
        expected.add(new Newspaper("Newspaper", 10, "publishing house", 2));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testSortingByPages(){
        List<Edition> actual = EditionsSort.sortByPages(editions);
        List<Edition> expected = new ArrayList<>();
        expected.add(new Newspaper("Newspaper", 10, "publishing house", 2));
        expected.add(new Magazine("Magazine", 43, "publishing house", 14));
        expected.add(new Book("BookName", 200, "publishingHouse", "Author", Genre.FANTASY));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSortingByNameAndPages(){
        Magazine magazine = new Magazine("Magazine", 45, "publishing house", 14);
        editions.add(magazine);
        List<Edition> actual = EditionsSort.sortByNameAndPages(editions);
        List<Edition> expected = new ArrayList<>();
        expected.add(new Book("BookName", 200, "publishingHouse", "Author", Genre.FANTASY));
        expected.add(new Magazine("Magazine", 43, "publishing house", 14));
        expected.add(new Magazine("Magazine", 45, "publishing house", 14));
        expected.add(new Newspaper("Newspaper", 10, "publishing house", 2));
        Assert.assertEquals(expected,actual);
        editions.remove(magazine);
    }
}
