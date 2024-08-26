package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

// Модель данных об отмене рецепта
@Getter
@Setter
@AllArgsConstructor
public class ShortCancel {

    //* Дата отмены рецепта
    // Формат: yyyy-MM-dd
    private LocalDate date;

    //* Данные об авторе
    // Модель Author
    private List<Author> author;

    // Причина отмены рецепта (строкой)
    private String reasonString;

    // Код причины отмены рецепта
    // Справочник ФНСИ 1.2.643.5.1.13.13.99.2.654 поле "Уникальный идентификатор"
    private String reasonCode;

    // Организация, отменившая рецепт
    private String organizationName;

}
