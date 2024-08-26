package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

// Данные назначенном препарате.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Medication {

    //* Схема приёма (сигнатура)
    private String signa;

    // Особые указания
    private String precondition;

    //* Количество назначенных единиц
    private float numberDose;

    //* Тип назначения
    // Справочник ФНСИ. OID:  1.2.643.5.1.13.13.99.2.651
    // Значения:
    // 0 или drug (Лекарственный препарат)
    // 1 или nutrition (Специализированный продукт лечебного питания)
    // 2 или device (Медицинское изделие)
    private String type;

    //* Код назначенного узла СММН
    // В зависимости от того, какое значение указано в поле type, в поле указывается: код узла СМНН (drug), код МИ (device), код спец. питания (nutrition)
    private String code;

    // Признак выписки по торговому наименованию
    private boolean isTrn;

    // Латинское наименование препарата
    private String latinPrescriptionName;

    // Латинская лекарственная форма
    private String latinDosageForm;

    // Международное непатентованное наименование
    private String mnn;

    // Торговое наименование
    private String trn;

    // Лекарственная форма
    private String dosageForm;

    // Дозировка
    private String dosage;

    // Характеристика
    private String characteristic;

    // Признак возможности дистанционной торговли
    // true - да, false - нет, null - не указан
    private Boolean isRemoteTrade;

}
