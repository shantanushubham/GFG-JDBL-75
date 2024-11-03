package com.geeksforgeeks.gfgpay.common.exceptions;

public class NotFoundException extends RuntimeException {

    private Class<?> clazz;

    private String field;

    private Object value;

    public NotFoundException(Class<?> clazz, String field, Object value) {
        super(String.format("Cannot find %s with the field: %s with value %s.", clazz.getName(), field, value.toString()));
    }

}
