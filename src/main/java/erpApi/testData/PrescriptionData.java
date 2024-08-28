package erpApi.testData;


import com.github.javafaker.Faker;
import dto.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PrescriptionData {

    Faker fakerRu = new Faker(Locale.forLanguageTag("ru"));

    public Prescription getCreatePrescriptionTestData() {
                return new Prescription()
                .setUid(fakerRu.internet().uuid())
                .setPrescribedMedicationGuid("8858a503-768f-45c1-935e-d376897d3a9a")
                .setSeries(fakerRu.random().hex(7))
                .setNumber(fakerRu.number().digits(6))
                .setDateCreate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .setDateEnd(LocalDateTime.now().plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .setChronic(false)
                .setFormType("3")
                .setPaper(false)
                .setPatient(new PatientData().getPatient())
                .setOrganization(new OrganizationData().getOrganization())
                .setSubdivisionOid("1.2.643.5.1.13.13.12.2.31.2847.0.112753")
                .setDoctor(new DoctorData().getDoctor())
                .setChairman(null)
                .setMedication(new MedicationData().getMedication())
                .setOkatoCode("14256")
                .setDispencePeriod(null)
                .setRepresentativeSnils(null)
                .setRepresentativeMPhone(null)
                .setMkbCode("S03.2")
                .setTag(null)
                .setCommissionDate(null)
                .setCommissionNumber(null)
                .setSoftwareName("autotests")
                .setDeliveryAddress(null)
                .setFundingSourceCode("1")
                .setPercentageOfPayment(100)
                .setUrgencyCode("1")
                .setValidityCode("1")
                .setOverdose(false)
                .setMedicalCardNumber(null)
                .setRenewalUid(null)
                .setPrivilegeCode("1.00000.0001");

    }

    public Cancel getCancelPrescriptionTestData(String uid) {
        return new Cancel()
                .setUid(uid)
                .setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .setAuthor(new AuthorData().getAuthor())
                .setReasonString("Запуск автотестов");

    }

}
