package erpApiAdmin.testData;

import com.github.javafaker.Faker;
import dto.Organization;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrganizationData extends Organization {

    static Faker fakerRu = new Faker(Locale.forLanguageTag("ru"));
    Faker fakerUS = new Faker(Locale.US);
    OkatoData OkatoData;

    public Organization getCreateOrganizationTestData() {
        OkatoData = new OkatoData();
        return new Organization()
                .setId(super.getId())
                .setName(fakerRu.name().firstName())
                .setFullName(fakerRu.name().fullName())
                .setOgrn(fakerRu.number().digits(13))
                .setInn(fakerRu.number().digits(10))
                .setFederalOid(fakerRu.regexify("[0-9]{7}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}"))
                .setPhone(fakerRu.phoneNumber().phoneNumber())
                .setAddress(fakerRu.address().fullAddress())
                .setLatitude(fakerRu.address().latitude())
                .setLongitude(fakerRu.address().longitude())
                .setWebsiteUrl(fakerRu.internet().url())
                .setOkato(null)
                .setDateBegin(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .setDateEnd(LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));

    }

}
