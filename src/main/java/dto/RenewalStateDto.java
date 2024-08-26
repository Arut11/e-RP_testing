package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//
@Getter
@Setter
@AllArgsConstructor
public class RenewalStateDto {

    // Название статуса.
    private String name;

    // Статус заявки на продление.
    // Значения:
    // 0 или Awaited (Ожидает обработки)
    // 1 или Allowed (Одобрена)
    // 2 или Denied (Отклонена)
    private Enum state;

}
