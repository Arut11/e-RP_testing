package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// Адрес доставки
@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    // Код адреса (по ОКАТО)
    private String code;

    // Наименование района
    private String region;

    // Город
    private String city;

    // Наименование улицы
    private String street;

    // Номер дома
    private String house;

    // Квартира
    private String apartment;

    // Полный адрес строкой
    private String fullAddress;

    // Адрес по ФИАС
    // Модель FiasDto
    private List<FiasDto> fias;




}
