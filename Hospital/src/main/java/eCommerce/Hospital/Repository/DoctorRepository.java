package eCommerce.Hospital.Repository;

import eCommerce.Hospital.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
