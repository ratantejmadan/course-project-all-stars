package person;

public class Immunologist extends Doctor{
    public Immunologist(String name, String address, String sex, int age) {
        super(name, address, sex, age);
        specialization = "Immunology";
        can_cure.add("Anaphylaxis");
        can_cure.add("Arthritis");
        can_cure.add("Seasonal Flu");
        can_cure.add("Conjunctivitis");
    }
}
