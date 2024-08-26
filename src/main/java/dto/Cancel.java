package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

// Данные об отмене рецепта.
@Getter
@Setter
@AllArgsConstructor
public class Cancel {

    //* Дата отмены рецепта
    // Используем LocalDate для даты в формате yyyy-MM-dd
    private LocalDate date;

    //* Данные об авторе
    // Модель Author
    private Author author;

    // Причина отмены рецепта
    private String reasonString; // Строка для причины отмены

    // Код причины отмены рецепта
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.654 поле "Уникальный идентификатор"
    private String reasonCode;

    // Организация отменившая/аннулировавшая рецепт
    private String organizationName;

    // Подразделение отменившее/аннулировавшее рецепт
    private String subdivisionName;

}
