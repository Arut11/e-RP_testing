package models;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель создания позиции заказа
@Getter
@Setter
@AllArgsConstructor
public class CreatePosition {

  //* Уникальный идентификатор в системе-отправителе сведений в формате UUID
  private UUID uid;

  // Короткая модель назначения
  // Модель OrderMedicationDto
  private List<OrderMedicationDto> medication;

}
