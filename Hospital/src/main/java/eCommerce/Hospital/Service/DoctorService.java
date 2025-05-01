package eCommerce.Hospital.Service;

import eCommerce.Hospital.Model.Doctor;
import eCommerce.Hospital.Repository.DoctorRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getall(){

        return doctorRepository.findAll();
    }
    public Optional<Doctor> getbyId(Integer id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return  doctor;
    }
    public Doctor addD(Doctor doctor){
        Doctor doctor1 = new Doctor();
        doctor1.setId(doctor.getId());
        doctor1.setName(doctor.getName());
        doctor1.setSpeciality(doctor.getSpeciality());

      return   doctorRepository.save(doctor1);
    }
        public Doctor update(Doctor doctor){

        Optional<Doctor> doctor1 = doctorRepository.findById(doctor.getId());
            if (!doctor1.isPresent()){
                return null;
            }
            Doctor doctor2 = doctor1.get();
            doctor2.setName(doctor.getName());
            doctor2.setSpeciality(doctor.getSpeciality());
            doctor2.setId(doctor.getId());
            doctorRepository.save(doctor2);
            return doctor2;
    }
    public void delete(Integer id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (!doctor.isPresent()){
            System.out.println("Not Found");
        }
        doctorRepository.deleteById(id);
    }
}
