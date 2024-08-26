package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Короткая версия модели организации
@Getter
@Setter
@AllArgsConstructor
public class ShortOrganizationDto {

    //* Наименование организации (короткое)
    private LocalDateTime shortName;

    // OID медицинской организации Российской Федерации, выписавшей рецепт
    // Справочник ФНСИ 1.2.643.5.1.13.13.11.1461 поле "OID". Обязателен для выписки рецептов
    private String oid;

}
