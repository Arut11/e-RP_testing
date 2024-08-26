package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Модель рабочего дня
@Getter
@Setter
@AllArgsConstructor
public class WorkdayDto {

    // Рабочий день
    // 0 - Sunday (Воскресенье)
    // 1 - Monday (Понедельник)
    // 2 - Tuesday (Вторник)
    // 3 - Wednesday (Среда)
    // 4 - Thursday (Четверг)
    // 5 - Friday (Пятница)
    // 6 - Saturday (Суббота)
    private Enum kindDay;

    //* Начало рабочего дня
    private String start;

    //* Конец рабочего дня
    private String end;

    // Начало перерыва
    private String timeoutStart;

    // Конец перерыва
    private String timeoutEnd;

}
