package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

// Модель данных об отсроченном обслуживании заказа
@Getter
@Setter
@AllArgsConstructor
public class OrderDelayDto {

    //* Фармацевт
    // Модель ReleasePharmacist
    private List<ReleasePharmacist> author;

    //* Дата взятия на отсроченное обслуживание
    private LocalDate dataTaking;

    //* Дата окончания отсроченного обслуживания
    private LocalDate dataEnd;

}
