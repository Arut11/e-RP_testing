package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

// Создание модели рецепта в заказе
@Getter
@Setter
@AllArgsConstructor
public class CreateOrderPrescriptionByPharmacy {

    //* Уникальный идентификатор рецепта в системе-источнике
    private UUID prescroptionUid;

    //* Позиции заказа, сформированные аптекой
    // Модель CreatePharmacyPosition
    private List<CreatePharmacyPosition> pharmacyPositions;

}
