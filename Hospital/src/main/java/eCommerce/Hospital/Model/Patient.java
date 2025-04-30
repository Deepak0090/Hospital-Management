package eCommerce.Hospital.Model;

import lombok.Data;


@Data
public class Patient {


    Integer id;

    String name;

    Integer age;

    String gender;

    String disease;

    Integer doctorId;


}
