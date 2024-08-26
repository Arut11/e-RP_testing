package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// Модель адреса по ФИАС
@Getter
@Setter
@AllArgsConstructor
public class FiasDto {

    // Идентификатор объекта по ФИАС
    private UUID object;

    // Идентификатор города по ФИАС
    private UUID city;

    // Идентификатор улицы по ФИАС
    private UUID street;

}
