package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Короткая модель рецепта.
@Getter
@Setter
@AllArgsConstructor
public class ShortPrescription {

    // Уникальный идентификатор рецепта в системе отправителе сведений в формате UUID
    private UUID uid;

    // Серия рецепта
    private String series;

    // Номер рецепта
    private String number;

    //* Тип рецепта/назначения (Номер формы бланка)
    // 0 - PrescribedMedication (Назначение ЛС)
    // 1 - Frm1071U (Форма 107-1/у)
    // 2 - Frm107UNP (Форма 107/у-НП)
    // 3 - Frm1481U04 (Форма 148-1/у-04 (л))
    // 4 - Frm1481U88 (Форма 148-1/у-88)
    // 5 - Frm1Mi (Форма 1-МИ)
    // 6 - Frm2Mi (Форма 2-МИ)
    // 7 - Frm3Mi (Форма 3-МИ)
    private String formType;

    // Данные о назначенном препарате
    // Модель ShortMedication
    private List<ShortMedication> medication;

    // Дата создания документа
    private LocalDateTime dateCreate;

    // Дата окончания действия рецепта
    private LocalDateTime dateEnd;

    // Статус рецепта/назначения
    // 0 - Registered (Зарегистрирован)
    // 1 - Dispensed (Отпущен)
    // 2 - PartiallyDispensed (Частично отпущен)
    // 3 - Canceled (Отменен)
    // 4 - DelayedService (Отложенное обслуживание)
    // 5 - Аnnulmented (Аннулирован)
    private Enum state;

    // Короткие данные о пациенте
    // Модель ShortPatient
    private List<ShortPatient> patient;

    // Наименование организации
    private String organizationName;

    // Базовые персональные данные
    // Модель BasePersonalData
    private List<BasePersonalData> medicalWorker;

    // Признак того, что рецепт является дубликатом бумажного
    private boolean isPaper;

    // Источник финансирования
    // Модель StringBaseDictionary
    private List<StringBaseDictionary> fundingSource;

    // Данные об отмене рецепта
    // Модель ShortCancel
    private List<ShortCancel> cancel;

}
