package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Короткая модель назначения
@Getter
@Setter
@AllArgsConstructor
public class OrderMedicationDto {

    // Код номенклатуры в локальной системе
    private String code;

    // Наименование в локальной системе
    private String name;

    // Тип назначения
    // ФНСИ 1.2.643.5.1.13.13.99.2.651
    // 0 - Лекарственный препарат
    // 1 - Специализированный продукт лечебного питания
    // 2 - Медицинское изделие
    private Enum type;

    //* Код, соответствующий типу назначения
    // ЕСКЛП, Спец. питание, мед. изделия
    private String codeByType;

    //* Количество
    private int count;

}
