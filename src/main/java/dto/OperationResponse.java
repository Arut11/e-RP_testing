package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

// Ответ для отпуска рецептов/назначений.
@Getter
@Setter
@AllArgsConstructor
public class OperationResponse {

    // Идентификатор рецепта
    private UUID localUid;

    // Статус рецепта
    private String state;

    // Дата и время установления статуса
    private LocalDate stateDate;

    // Ошибки регистрации рецепта от сервиса РЭМД
    // Модель Error
    private Error remdErrors;

}
