package com.example.springboot;

import org.mapstruct.factory.Mappers;

public class TestMapper {
    SourcetoDestination mapper= Mappers.getMapper(SourcetoDestination.class);

    public void Test(){
        Source source=new Source();

        source.setName("sourceName");
        source.setDescription("sourceDescription");
        Destination destination= mapper.sourcetoDestination(source);

        if (source.getName().equals(destination.getName())){System.out.println("1");}
    }
}
