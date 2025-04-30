package eCommerce.Hospital.Model;

import lombok.Data;

import java.util.List;

@Data
public class Doctor {

    Integer id;
    String name;
    String speciality;
    List<Patient> patients;
}
