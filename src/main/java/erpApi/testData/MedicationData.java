package erpApi.testData;

import dto.Medication;

public class MedicationData {

    public Medication getMedication() {
        return new Medication()
                .setSigna("Принимать 1 мл перорально 1 раз в день в течение 1 дня")
                .setPrecondition(null)
                .setNumberDose(1)
                .setType("drug")
                .setCode("21.20.10.232-000011-1-00017-0000000000000")
                .setLatinPrescriptionName("Metamizoli natrii")
                .setLatinDosageForm("Sol.")
                .setMnn("МЕТАМИЗОЛ.")
                .setTrn(false)
                .setDosageForm("2 мг+5 мг/мл.")
                .setDosage("2 мг+5 мг/мл.")
                .setCharacteristic("0,25мм (31G) х 6мм.")
                .setIsRemoteTrade(true);
    }
}
