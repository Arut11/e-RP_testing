package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Модель подразделения.
@Getter
@Setter
@AllArgsConstructor
public class Subdivision {

    //* Наименование
    private String name;

    // Уникальный код подразделения
    // Обязателен, если не заполнен oid
    private String code;

    // OID подразделения по ФРМО
    // Справочник ФНСИ 1.2.643.5.1.13.13.99.2.114 поле "OID". Обязателен для выписки рецептов
    private String oid;

    // Телефон руководителя
    // Номер телефона должен содержать от 4 до 11 цифр без спецсимволов.
    private String directorPhone;

    // Адрес
    private String address;

    // Код вида подразделения
    // По справочнику ФНСИ. oid 1.2.643.5.1.13.13.11.1072
    private String kindCode;

    // Часы работы
    // Модель WorkdayDto
    private List<WorkdayDto> workingHours;

    // Широта
    private String latitude;

    // Долгота
    private String longitude;

}
