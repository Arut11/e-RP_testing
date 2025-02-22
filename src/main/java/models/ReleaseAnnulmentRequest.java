package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// Отпуск рецепта с аннулированием
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReleaseAnnulmentRequest {

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

  //* Аннулирование рецепта
  // Модель ReleaseCancel
  private ReleaseCancel cancel;

  //* Программное обеспечение, на котором осуществляется отпуск
  private String software;

  // Уникальный идентификатор СЭМДа выписки
  // Обязателен для рецептов
  private String prescriptionSemdLocalUid;

}
