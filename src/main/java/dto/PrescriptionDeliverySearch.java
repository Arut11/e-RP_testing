package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Фильтр по заказам на доставку
@Getter
@Setter
@AllArgsConstructor
public class PrescriptionDeliverySearch {

    // Статус заказа на доставку
    // Значения:
    // 0 или Delivered (Передан курьеру)
    // 1 или Done (Доставлен)
    // 2 или Canceled (Отменен)
    private Enum state;

}
