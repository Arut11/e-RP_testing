package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

// Отпуск рецепта/назначения.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Release {

  //* Уникальный идентификатор документа в системе отправителе в формате UUID
  private String localUid;

  //* Уникальный идентификатор рецепта/назначения в системе отправителе сведений в формате UUID
  private String prescriptionUid;

  //* Дата отпуска/отмены документа
  // Формат: yyyy-MM-dd
  private String date;

  //* Организация
  // Модель Organization
  private Organization organization;

  //* Подразделение
  // Модель Subdivision
  private Subdivision subdivision;

  //* Фармацевт
  // Модель ReleasePharmacist
  private ReleasePharmacist pharmacist;

  // Отпущенный препарат
  // Модель MedicationDispense
  private MedicationDispense medicationDispense;

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
  private String deliveryUid;

  // Идентификатор заказа на отсроченное обслуживание/бронирование
  private String orderUid;

  // СЭМДы отпуска
  // Модель Semd
  private List<Semd> semds;

  // Уникальный идентификатор СЭМДа выписки
  // Обязателен для рецептов
  private String prescriptionSemdLocalUid;

}
