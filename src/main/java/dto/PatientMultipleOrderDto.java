package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Заказ на ЛП, МИ, Спец. питание
@Getter
@Setter
@AllArgsConstructor
public class PatientMultipleOrderDto {
    //* Уникальный идентификатор заказа в формате UUID
    // Формат: ^[0-9A-Fa-f]{8}\-[0-9A-Fa-f]{4}\-[0-9A-Fa-f]{4}\-[0-9A-Fa-f]{4}\-[0-9A-Fa-f]{12}$
    private UUID uid;

    //* Данные статуса заказа
    // Модель OrderStateDto
    private List<OrderStateDto> state;

    // Номер заказа
    private String number;

    //* Дата создания заказа
    // yyyy-MM-dd
    private LocalDateTime creationDateTime;

    //* Подразделение
    // Модель Subdivision
    private List<Subdivision> subdivision;

    // Адрес
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    //* ФИО пациента
    private String patientFullName;

    // Номер мобильного телефона пациента
    private String patientMPhone;

    // Комментарий к отмене заказа
    // Для статусов "Отменен (пациентом)", "Отказано в обслуживании (аптекой)"
    private String cancelComment;

    // Рецепты
    // Модель OrderPrescription
    private List<OrderPrescription> orderPrescriptions;

}
