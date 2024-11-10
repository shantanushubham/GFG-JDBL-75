package com.geeksforgeeks.gfgpay.common.exceptions;

import java.util.function.Supplier;

public class NotFoundException extends RuntimeException implements Supplier<NotFoundException> {

    private final Class<?> clazz;

    private final String field;

    private final Object value;

    public NotFoundException(Class<?> clazz, String field, Object value) {
        super(String.format("Cannot find %s with the field: %s with value %s.", clazz.getName(), field, value.toString()));
        this.clazz = clazz;
        this.field = field;
        this.value = value;
    }

    @Override
    public NotFoundException get() {
        NotFoundException ex = new NotFoundException(this.clazz, this.field, this.value);
        System.out.printf(ex.getMessage());
        return ex;
    }
}
