package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// Модель данных о бронировании заказа
@Getter
@Setter
@AllArgsConstructor
public class OrderDeliveryDto {

    //* Дата установления статуса
    private LocalDate date;

    //* Состояние доставки
    private String status;

}
