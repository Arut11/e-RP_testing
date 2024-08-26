package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

// Модель данных о бронировании заказа
@Getter
@Setter
@AllArgsConstructor
public class OrderBookingDto {

    //* Фармацевт
    // Модель ReleasePharmacist
    private List<ReleasePharmacist> author;

    //* Дата взятия на бронирование
    private LocalDate dataTaking;

    //* Дата окончания бронирования
    private LocalDate dataEnd;



}
