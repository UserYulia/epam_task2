package by.library.galkina.service;

import by.library.galkina.entity.Book;
import by.library.galkina.entity.Edition;
import by.library.galkina.entity.Genre;
import java.util.List;


public class BookAction {
    public static int calcPagesSumByGenre(List<Edition> editions,Genre genre){
        int sum = 0;
        for(Edition e:editions){
            if(e instanceof Book&&((Book)e).getGenre().equals(genre)){
                sum+=e.getPagesCount();
            }
        }
        return sum;
    }
}
