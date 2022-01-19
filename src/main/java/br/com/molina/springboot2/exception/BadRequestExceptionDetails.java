package br.com.molina.springboot2.exception;

import lombok.Builder;
import lombok.Data;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {

    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;


}
