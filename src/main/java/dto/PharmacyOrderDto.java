package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// Модель данных заказа для аптеки
@Getter
@Setter
@AllArgsConstructor
public class PharmacyOrderDto {

    //* Данные статуса заказа
    // Модель OrderStateDto
    private OrderStateDto state;

    //* Уникальный идентификатор
    private String uid;

    //* Дата создания заказа
    private LocalDateTime creationDateTime;

    //* Уникальный идентификатор рецепта/назначения
    private String prescriptionUid;

    // Цена
    private double price;

    //* Подразделение
    // Модель Subdivision
    private List<Subdivision> subdivision;

    // Серия рецепта/назначения
    private String prescriptionSeries;

    //* Номер рецепта/назначения
    private String prescriptionNumber;

    //* Наименование препарата из рецепта
    private String prescriptionName;

    // Короткая модель назначения
    // Модель OrderMedicationDto
    private List<OrderMedicationDto> medication;

    // Адрес
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    // Номер мобильного телефона пациента
    // Номер телефона должен содержать не более 10 цифр без спецсимволов
    private String patientMPhone;

}
