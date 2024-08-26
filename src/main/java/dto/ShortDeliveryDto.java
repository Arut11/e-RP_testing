package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Короткая версия модели заказа на доставку
@Getter
@Setter
@AllArgsConstructor
public class ShortDeliveryDto {

    //* Дата и время формирования
    private LocalDateTime dateCreate;

    //* Статус заказа на доставку
    // 0 или Delivered (Передан курьеру)
    // 1 или Done (Доставлен)
    // 2 или Canceled (Отменен)
    private Enum state;

}
