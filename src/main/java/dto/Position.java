package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Позиция заказа
@Getter
@Setter
@AllArgsConstructor
public class Position {

    // Уникальный идентификатор в системе-отправителе сведений в формате UUID
    private UUID uid;

    // Комментарий фармацевта к отказу
    private String cancelComment;

    // Фармацевт
    // Модель ReleasePharmacist
    private List<ReleasePharmacist> denialAuthor;

    // Короткая модель назначения
    // Модель OrderMedicationDto
    private List<OrderMedicationDto> medication;

    // Данные статуса позиции заказа
    // Модель PositionStateDto
    private List<PositionStateDto> state;


}
