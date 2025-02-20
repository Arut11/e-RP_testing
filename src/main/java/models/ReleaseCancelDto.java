package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


// Модель данных об отмене ошибочного отпуска.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReleaseCancelDto {

  //* Причина отмены
  private String reason;

  //* Данные об авторе
  // Модель Author
  private ReleasePharmacist author;

  //* Дата отмены
  private String date;

  // Уникальный идентификатор отпуска в формате UUID
  private String localUid;
}
