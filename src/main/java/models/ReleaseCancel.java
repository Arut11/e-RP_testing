package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

// Аннулирование рецепта.

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReleaseCancel {

  //* Причина аннулирования
  private String reason;

  // Код причины аннулирования
  // Справочник ФРНСИ. OID: 1.2.643.5.1.13.13.99.2.654
  private int reasonFederalCode;

}
