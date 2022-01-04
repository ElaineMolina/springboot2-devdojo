package br.com.molina.springboot2.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {
    public String formatLocalDateTimeDatabaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss").format(localDateTime);
    }
}
