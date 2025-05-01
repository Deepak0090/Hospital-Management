package eCommerce.Hospital.Controller;

import eCommerce.Hospital.Model.Doctor;
import eCommerce.Hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getal(){
        return doctorService.getall();
    }
    @GetMapping("/{id}")
    public Optional<Doctor> getbyid(@PathVariable Integer id){
        return doctorService.getbyId(id);
    }

    @PostMapping("/create")
    public String addDoc(@RequestBody Doctor doctor){
        doctorService.addD(doctor);
        return "Doctor Added successfully";
    }
    @PutMapping("/update")
    public String update(@RequestBody Doctor doctor){
         doctorService.update(doctor);
         return "Doctor Updated Successfully";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        doctorService.delete(id);
        return "Doctor is Deleted Permanently";
    }

}
