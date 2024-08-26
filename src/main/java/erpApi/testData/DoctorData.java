package erpApi.testData;

import dto.MedicalWorker;

public class DoctorData {

    public MedicalWorker getDoctor() {
        return new MedicalWorker()
                .setSurname("Безкруглова")
                .setName("Ирина")
                .setPatronymic("Константиновна")
                .setSnils("06950154572")
                .setPhone("89511112323")
                .setLocalId("275C57C6-662C-4935-A9B2-EB64AFE78537")
                .setBirthDate("1971-12-11")
                .setPositionCode("91");

    }
}
