package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Подпись врача/председателя комиссии.
@Getter
@Setter
@AllArgsConstructor
public class PersonalSignature {

    //* Роль сотрудника при подписании рецепта
    // Справочник ФНСИ. OID: 1.2.643.5.1.13.2.1.1.734
    // Значения:
    // 0 или Doctor (Врач)
    // 1 или Chairman (Председатель ВК)
    private Enum signerRole;

    //* Подпись в формате base64
    private String signature;

}
