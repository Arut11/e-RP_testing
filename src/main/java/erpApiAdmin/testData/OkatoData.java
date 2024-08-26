package erpApiAdmin.testData;

import com.github.javafaker.Faker;
import dataBase.DataBaseConnect;
import dto.Okato;
import java.util.Locale;

public class OkatoData {

    DataBaseConnect dataBaseConnect = new DataBaseConnect();
    static Faker faker = new Faker(Locale.forLanguageTag("ru"));

    private int generateId() {
        return faker.number().numberBetween(1, 5690);
    }

    public Okato getAddOkato() {
        String query = "SELECT code, name, comment, data_end FROM erp_okato WHERE id = " + generateId();
        String code = dataBaseConnect.getData(query);
            return new Okato()
                    .setId(generateId())
                    .setCode(code);

        }



}
