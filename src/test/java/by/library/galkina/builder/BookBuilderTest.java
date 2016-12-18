package by.library.galkina.builder;


import by.library.galkina.entity.Book;
import by.library.galkina.entity.Genre;
import by.library.galkina.exception.NullableOrEmptyArgumentException;
import junit.framework.Assert;
import org.junit.Test;

public class BookBuilderTest {
    @Test
    public void testBookBuilder(){
        Book actual = null;
        try {
            actual = (Book)BookBuilder.createBook("Book, BookName, 200, publishingHouse, Author, fantasy");
        } catch (NullableOrEmptyArgumentException e) {
            e.printStackTrace();
        }
        Book expected = new Book("BookName", 200, "publishingHouse", "Author", Genre.FANTASY);
        Assert.assertEquals(expected, actual);

    }
    @Test(expected = NullableOrEmptyArgumentException.class)
    public void testEmptyParameter(){

    }
    @Test(expected = NullableOrEmptyArgumentException.class)
    public void testNullableParameter(){

    }
}
