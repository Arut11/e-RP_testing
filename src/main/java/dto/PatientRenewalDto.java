package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Модель заявок на продление рецепта для карточек в лк пациента.
@Getter
@Setter
@AllArgsConstructor
public class PatientRenewalDto {

    // Идентификатор заявки на продление
    private UUID renewalUid;

    // Статус заявки на продление
    // 0 - Awaited (Ожидает обработки)
    // 1 - Allowed (Одобрена)
    // 2 - Denied (Отклонена)
    private Enum state;

    // Дата создания заявки
    private LocalDateTime dateCreate;

    // Адрес доставки
    // Модель AddressDto
    private List<AddressDto> deliveryAddress;

    // Номер мобильного телефона пациента
    private String mPhone;

    // Продлеваемый рецепт
    // Модель RenewalPrescriptionDto
    private List<RenewalPrescriptionDto> prescription;

}
