package org.parom.hibernate.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author E.Parominsky 19/01/2023 08:12
 */
public record Birthday(LocalDate birthDate) {

    public long getAge(){
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
