package ru.spring.animals.configs;

import WeekDays.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.spring.animals.entitles.Cat;
import ru.spring.animals.entitles.Dog;
import ru.spring.animals.entitles.Parrot;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
public class MyConfig
{
    @Bean
    public Cat getCat(Parrot parrot)
    {
        Cat cat = new Cat();
        cat.setName( parrot.getName()+" - killer" );
        return cat;
    }
    @Bean
    public Dog getDog()
    {
        return new Dog();
    }
    @Bean("parrot-kesha")
    public Parrot getParrot()
    {
        return new Parrot();
    }

    @Bean
    public WeekDay getDay()
    {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch( dayOfWeek )
        {
            case MONDAY: return new Monday();
            case TUESDAY: return new Tuesday();
            case WEDNESDAY: return new Wednesday();
            case THURSDAY: return new Thursday();
            case FRIDAY: return new Friday();
            case SATURDAY: return new Saturday();
            case SUNDAY: return new Sunday();
            default: return  new Sunday();
        }
    }
}
