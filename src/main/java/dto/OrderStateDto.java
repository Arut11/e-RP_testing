package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель данных статуса заказа
@Getter
@Setter
@AllArgsConstructor
public class OrderStateDto {

    //* Статус заказа
    // 0 или Awaited (Ожидает обработки)
    // 1 или Delayed (На отсроченном обслуживании)
    // 2 или Booked (Забронирован)
    // 3 или Delivered (Доставляется)
    // 4 или Completed (Выполнен)
    // 5 или Canceled (Отменен (пациентом))
    // 6 или Denied  (Отказано в обслуживании (аптекой)
    private Enum state;

    //* Название статуса
    private String name;

}
