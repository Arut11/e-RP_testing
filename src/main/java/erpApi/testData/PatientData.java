package erpApi.testData;

import com.github.javafaker.Faker;
import dto.Patient;

import java.util.Locale;

public class PatientData {

    Faker faker = new Faker(Locale.forLanguageTag("ru"));

    public Patient getPatient() {
        return new Patient()
                .setLocalUid("2a997cfa-26eb-45ae-b944-663850d84682")
                .setSurname("Саргатян")
                .setName("Арутюн")
                .setPatronymic("")
                .setBirthday("1995-07-06")
                .setPolicyNumber("1234567890000000")
                .setGender(1)
                .setSnils("15943551289")
                .setMPhone("9511454108")
                .setPrivilegeCode(null);
    }

}
