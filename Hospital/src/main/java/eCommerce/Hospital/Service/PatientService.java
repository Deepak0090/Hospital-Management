package eCommerce.Hospital.Service;

import eCommerce.Hospital.Model.Doctor;
import eCommerce.Hospital.Model.Patient;
import eCommerce.Hospital.Repository.DoctorRepository;
import eCommerce.Hospital.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAl(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getbyid(Integer id){
        Optional<Patient> patient = patientRepository.findById(id);
        if (!patient.isPresent()){
            return null;
        }
        return patientRepository.findById(id);
    }
    public Patient addPat(Patient patient){
//        Doctor doctor =doctorRepository.getbyId(patient.getDoctorId());
//        if (doctor==null) return null;
        Patient patient1 = new Patient();
        patient1.setId(patient.getId());
        patient1.setDisease(patient.getDisease());
        patient1.setName(patient.getName());
        patient1.setAge(patient.getAge());
        patient1.setGender(patient.getGender());
        return patientRepository.save(patient1);

    }

    public Patient updateP(Patient patient){
        Optional<Patient> patient1 = patientRepository.findById(patient.getId());
        if (!patient1.isPresent()){
            return null;
        }
        Patient patient2 = patient1.get();
        patient2.setGender(patient.getGender());
        patient2.setAge(patient.getAge());
        patient2.setName(patient.getName());
        patient2.setId(patient.getId());
        patient2.setDisease(patient.getDisease());
      return   patientRepository.save(patient2);
    }
    public void deleteP(Integer id){
       Optional<Patient> patient = patientRepository.findById(id);
       if (!patient.isPresent()){
           System.out.println("Patient Not Found against off this Id");
       }
       patientRepository.deleteById(id);
    }

}
