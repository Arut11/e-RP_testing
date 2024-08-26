package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Информация по заказу
@Getter
@Setter
@AllArgsConstructor
public class MultipleOrderDto {

    //* Уникальный идентификатор
    private UUID uid;

    //* Данные статуса заказа
    // Модель OrderStateDto
    private List<OrderStateDto> state;

    // Номер заказа
    private String number;

    //* Подразделение
    // Модель Subdivision
    private List<Subdivision> subdivision;

    // Короткая модель назначения
    // Модель OrderMedicationDto
    private List<OrderMedicationDto> medication;

    // Цена
    private double price;

    //* Дата создания заказа
    private LocalDate creationDateTime;

    // Адрес
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    // Номер мобильного телефона пациента
    // Номер телефона должен содержать не более 10 цифр без спецсимволов.
    private String mPhone;

    // Комментарий пациента к заказу
    private String comment;

    // Комментарий фармацевта к отказу
    private String cancelComment;

    //* Фармацевт
    // Модель ReleasePharmacist
    private List<ReleasePharmacist> denialAuthor;

    // Данные об отсроченном обслуживании заказа
    // Модель OrderDelayDto
    private List<OrderDelayDto> dalay;

    // Данные о доставке
    // Модель OrderDeliveryDto
    private List<OrderDeliveryDto> deliveries;

    // Данные о бронировании заказа
    // Модель OrderBookingDto
    private List<OrderBookingDto> booking;

    //* Уникальный идентификатор отпуска (В документации указан тип данных string)
    private UUID releaseUid;

    // Модель рецепта в заказе
    // Модель OrderPrescription
    private List<OrderPrescription> orderPrescriptions;

}
