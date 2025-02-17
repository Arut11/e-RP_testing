package models;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Продлеваемый рецепт(для ЛК пациента)
@Getter
@Setter
@AllArgsConstructor
public class RenewalPrescriptionDto {

  // Уникальный идентификатор рецепта в системе отправителе сведений в формате UUID
  private UUID uid;

  // Номер рецепта
  private String number;

  // Дата создания документа
  private LocalDateTime dateCreate;

  // Назначено
  private String name;

}
