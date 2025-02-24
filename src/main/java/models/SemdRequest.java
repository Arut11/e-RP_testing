package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


// Запрос на регистрацию СЭМД
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SemdRequest {
  //* Уникальный идентификатор документа СЭМД в системе отправителе сведений в формате UUID
  private String localUid;

  //* Версия СЭМДа
  private Integer version;

  //* OID типа электронного медицинского документа. Справочник ФНСИ 1.2.643.5.1.13.13.11.1520
  private String emdTypeOid;

  //* Номер документа внутри организации или подразделения
  private String number;

  //* Дата и время создания СЭМД рецепта
  // Формат: yyyy-MM-ddTHH:mm:sszzz
  private String createDateTime;

  //* Данные документа СЭМД в формате base64
  private String data;

  //* Подпись организации в формате base64
  private String orgSignature;

  //* УКЭП сотрудников, которыми подписан рецепт
  // Модель PersonalSignature
  // Подпись врача/председателя комиссии.
  private List<PersonalSignature> personalSignatures;

  //* Идентификатор запроса на регистрацию документа в РЭМД.
  private String messageId;

  //* Идентификатор сертификата организации в системе РТ МИС. Обязательно, если интеграция с РЭМД через ЕЦП
  private Integer orgCertificateId;

}
