package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

// Подпись врача/председателя комиссии.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalSignature {

  //* Роль сотрудника при подписании рецепта
  // Справочник ФНСИ. OID: 1.2.643.5.1.13.2.1.1.734
  // Значения:
  // 0 или Doctor (Врач)
  // 1 или Chairman (Председатель ВК)
  // 2 - Фармацевт (не входит в справочник НСИ)
  private String signerRole;

  //* Подпись в формате base64
  private String signature;

  //* Идентификатор сертификата организации в системе РТ МИС. Обязательно, если интеграция с РЭМД через ЕЦП
  private Integer orgCertificateId;


}
