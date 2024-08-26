package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Модель информации по заказу
@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    //* Данные статуса заказа
    // Модель OrderStateDto
    private List<OrderStateDto> state;

    //* Уникальный идентификатор
    private UUID uid;

    //* Подразделение
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

    //* Уникальный идентификатор отпуска
    private String releaseUid;

    //Данные об отсроченном обслуживании заказа
    // Модель OrderDalayDto
    private List<OrderDelayDto> dalay;

    // Данные о бронировании заказа
    // Модель OrderBookingDto
    private List<OrderBookingDto> booking;

    // Данные о доставке
    // Модель OrderDeliveryDto
    private List<OrderDeliveryDto> deliveries;

    //* Уникальный идентификатор рецепта в системе-источнике
    private UUID prescriptionUid;

}
