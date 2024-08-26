package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель базовых персональных данных
@Setter
@Getter
@AllArgsConstructor
public class BasePersonalData {

    // Фамилия
    private String surname;

    // Имя
    private String name;

    // Отчество
    private String patronymic;

}
