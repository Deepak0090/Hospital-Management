package eCommerce.Hospital.Service;

import eCommerce.Hospital.Model.Doctor;
import eCommerce.Hospital.Model.Patient;
import eCommerce.Hospital.Repository.DoctorRepository;
import eCommerce.Hospital.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAl(){
        return patientRepository.getAllPatient();
    }

    public Patient getbyid(Integer id){
        return patientRepository.getPatientById(id);
    }
    public Patient addPat(Patient patient){
        Doctor doctor =doctorRepository.getbyId(patient.getDoctorId());
        if (doctor==null) return null;

        Patient patient1 = patientRepository.addPatient(patient);
        if (doctor.getPatients()==null){
            doctor.setPatients(new ArrayList<Patient>());
            doctor.getPatients().add(patient1);
        }else {
            doctor.getPatients().add(patient1);
        }
         doctorRepository.update(doctor);
        return patient1;
    }

    public Patient updateP(Patient patient){
        return patientRepository.UpdatePatient(patient);
    }
    public Patient deleteP(Integer id){
        return patientRepository.DeletePatient(id);
    }

}
