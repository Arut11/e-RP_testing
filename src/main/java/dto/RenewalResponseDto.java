package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Заявка на продление рецепта.
@Getter
@Setter
@AllArgsConstructor
public class RenewalResponseDto {

    //* Идентификатор заявки на продление
    private UUID renewalUid;

    //* Статус заявки на продление
    // 0 - Awaited (Ожидает обработки)
    // 1 - Allowed (Одобрена)
    // 2 - Denied (Отклонена)
    private Enum state;

    //* Дата создания заявки
    private LocalDateTime dateCreate;

    //* Уникальный идентификатор рецепта/назначения, который необходимо продлить, в формате UUID
    private UUID prescriptionUid;

    //* Пациент
    // Модель ShortPatient
    private List<ShortPatient> patient;

    //* Адрес доставки
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    //* Назначено
    private String prescriptionName;

    // Схема приёма (сигнатура)
    private String signa;

    // Код диагноза по МКБ-10
    private String mkbCode;

}
