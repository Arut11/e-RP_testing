package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


// Данные об отмене рецепта.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cancel {

  //* Дата отмены рецепта
  // Используем LocalDate для даты в формате yyyy-MM-dd
  private String uid;

  //* Дата отмены рецепта
  private String date;

  //* Данные об авторе
  // Модель Author
  private Author author;

  // Причина отмены рецепта
  private String reasonString; // Строка для причины отмены

}
