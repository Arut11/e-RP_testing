package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Модель создания позиции заказа сформированной аптекой
@Getter
@Setter
@AllArgsConstructor
public class CreatePharmacyPosition {

    //* Уникальный идентификатор в системе-отправителе сведений в формате UUID
    private UUID uid;

    // Идентификатор позиции заказа
    private UUID positionUid;

    // Короткая модель назначения
    // Модель OrderMedicationDto
    private List<OrderMedicationDto> medication;

    // Комментарий
    private String  comment;
}
