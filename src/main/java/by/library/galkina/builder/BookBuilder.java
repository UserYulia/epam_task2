package by.library.galkina.builder;


import by.library.galkina.entity.*;
import by.library.galkina.exception.NullableOrEmptyArgumentException;
import org.apache.log4j.Logger;

public class BookBuilder {
    public static final Logger LOG = Logger.getLogger(BookBuilder.class);

    public static Edition createBook(String data) throws NullableOrEmptyArgumentException {
        if(data==null||data.isEmpty()) {throw new NullableOrEmptyArgumentException();}
        String[] bookData = data.split(", ");
        Genre genre = null;
        Edition book;
        switch (bookData[5]) {
            case "detective": {
                genre = Genre.DETECTIVE;
                break;
            }
            case "novel": {
                genre = Genre.NOVEL;
                break;
            }
            case "fiction": {
                genre = Genre.FICTION;
                break;
            }
            case "non-fiction": {
                genre = Genre.NON_FICTION;
                break;
            }
            case "fantasy": {
                genre = Genre.FANTASY;
                break;
            }
            default: {
                LOG.info("Book wasn't created, because genre wasn't defined.");
            }
        }
        book = new Book(bookData[1], Integer.parseInt(bookData[2]), bookData[3],bookData[4],genre);
        return book;
    }
}
