package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Модель приема данных рецепта/назначения.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prescription {

    //* Уникальный идентификатор в системе-отправителе сведений в формате UUID
    private String uid;

    //* Уникальный идентификатор назначения
    private String prescribedMedicationGuid;

    // Серия
    private String series;

    // Номер
    private String number;

    //* Дата выписки
    // Формат: yyyy-MM-dd
    private String dateCreate;

    //* Дата окончания действия
    // Формат: yyyy-MM-dd
    private String dateEnd;

    // Признак хронического диагноза
    private boolean isChronic;

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

    //* Бумажный рецепт
    // Признак того, что рецепт является дубликатом бумажного
    private boolean isPaper;

    //* Пациент
    // Модель Patient
    private Patient patient;

    //* Организация
    // Модель Organization
    private Organization organization;

    //* OID подразделения по справочнику НСИ Росминздрав 1.2.643.5.1.13.13.99.2.114
    private String subdivisionOid;

    //* Врач
    // Модель MedicalWorker
    private MedicalWorker doctor;

    //* Председатель комиссии
    // Модель MedicalWorker
    private List<MedicalWorker> chairman;

    //* Данные о назначенном препарате
    // Модель Medication
    private Medication medication;

    //* Код субъекта РФ по ОКАТО
    private String okatoCode;

    // Периодичность отпуска
    private String dispencePeriod;

    //* Идентификатор схемы лечения (ТАП)
    //private UUID schemeUid;

    // СНИЛС представителя пациента
    // Осуществляется проверка контрольной суммы СНИЛС.
    // СНИЛС должен состоять из 11 цифр и не содержать спецсимволы.
    private String representativeSnils;

    // Номер мобильного телефона представителя пациента
    // Номер телефона должен содержать не более 10 цифр без спецсимволов.
    private String representativeMPhone;

    //* Код диагноза пациента
    private String mkbCode;

    // Поле для хранения доп. информации
    private String tag;

    // Дата проведения врачебной комиссии
    // Формат: yyyy-MM-ddTHH:mm:sszzz
    private LocalDateTime commissionDate;

    // Номер врачебной комиссии
    private String commissionNumber;

    //* Наименование информационной системы - источника данных
    private String softwareName;

    // Адрес доставки
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    // Список данных о заказах на доставку
    // private String deliveries;

    // Код источника финансирования
    private String fundingSourceCode;

    // Процент оплаты
    private Integer percentageOfPayment;

    // Приоритет исполнения рецепта (Срочность)
    private String urgencyCode;

    // Срок действия рецепта
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.608. Поле "Уникальный идентификатор"
    private String validityCode;

    // Признак превышения дозы
    private boolean overdose;

    // Номер медицинской карты пациента.
    private String medicalCardNumber;

    // Идентификатор заявки на продление.
    private UUID renewalUid;

    // Код льготы. Справочник ФНСИ 1.2.643.5.1.13.13.99.2.541 поле "Код".
    private String privilegeCode;

    //* Подпись врача в формате открепленной CMS
    private String doctorSignature;

    // Подпись председателя врачебной комиссии в формате открепленной CMS
    private String chairmanSignature;

    // Статус рецепта/назначения
    // 0 - Registered (Зарегистрирован)
    // 1 - Dispensed (Отпущен)
    // 2 - PartiallyDispensed (Частично отпущен)
    // 3 - Canceled (Отменен)
    // 4 - DelayedService (Отложенное обслуживание)
    // 5 - Аnnulmented (Аннулирован)
    //private Enum state;

    // Подписанный рецепт СЭМД
    // Модель Semd
    //private List<Semd> semdData;

    // Данные об отмене рецепта
    // Модель Cancel
    //private List<Cancel> cancel;

}
