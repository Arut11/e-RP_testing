package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель сортировки списка по параметрам модели
@Getter
@Setter
@AllArgsConstructor
public class OrderParam {

    // Наименование параметра без пробелов и спецсимволов (поле таблицы)
    private String paramName;

    //* Сортировка
    // 0 или asc (По возрастанию)
    // 1 или desc  (По убыванию)
    private Enum orderType;

}
