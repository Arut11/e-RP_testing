package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель справочника
@Getter
@Setter
@AllArgsConstructor
public class StringBaseDictionary {

    // Код
    private String code;

    // Наименование
    private String name;

}
