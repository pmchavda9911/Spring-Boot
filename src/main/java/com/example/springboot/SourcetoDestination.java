package com.example.springboot;

import org.mapstruct.Mapper;

@Mapper
public interface SourcetoDestination {
    Destination sourcetoDestination(Source source);
    Source destinationtoSource(Destination destination);
}
