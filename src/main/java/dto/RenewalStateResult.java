package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

//
@Getter
@Setter
@AllArgsConstructor
public class RenewalStateResult {

    // Уникальный идентификатор продления
    private UUID renewalUid;

    // Статус заявки на продление.
    // Модель RenewalStateDto
    private List<RenewalStateDto> state;

}
