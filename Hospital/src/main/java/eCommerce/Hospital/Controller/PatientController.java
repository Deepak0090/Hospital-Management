package eCommerce.Hospital.Controller;

import eCommerce.Hospital.Model.Patient;
import eCommerce.Hospital.Service.PatientService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;

@RestController
@RequestMapping("/v1/patient")
public class PatientController {

   @Autowired
    PatientService patientService;

   @PostMapping("/create")
    public String createPatient(@RequestBody Patient patient){
        patientService.addPat(patient);
        return "Patient Added Successfully";
   }
    @GetMapping("/")
    public List<Patient> getAll(){
      return patientService.getAl();
   }

    @GetMapping("/{id}")
    public Optional<Patient> getById(@PathVariable Integer id){
       return patientService.getbyid(id);
  }
    @PutMapping("/")
    public String update(@RequestBody Patient patient){
       patientService.updateP(patient);
       return "Patient Details updated Successfully";
  }

  @DeleteMapping("/{id}")
    public String DeleteP(@PathVariable Integer id){
       patientService.deleteP(id);
       return "Patient Details Deleted";
  }



}
