package org.parom.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.parom.hibernate.converter.BirthdayConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersanalInfo {


    private String firstname;
    private String lastname;

//    //нужно подсказать hibernate как мы собираемся конвертировать поле
//    @Convert(converter = BirthdayConverter.class)
//    @Column(name= "birth_date")
    private Birthday birthDate;
}
