package models;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
