package by.library.galkina.service;


import by.library.galkina.entity.Edition;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EditionsSort {
    public static List<Edition> sortByName(List<Edition> editions){
        Comparator<Edition> byNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(editions, byNameComparator);
        return editions;
    }

    public static List<Edition> sortByPages(List<Edition> editions){
        Comparator<Edition> byPagesComparator = (o1, o2) -> {
            Integer pages1 = o1.getPagesCount();
            Integer pages2 = o2.getPagesCount();
            return pages1.compareTo(pages2);
        };
        Collections.sort(editions, byPagesComparator);
        return editions;
    }

    public static List<Edition> sortByNameAndPages(List<Edition> editions){
        Comparator<Edition> byNameAndPagesComparator = (o1, o2) -> {
            if(o1.getName().compareTo(o2.getName())==0){
                Integer pages1 = o1.getPagesCount();
                Integer pages2 = o2.getPagesCount();
                return pages1.compareTo(pages2);
            }
            return o1.getName().compareTo(o2.getName());
        };
        Collections.sort(editions, byNameAndPagesComparator );
        return editions;
    }
}
