package eCommerce.Hospital.Repository;

import eCommerce.Hospital.Model.Doctor;
import eCommerce.Hospital.Model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PatientRepository {

    private HashMap<Integer, Patient> map = new HashMap<>();
    private int idCounter=1;

    public Patient addPatient(Patient patient){
        patient.setId(idCounter++);
         map.put(patient.getId(), patient);
         return patient;
    }

    public List<Patient> getAllPatient() {
        return new ArrayList<>(map.values());
    }

    public Patient getPatientById(Integer patientId) {
        return map.get(patientId);
    }

    public Patient UpdatePatient(Patient patient) {
        return map.put(patient.getId(), patient);
    }

    public Patient DeletePatient(Integer patientid) {
        return map.remove(patientid);
    }
}
