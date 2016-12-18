package by.library.galkina.factory;


import by.library.galkina.builder.BookBuilder;
import by.library.galkina.entity.*;
import by.library.galkina.exception.NotValidDataException;
import by.library.galkina.exception.NullableOrEmptyArgumentException;
import org.apache.log4j.Logger;

public class EditionFactory {
    public static final Logger LOG = Logger.getLogger(EditionFactory.class);

    public static Edition getEdition(String editionData) throws NullableOrEmptyArgumentException, NotValidDataException {
        if(editionData==null||editionData.isEmpty()) {throw new NullableOrEmptyArgumentException();}
        Edition edition = null;
        String [] data = editionData.split(", ");
        switch (data[0]){
            case "Book":{edition = BookBuilder.createBook(editionData); break; }
            case "Magazine":{edition = new Magazine(data[1],Integer.parseInt(data[2]),data[3],Integer.parseInt(data[4]));break;}
            case "Newspaper":{edition = new Newspaper(data[1],Integer.parseInt(data[2]),data[3],Integer.parseInt(data[4]));break;}
            default:LOG.info("Edition wasn't created.");
        }
        if(edition==null){
            throw new NotValidDataException();
        }

        LOG.info(edition.toString()+" was created.");
        return edition;
    }
}
