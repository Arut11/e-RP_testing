package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

// Модель подразделения.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subdivision {

  //* Наименование
  private String name;

  // Уникальный код подразделения
  // Обязателен, если не заполнен oid
  private String code;

  // OID подразделения по ФРМО
  // Справочник ФНСИ 1.2.643.5.1.13.13.99.2.114 поле "OID". Обязателен для выписки рецептов
  private String oid;

  // Телефон руководителя
  // Номер телефона должен содержать от 4 до 11 цифр без спецсимволов.
  private String directorPhone;

  // Адрес
  private String address;

  // Код вида подразделения
  // По справочнику ФНСИ. oid 1.2.643.5.1.13.13.11.1072
  private String kindCode;

  // Часы работы
  // Модель WorkdayDto
  private List<WorkdayDto> workingHours;

  // Широта
  private String latitude;

  // Долгота
  private String longitude;

}
