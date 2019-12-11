package com.energizeglobal.internship.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private JsonMapper(){}
    public static ObjectMapper getInstance() {
         return OBJECT_MAPPER;
    }
}
