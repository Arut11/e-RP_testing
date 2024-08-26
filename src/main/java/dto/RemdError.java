package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель ошибки при регистрации СЭМД в РЭМД
@Getter
@Setter
@AllArgsConstructor
public class RemdError {

    // Код ошибки
    private String code;

    //* Данные об ошибке при регистрации
    private String message;

}
