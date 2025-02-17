package models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
