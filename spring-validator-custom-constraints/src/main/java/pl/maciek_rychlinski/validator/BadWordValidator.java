package pl.maciek_rychlinski.validator;


import pl.maciek_rychlinski.commons.Lang;
import pl.maciek_rychlinski.constraint.NotBadWord;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BadWordValidator implements ConstraintValidator<NotBadWord,String> {

    private Lang[] languages;

    @Override
    public void initialize(NotBadWord constraintAnnotation) {
    languages=constraintAnnotation.lang();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid=true;
        for(Lang lang:languages){
            if(lang==Lang.PL){
                valid=plFilter(value);
            }if(lang==Lang.EN){
                valid=enFilter(value);
            }
        }
    return valid;
    }

    public boolean generalFilter(String text, List<String> badWords){
        List<String> found=badWords
                .stream()
                .filter(word->text.toLowerCase().contains(word))
                .collect(Collectors.toList());
        return found.isEmpty();
    }

    public boolean plFilter(String text){
        List<String> badWords= Arrays.asList("kurcze","głupek");
        return generalFilter(text,badWords);
    }

    public boolean enFilter(String text){
        List<String> badWords=Arrays.asList("fak","madafaka");
        return generalFilter(text,badWords);
    }
}
