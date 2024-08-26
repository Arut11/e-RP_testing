package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Аннулирование рецепта.
@Getter
@Setter
@AllArgsConstructor
public class ReleaseCancel {

    //* Причина аннулирования
    private String reason;

    // Код причины аннулирования
    // Справочник ФРНСИ. OID: 1.2.643.5.1.13.13.99.2.654
    private int reasonFederalCode;

}
