package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Данные о назначенном препарате.
@Getter
@Setter
@AllArgsConstructor
public class ShortMedication {

    // Назначено
    private String prescriptionName;

    // Схема приёма (сигнатура)
    private String signa;

    // Особые указания
    private String precondition;

    // Количество назначенных единиц
    private float numberDose;

    // Международное непатентованное наименование
    private String mnn;

    // Торговое наименование
    private String trn;

    // Дозировка
    private String dosage;

    // Характеристика
    private String characteristic;

    // Признак возможности дистанционной торговли
    // true - да, false - нет, null - не указан
    private Boolean isRemoteTrade;

}
