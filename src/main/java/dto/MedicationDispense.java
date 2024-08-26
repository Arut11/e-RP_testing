package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Отпущенный препарат.
@Getter
@Setter
@AllArgsConstructor
public class MedicationDispense {

    //* Наименование
    private String name;

    //* Код, согласно справочнику handbook
    // Если справочник ЕСКЛП не используется, то необходимо указать код используемого справочника.
    // Для отпуска по справочнику ЕСКЛП указывается "esklp"
    private String code;

    //* Наименование справочника
    // При работе со справочником ЕСКЛП указывается значение “esklp”. При работе с с другим справочником (не ЕСКЛП), необходимо указать наименование этого справочника.
    // Для справочника медицинских изделий необходимо указывать значение “mi”
    // Для справочника спец. питания необходимо указывать значение “specpit”
    private String handbook;

    //* Количество
    private float count;

    // Стоимость одной упаковки
    private float price;

}
