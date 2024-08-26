package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель данных статуса позиции заказа
@Getter
@Setter
@AllArgsConstructor
public class PositionStateDto {

    // 	Статус позиции заказа
    // 0 - Отменен.
    // 1 - Отказано в обслуживании (аптекой
    private Enum state;

    // Название статуса
    private String name;

}
