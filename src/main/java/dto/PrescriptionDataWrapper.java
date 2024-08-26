package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class PrescriptionDataWrapper {

    private Prescription data;
    private String doctorSignature;

    public PrescriptionDataWrapper(Prescription data, String doctorSignature) {
        this.data = data;
        this.doctorSignature = doctorSignature;

    }

}