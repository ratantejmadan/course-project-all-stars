package person;

import javax.print.Doc;

public class Oncologist extends Doctor{

    final private String specialization;

    public Oncologist(int id, String name, String address, String sex, int age){
        super(id, name, address, sex, age);
        specialization = "Oncology";
        can_cure.add("Cancer");
    }

    public String getSpecialization() {
        return specialization;
    }

}
