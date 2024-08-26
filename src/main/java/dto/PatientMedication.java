package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель данных о назначенном препарате для карточек в лк пациента
@Getter
@Setter
@AllArgsConstructor
public class PatientMedication {

    // Назначено
    private String prescriptionName;

    // Схема приёма (сигнатура)
    private String signa;

    // Количество назначенных единиц
    private float numberDose;

    // Код CMNN или Код справочника медицинского изделия или Код справочника специализированного питания
    private String code;

    // Признак возможности дистанционной торговли
    // true - да, false - нет, null - не указан
    private Boolean isRemoteTrade;

}
