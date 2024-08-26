package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// Модель статусов заказов на доставку
@Getter
@Setter
@AllArgsConstructor
public class DeliveryStateDto {

    // Идентификатор заказа
    private UUID uid;

    // Статус заказа на доставку
    // Значения:
    // 0 или Delivered (Передан курьеру)
    // 1 или Done (Доставлен)
    // 2 или Canceled (Отменен)
    private Enum state;

}
