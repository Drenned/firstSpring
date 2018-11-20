package ru.spring.animals.entitles;

import org.springframework.stereotype.Component;


public class Parrot
{
    private String name = "Синдрагосса";

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}
