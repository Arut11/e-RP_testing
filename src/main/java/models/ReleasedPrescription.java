package models;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Отпущенный рецепт
@Getter
@Setter
@AllArgsConstructor
public class ReleasedPrescription {

  //* Уникальный идентификатор рецепта
  private UUID prescriptionUid;

  //* Уникальный идентификатор отпуска
  private UUID releaseUid;

}
