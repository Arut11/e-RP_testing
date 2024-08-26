package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Отпуск рецепта/назначения.
@Getter
@Setter
@AllArgsConstructor
public class Release {

    //* Уникальный идентификатор документа в системе отправителе в формате UUID
    private UUID localUid;

    //* Уникальный идентификатор рецепта/назначения в системе отправителе сведений в формате UUID
    private UUID prescriptionUid;

    //* Дата отпуска/отмены документа
    // Формат: yyyy-MM-dd
    private LocalDateTime date;

    //* Организация
    // Модель Organization
    private List<Organization> organization;

    //* Подразделение
    // Модель Subdivision
    private List<Subdivision> subdivision;

    //* Фармацевт
    // Модель ReleasePharmacist
    private List<ReleasePharmacist> pharmacist;

    // Отпущенный препарат
    // Модель MedicationDispense
    private List<MedicationDispense> medicationDispense;

    // Схема приёма
    private String signa;

    // Признак частичного отпуска
    private boolean isPartialDispense;

    // Аннулирование рецепта
    // Модель ReleaseCancel
    private List<ReleaseCancel> cancel;

    // Программное обеспечение, на котором осуществляется отпуск
    private String software;

    // Идентификатор заказа на доставку
    private UUID deliveryUid;

    // Идентификатор заказа на отсроченное обслуживание/бронирование
    private UUID orderUid;

    // СЭМДы отпуска
    // Модель Semd
    private List<Semd> semds;

    // Уникальный идентификатор СЭМДа выписки
    // Обязателен для рецептов
    private UUID prescriptionSemdLocalUid;

}
