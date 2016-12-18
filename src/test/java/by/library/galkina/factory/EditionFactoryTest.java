package by.library.galkina.factory;

import by.library.galkina.entity.Book;
import by.library.galkina.entity.Genre;
import by.library.galkina.entity.Magazine;
import by.library.galkina.entity.Newspaper;
import by.library.galkina.exception.NotValidDataException;
import by.library.galkina.exception.NullableOrEmptyArgumentException;
import junit.framework.Assert;
import org.junit.Test;

public class EditionFactoryTest {
    @Test(expected = NullableOrEmptyArgumentException.class)
    public void checkNullableParameter() throws NotValidDataException, NullableOrEmptyArgumentException {
        EditionFactory.getEdition(null);
    }

    @Test(expected = NotValidDataException.class)
    public void checkNotValidData() throws NotValidDataException, NullableOrEmptyArgumentException {
        EditionFactory.getEdition("Cook, Author, house, 12");
    }

    @Test
    public void getBookTest(){
        Book actual = null;
        try {
            actual = (Book) EditionFactory.getEdition("Book, BookName, 200, publishingHouse, Author, fantasy");
        } catch (NullableOrEmptyArgumentException | NotValidDataException e) {
            e.printStackTrace();
        }
        Book expected = new Book("BookName", 200, "publishingHouse", "Author", Genre.FANTASY);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMagazineTest()  {
        Magazine actual = null;
        try {
            actual = (Magazine) EditionFactory.getEdition("Magazine, Magazine, 43, publishing house, 14");
        } catch (NullableOrEmptyArgumentException | NotValidDataException e) {
            e.printStackTrace();
        }
        Magazine expected = new Magazine("Magazine", 43, "publishing house", 14);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getNewspaperTest(){
        Newspaper actual = null;
        try {
            actual = (Newspaper) EditionFactory.getEdition("Newspaper, Newspaper, 10, publishing house, 2");
        } catch (NullableOrEmptyArgumentException | NotValidDataException e) {
            e.printStackTrace();
        }
        Newspaper expected = new Newspaper("Newspaper", 10, "publishing house", 2);
        Assert.assertEquals(expected,actual);
    }
}
