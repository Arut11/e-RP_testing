package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Позиция заказа сформированная аптекой
@Getter
@Setter
@AllArgsConstructor
public class PharmacyPosition {

    // Уникальный идентификатор в системе-отправителе сведений в формате UUID
    private String uid;

    // Идентификатор позиции
    private String positionUid;

    // Короткая модель назначения
    // Модель OrderMedicationDto
    private List<OrderMedicationDto> medication;

    // Комментарий
    private String comment;

    // Данные статуса позиции заказа
    // Модель PositionStateDto
    private List<PositionStateDto> state;

}
