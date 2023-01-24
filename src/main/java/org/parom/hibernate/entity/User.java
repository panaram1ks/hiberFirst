package org.parom.hibernate.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.parom.hibernate.converter.BirthdayConverter;

import javax.persistence.*;

/**
 * @author E.Parominsky 17/01/2023 09:05
 */

@Data //lombok
@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
@Builder //lombok

@Entity //hibernate
@Table(name = "users", schema = "public")//hibernate

@TypeDef(name = "customName", typeClass = JsonBinaryType.class)//можно задать псевдонимы для типов данных
public class User {

    @Id //hibernate
    private String username;
    private String firstname;
    private String lastname;

    //нужно подсказать hibernate как мы собираемся конвертировать поле
    @Convert(converter = BirthdayConverter.class)
    @Column(name= "birth_date")
    private Birthday birthDate;

//    private Integer age;
    @Enumerated(EnumType.STRING)
    private Role role;

    //JsonBinaryType
   // @Type(type= "com.vladmihalcea.hibernate.type.json.JsonBinaryType") //или
    //@Type(type= "jsonb")//или
//    @Type(type = "customName")
//    //нужно еще этот тип зарегистрировать в configuration
//    private String info;

//    public User() {
//    }
//
//    public User(String username, String firstname, String lastname, LocalDate birthDate, Integer age) {
//        this.username = username;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.birthDate = birthDate;
//        this.age = age;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(username, user.username) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(birthDate, user.birthDate) && Objects.equals(age, user.age);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, firstname, lastname, birthDate, age);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                ", firstname='" + firstname + '\'' +
//                ", lastname='" + lastname + '\'' +
//                ", birthDate=" + birthDate +
//                ", age=" + age +
//                '}';
//    }
}
