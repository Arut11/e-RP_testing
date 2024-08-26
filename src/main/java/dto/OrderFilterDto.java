package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Модель фильтра поиска
@Getter
@Setter
@AllArgsConstructor
public class OrderFilterDto {

    // СНИЛС пациента
    // Осуществляется проверка контрольной суммы СНИЛС.
    // СНИЛС должен состоять из 11 цифр и не содержать спецсимволы.
    private String patientSnils;

    // Список уникальных идентификаторов рецептов/назначений
    private List<UUID> prescriptionUids;

    // Список идентификаторов заказа
    private List<UUID> orderUids;

    // Список статусов заказов
    private List<OrderStateDto> states;

    // Список Oid'ов подразделений
    private List<String> subdivisionOids;

    // Дата начала поиска по дате создания заказа (включительно)
    private LocalDateTime dateBegin;

    // Дата окончания поиска по дате создания заказа (включительно)
    private LocalDateTime dateEnd;

    // Номера рецептов
    private List<String> prescriptionNumbers;

    // Номер заказа
    private String number;

}
