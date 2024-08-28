package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

// Данные об авторе.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {

    //* Фамилия
    private String surname;

    //* Имя
    private String name;

    // Отчество
    private String patronymic;

    //* СНИСЛ
    // Осуществляется проверка контрольной суммы СНИЛС.
    // СНИЛС должен состоять из 11 цифр и не содержать спецсимволы.
    // ("^[0-9]{11}$")
    private String snils;

    // Номер мобильного телефонаНомер
    // телефона должен содержать от 4 до 11 цифр без  спецсимволов.
    //("^[0-9]{4,11}$")
    private String phone;



}
