package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

// Медицинский работник.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalWorker {

    //* Фамилия
    private String surname;

    //* Имя
    private String name;

    // Отчество
    private String patronymic;

    //* СНИЛС
    // Осуществляется проверка контрольной суммы СНИЛС.
    //СНИЛС должен состоять из 11 цифр и не содержать спецсимволы.
    //("^[0-9]{11}$")
    private String snils;

    // Номер мобильного телефона
    // Номер телефона должен содержать от 4 до 11 цифр без  спецсимволов.
    private String phone;

    // Уникальный идентификатор сотрудника в МИС
    private String localId;

    // Дата рождения
    // yyyy-MM-dd
    private String birthDate;

    //* Должность подписанта
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.181 поле "Код
    private String positionCode;

    //* Специальность подписанта
    // Справочник ФНСИ. OID:1.2.643.5.1.13.13.11.1066 поле "Код"
    private String specialityCode;

    //* OID структурного подразделения, в котором числится сотрудник
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.114 поле "OID структурного подразделения"
    private String departmentCode;

}
