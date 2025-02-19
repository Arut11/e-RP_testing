package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

// Фармацевт.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReleasePharmacist {

  // Имя пользователя
  private String name;

  // Фамилия пользователя
  private String surname;

  // Отчество
  private String patronymic;

  //* СНИЛС
  // Осуществляется проверка контрольной суммы СНИЛС.
  // СНИЛС должен состоять из 11 цифр и не содержать спецсимволы.
  private String snils;

  //* Код должности
  // Справочник ФНСИ. OID: 1.2.643.5.1.13.13.99.2.181 поле "OID"
  private Integer frmrMedicalStaffPostCode;

}
