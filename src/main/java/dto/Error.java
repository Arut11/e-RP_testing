package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Ошибки
@Getter
@Setter
@AllArgsConstructor
public class Error {

    // Ключ
    private String key;

    // Сообщение
    private String message;

    // Код ошибки
    private String code;

}
