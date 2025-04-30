package eCommerce.Hospital.Service;

import eCommerce.Hospital.Model.Doctor;
import eCommerce.Hospital.Repository.DoctorRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getall(){
        return doctorRepository.getAll();
    }
    public Doctor getbyId(Integer id){
        return doctorRepository.getbyId(id);
    }
    public Doctor addD(Doctor doctor){
        return doctorRepository.addDoctor(doctor);
    }
    public Doctor update(Doctor doctor){
        return doctorRepository.update(doctor);
    }
    public Doctor delete(Integer id){
        return doctorRepository.deleteD(id);
    }
}
