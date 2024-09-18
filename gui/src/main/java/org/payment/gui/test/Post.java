package org.payment.gui.test;
import java.time.LocalDate;

public record Post(
       String id,
        String title,
        String slug,
        LocalDate date,
        int timeToRead,
        String tags,

        Integer version
) {

}