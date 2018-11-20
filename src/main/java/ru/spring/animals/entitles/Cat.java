package ru.spring.animals.entitles;

import org.springframework.stereotype.Component;


public class Cat
{
    private String name = "Джайна";

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}
