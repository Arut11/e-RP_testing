package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// Данные о регистрации СЭМД.
@Getter
@Setter
@AllArgsConstructor
public class RegistrationData {

    // Регистрационный номер СЭМД в Реестре ЭМД
    private String federalRegNumber;

    // Статусы рецепта при взаимодействии с РЭМД
    // 0 - Sended (Отправлен (в процессе регистрации))
    // 1 - Registered (Зарегистрирован)
    // 2 - Error (Ошибка регистрации)
    private Enum remdState;

    // Дата и время установления статуса рецепта в Реестре ЭМД
    private LocalDateTime remdStateDate;

    // Ошибки регистрации в Реестре ЭМД
    // Модель Error
    private List<Error> remdErrors;

}
