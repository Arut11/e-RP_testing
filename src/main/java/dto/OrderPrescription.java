package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Модель рецепта в заказе
@Getter
@Setter
@AllArgsConstructor
public class OrderPrescription {

    //* Уникальный идентификатор рецепта в системе-источнике
    private UUID prescriptionUid;

    // Статус рецепта/назначения
    // 0 - Зарегистрирован
    // 1 - Отпущен
    // 2 - Частично отпущен
    // 3 - Отменен
    // 4 - Отложенное обслуживание
    // 5 - Аннулирован
    private Enum state;

    // Серия рецепта/назначения
    private String prescriptionSeries;

    //* Номер рецепта/назначения
    private String prescriptionNumber;

    //* Наименование препарата из рецепта
    private String prescriptionName;

    // Позиции заказа
    // Модель Position
    private List<Position> positions;

    // Позиции заказа, сформированные аптекой
    // Модель PharmacyPosition
    private List<PharmacyPosition> pharmacyPositions;

}
