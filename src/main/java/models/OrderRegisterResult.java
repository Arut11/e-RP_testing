package models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель результата регистрации заказа
@Getter
@Setter
@AllArgsConstructor
public class OrderRegisterResult {

  //* Данные статуса заказа
  // Модель OrderStateDto
  private List<OrderStateDto> state;

  //* Уникальный идентификатор
  private String uid;

}
