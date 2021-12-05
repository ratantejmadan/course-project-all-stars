package test;

import database.PatientDatabaseCloud;
import person.Patient;
import org.junit.Test;
import person.PatientArrayList;


import java.sql.SQLException;
import java.util.ArrayList;

public class PatientTest{

    //Test Patient.java
    @Test
    public void testRead() throws SQLException {
        ArrayList<Patient> x = PatientArrayList.constructPatient("test_hospital");
        for(Patient patient : x){
            System.out.println(patient.getName());
            System.out.println(patient.getAddress());
            System.out.println(patient.getSex());
            System.out.println(patient.getAge());
            System.out.println(patient.getIs_Admitted());
            System.out.println(patient.getHealth());
            System.out.println(patient.getInsurance());
            System.out.println(patient.getSymptoms());
        }
    }

    //test write
    @Test
    public void testWrite() throws SQLException{
        PatientDatabaseCloud database = new PatientDatabaseCloud("test_hospital");
        database.writeData(200,"Test", "UofT", "Male", 69, 100,
                false, "cold", "flu", "butterflies");
    }


}