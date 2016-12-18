package by.library.galkina.service;


import by.library.galkina.entity.Edition;
import java.util.ArrayList;
import java.util.List;

public class EditionSearching {
    public static List<Edition> findEditionInParameter(List<Edition> editions, int minPagesCount, int maxPagesCount){
        List<Edition> selection = new ArrayList<>();
        for(Edition e:editions){
            if(e.getPagesCount()>=minPagesCount&&e.getPagesCount()<=maxPagesCount){
                selection.add(e);
            }
        }
        return selection;
    }
}
