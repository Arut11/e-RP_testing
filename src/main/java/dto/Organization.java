package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// Организация
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Organization {

    // При создании организации передавать 0
    private int id;

    //* Наименование организации (короткое)
    private String name;

    // Наименование организации (полное)
    private String fullName;

    //* ОГРН/ОГРНИП организации
    // Обязателен, если не заполнен Oid
    private String ogrn;

    // ИНН организации
    private String inn;

    // OID медицинской организации РФ
    // По справочнику ФРНСИ. OID: 1.2.643.5.1.13.13.11.1461 поле “OID”
    private String federalOid;

    private String oid;

    private String phone;


    // Адрес организации
    private String address;

    // Широта
    private String latitude;

    // Долгота
    private String longitude;

    // Url сайта организации
    private String websiteUrl;

    private Okato okato;

    // Формат "yyyy-MM-dd"
    private String dateBegin;

    // Формат "yyyy-MM-dd"
    private String dateEnd;


    public String getDateBegin() {
        if (dateBegin == null) {
            return "1900-01-01T00:00:00";
        }
        return dateBegin;
    }

    public String getDateEnd() {
        if (dateEnd == null) {
            return "2222-01-01T00:00:00";
        }
        return dateEnd;
    }

}
