package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Модель статуса позиции
@Getter
@Setter
@AllArgsConstructor
public class PositionStateResult {

    //* Данные статуса позиции заказа
    // Модель PositionStateDto
    private List<PositionStateDto> state;

    //* Уникальный идентификатор в формате UUID
    private UUID uid;

}
