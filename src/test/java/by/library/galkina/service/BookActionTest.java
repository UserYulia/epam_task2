package by.library.galkina.service;

import by.library.galkina.entity.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookActionTest {
    @Test
    public void testPagesSumCalculating(){
        List<Edition> editions = new ArrayList<>();
        editions.add(new Newspaper("Newspaper", 10, "publishing house", 2));
        editions.add(new Magazine("Magazine", 43, "publishing house", 14));
        editions.add(new Book("BookName", 200, "publishingHouse", "Author", Genre.FANTASY));
        editions.add(new Book("BookName1", 100, "publishingHouse1", "Author", Genre.FANTASY));
        editions.add(new Book("BookName2", 150, "publishingHouse2", "Author", Genre.FANTASY));
        editions.add(new Book("BookName3", 250, "publishingHouse3", "Author", Genre.DETECTIVE));
        Assert.assertEquals(450,BookAction.calcPagesSumByGenre(editions,Genre.FANTASY));
        Assert.assertEquals(250,BookAction.calcPagesSumByGenre(editions, Genre.DETECTIVE));
        Assert.assertEquals(0,BookAction.calcPagesSumByGenre(editions, Genre.FICTION));
    }
}
