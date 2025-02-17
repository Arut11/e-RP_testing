package models;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
