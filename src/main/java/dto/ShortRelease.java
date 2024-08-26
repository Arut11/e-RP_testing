package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Короткая модель отпуска.
@Getter
@Setter
@AllArgsConstructor
public class ShortRelease {

    // Уникальный идентификатор отпуска рецепта/назначения
    private UUID uid;

    // Идентификатор назначения/рецепта
    private UUID prescriptionUid;

    // Отпущенные препараты
    // Модель MedicationDispense
    private List<MedicationDispense> medicationDispenses;

    // Комментарий
    private String signa;

    // Дата отпуска/отмены документа
    private LocalDateTime date;

    // Наименование организации, отпустившей рецепт/назначение
    private String organizationName;

    // Причина аннулирования
    private String cancelReasonText;

    // Данные об авторе
    // Модель Author
    private List<Author> pharmacist;

}
