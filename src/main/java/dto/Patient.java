package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

// Пациент
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {

    //* Идентификатор пациента в системе-источнике
    private String localUid;

    //* Фамилия
    private String surname;

    //* Имя
    private String name;

    // Отчество
    private String patronymic;

    //* Дата рождения
    private String birthday;

    // Номер страхового полиса ОМС
    private String policyNumber;

    //* Пол
    // 0 - Male (Мужской)
    // 1 - Female (Женский)
    // 2 - Unknown (Неизвестно)
    private int gender;

    //* СНИЛС
    // Осуществляется проверка контрольной суммы СНИЛС.
    // СНИЛС должен состоять из 11 цифр и не содержать спецсимволы.
    private String snils;

    // Номер мобильного телефона пациента
    // Номер телефона должен содержать не более 10 цифр без спецсимволов.
    private String mPhone;

    // Код льготы
    // По справочнику ФНСИ. OID: 1.2.643.5.1.13.13.99.2.541. Поле "Код"
    private String privilegeCode;

}
