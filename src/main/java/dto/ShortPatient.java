package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель кратких данных о пациенте
@Getter
@Setter
@AllArgsConstructor
public class ShortPatient {

    // Фамилия
    private String surname;

    // Имя
    private String name;

    // Отчество
    private String patronymic;

    // Льгота пациента
    private String privilegeCode;

    // Номер мобильного телефона пациента
    // Номер телефона должен содержать не более 10 цифр без спецсимволов.
    private String mPhone;

}
