package pl.maciekrychlinski.beans.producers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(
        {ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier

public @interface Producer {
    ProducerType type();

    public enum ProducerType{
        SIMPLE,FILE,LOWER,UPPER;
    }
}
