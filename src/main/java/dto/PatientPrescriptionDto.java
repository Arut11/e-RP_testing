package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Модель рецептов/назначений для карточек в лк пациента
@Getter
@Setter
@AllArgsConstructor
public class PatientPrescriptionDto {

    // Уникальный идентификатор рецепта в системе отправителе сведений в формате UUID
    private UUID uid;

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
    private Enum formType;

    //* Уникальный идентификатор назначения
    // Для формы PrescribedMedication - указывается Uid назначения
    private UUID prescribedMedicationGuid;

    // Данные о назначенном препарате для карточек в лк пациента
    private List<PatientMedication> medication;

    // Данные о заказах на доставку
    private List<ShortDeliveryDto> deliveries;

    // Адрес
    private List<AddressDto> deliveryAddress;

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

    //* Короткая версия модели организации
    private List<ShortOrganizationDto> organization;

    // Базовые персональные данные
    private List<BasePersonalData> medicalWorker;

    // Короткая модель пациента
    private List<ShortPatient> patient;

    // Oid подразделения
    private String subdivisionOid;

}
