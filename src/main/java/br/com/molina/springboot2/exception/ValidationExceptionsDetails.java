package br.com.molina.springboot2.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionsDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;
}
