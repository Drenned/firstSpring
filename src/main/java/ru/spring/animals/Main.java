package ru.spring.animals;

import WeekDays.WeekDay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.spring.animals.entitles.Cat;
import ru.spring.animals.entitles.Dog;
import ru.spring.animals.entitles.Parrot;

public class Main
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext( "ru.spring.animals.configs" );

        Cat cat = context.getBean( Cat.class );
        Dog dog = context.getBean( Dog.class );
        Parrot parrot = context.getBean( Parrot.class );

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());

        WeekDay weekDay = context.getBean( WeekDay.class );
        System.out.println("Сегодня :" + weekDay.getWeekDayName());
    }
}
