package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Данные заказа для аптеки
@Getter
@Setter
@AllArgsConstructor
public class PharmacyMultipleOrderDto {

    //* Уникальный идентификатор заказа в формате UUID
    private UUID uid;

    //* Данные статуса заказа
    // Модель OrderStateDto
    private List<OrderStateDto> state;

    // Номер заказа
    private String number;

    //* Дата создания заказа
    private LocalDateTime creationDateTime;

    //* Подразделение
    // Модель Subdivision
    private List<Subdivision> subdivision;

    // Адрес
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    // Номер мобильного телефона пациента
    private String patientMPhone;

    // Рецепты
    // Модель OrderPrescription
    private List<OrderPrescription> orderPrescriptions;

}
