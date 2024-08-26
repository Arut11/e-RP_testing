package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Подписанный рецепт СЭМД.
@Getter
@Setter
@AllArgsConstructor
public class Semd {

    //* Уникальный идентификатор документа СЭМД в системе отправителе сведений в формате UUID
    private UUID localUid;

    //* Версия СЭМДа
    private Integer version;

    //* Номер документа внутри организации или подразделения
    private String number;

    //* OID подразделения, выписавшего рецепт
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.114 поле "OID структурного подразделения"
    private String departmentCode;

    //* Наименование подразделения, выписавшего рецепт
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.114
    private String departmentName;

    //* Дата и время создания СЭМД рецепта
    // Формат: yyyy-MM-ddTHH:mm:sszzz
    private LocalDateTime createDateTime;

    //* Данные документа СЭМД в формате base64
    private String data;

    //* Подпись организации в формате base64
    private String orgSignature;

    // Данные о регистрации СЭМД
    // Модель RegistrationData
    private List<RegistrationData> registrationData;

    //* УКЭП сотрудников, которыми подписан рецепт
    // Модель PersonalSignature
    private List<PersonalSignature> personalSignatures;

    // Идентификатор запроса на регистрацию документа в РЭМД
    private UUID messageId;

}
