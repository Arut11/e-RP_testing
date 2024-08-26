package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Модель заказа на доставку.
@Getter
@Setter
@AllArgsConstructor
public class DeliveryDto {

    //* Идентификатор
    private UUID uid;

    //* Дата и время формирования
    private LocalDate dateCreate;

    //* Автор
    // Модель MedicalWorker
    private List<MedicalWorker> autor;

    //* Статус заказа на доставку
    // Значения:
    //0 или Delivered (Передан курьеру)
    //1 или Done (Доставлен)
    //2 или Canceled (Отменен)
    private Enum state;

    // Дата выполнения/отмены заказа
    private LocalDate dateResult;

}
