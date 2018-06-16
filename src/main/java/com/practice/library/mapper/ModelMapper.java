package com.practice.library.mapper;

public class ModelMapper extends org.modelmapper.ModelMapper {
    {
        getConfiguration().setAmbiguityIgnored(true);
    }
}
