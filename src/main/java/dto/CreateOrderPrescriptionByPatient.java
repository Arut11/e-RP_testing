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
public class CreateOrderPrescriptionByPatient {

    //* Уникальный идентификатор рецепта в системе-источнике
    private UUID prescriptionUid;

    // Позиции заказа
    // Модель CreatePosition
    private List<CreatePosition> positions;

}
