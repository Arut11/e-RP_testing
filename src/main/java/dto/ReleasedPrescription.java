package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

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
