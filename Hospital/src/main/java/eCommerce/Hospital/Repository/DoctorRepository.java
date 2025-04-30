package eCommerce.Hospital.Repository;

import eCommerce.Hospital.Model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class DoctorRepository {

    HashMap<Integer, Doctor> doctors = new HashMap<>();
    Integer idCount =1;

    public List<Doctor> getAll(){
        return new ArrayList<>(doctors.values());
    }
    public Doctor getbyId(Integer id){
        return doctors.get(id);
    }
    public Doctor addDoctor(Doctor doctor){
         doctor.setId(idCount++);
        doctors.put(doctor.getId(), doctor);
        return doctor;
    }

    public Doctor update(Doctor doctor){
         return doctors.put(doctor.getId(),doctor);
    }
    public Doctor deleteD(Integer id){
       return doctors.remove(id);
    }
}
