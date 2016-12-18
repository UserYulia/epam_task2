package by.library.galkina.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    final static Pattern BOOK_REG_EXP = Pattern.compile("Book, [^,]{1,45}, \\d{1,4}, [^,]{1,50}, [a-zA-Z]{1,50}, [a-zA-Z]{1,25}");
    final static Pattern MAGAZINE_REG_EXP = Pattern.compile("Magazine, [^,]{1,45}, \\d{1,4}, [^,]{1,50}, \\d{1,25}");
    final static Pattern NEWSPAPER_REG_EXP = Pattern.compile("Newspaper, [^,]{1,45}, \\d{1,4}, [^,]{1,50}, \\d{1,25}");

    public static List<String> testData(List<String> data){
        List<String> correctData = new ArrayList<>();
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(MAGAZINE_REG_EXP);
        patterns.add(BOOK_REG_EXP);
        patterns.add(NEWSPAPER_REG_EXP);
        Matcher matcher;
        int i;
        for(String str: data){
            i = 0;
            while (patterns.size()>i){
                matcher = patterns.get(i).matcher(str);
                if(matcher.matches()){
                    correctData.add(str);
                    break;
                }
                i++;
            }
        }
        return correctData;
    }
}
