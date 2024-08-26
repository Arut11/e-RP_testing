package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Ошибки от ФРЭМД.
@Getter
@Setter
@AllArgsConstructor
public class FremdError {

    // Сообщение
    private String message;

    // Код ошибки
    private String code;

}
