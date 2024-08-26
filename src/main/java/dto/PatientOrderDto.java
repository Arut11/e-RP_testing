package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// Модель заказа на ЛП, МИ, Спец. питание
@Getter
@Setter
@AllArgsConstructor
public class PatientOrderDto {

    //* Данные статуса заказа
    // Модель OrderStateDto
    private List<OrderStateDto> state;

    //* Уникальный идентификатор
    private String uid;

    //* Дата создания заказа
    private LocalDateTime creationDateTime;

    // Комментарий пациента к заказу
    private String comment;

    //* Уникальный идентификатор рецепта/назначения
    private String prescriptionUid;

    //* Номер рецепта
    private String prescriptionNumber;

    //* Наименование препарата из рецепта
    private String prescriptionName;

    //* Подразделение
    // Модель Subdivision
    private List<Subdivision> subdivision;

    // Короткая модель назначения
    // Модель OrderMedicationDto
    private List<OrderMedicationDto> medication;

    // Цена
    private double price;

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

}
