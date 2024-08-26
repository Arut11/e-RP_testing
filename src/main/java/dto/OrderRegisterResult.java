package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
