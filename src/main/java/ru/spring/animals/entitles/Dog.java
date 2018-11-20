package ru.spring.animals.entitles;

import org.springframework.stereotype.Component;


public class Dog
{
    private String name = "Артас";

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }
}
