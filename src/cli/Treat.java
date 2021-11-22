package cli;

import diagnosis.Diagnosis;
import person.Patient;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class Treat extends Simulation {

    public static void main(String[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
        home();
    }


    public static void treat() throws SQLException, InvocationTargetException, IllegalAccessException {
    for (
    Patient p: patients){
        priority.add_patient(p);
    }
        for (Patient top_patient: priority.show_patientList()){
        System.out.println("Patient Details:");
        System.out.println(top_patient.getName() + "\n" +"Patient is " + top_patient.getSex() +" of age "+ top_patient.getAge());
        System.out.println("They are experiencing the following symptoms: " + top_patient.getSymptoms());
        System.out.println("1. Diagnose");
        System.out.println("2. Skip to the next patient");
        System.out.println("3. Go Back");

        int choice;
        while(true){
            Scanner option = new Scanner(System.in);
            System.out.println("Select your option:");
            choice = option.nextInt();
            if((choice > 3 || choice < 1)){
                System.out.println("Invalid Input!");
            }
            else
                break;
        }
        if(choice == 1){
            Diagnosis.diagnose_patient(top_patient);
            System.out.println("The Patient has " + top_patient.getDiagnose());
            System.out.println("1. Admit and Treat");
            System.out.println("2. Send them Home");
            int choice2;
            while(true){
                Scanner option = new Scanner(System.in);
                System.out.println("Select your option:");
                choice2 = option.nextInt();
                if((choice2 > 2 || choice2 < 1)){
                    System.out.println("Invalid Input!");
                }
                else
                    break;
            }
            if(choice2 == 1){
                System.out.println("Patient Admitted");
                priorityTreatment.add_patient(top_patient);
                priority.delete_patient(top_patient);
                top_patient.setIs_admitted(true);
                System.out.println("1. Next Patient");
                System.out.println("2. Go Home");
                int choice4;
                while(true){
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice4 = option.nextInt();
                    if((choice4 > 2 || choice4 < 1)){
                        System.out.println("Invalid Input!");
                    }
                    else
                        break;
                }
                if(choice4 == 1){
                    treat();
                }
                else {
                    home();
                }

            }
            else {
                System.out.println("Patient Sent Home");
                priority.delete_patient(top_patient);
                System.out.println("1. Next Patient");
                System.out.println("2. Go Home");
                int choice3;
                while(true){
                    Scanner option = new Scanner(System.in);
                    System.out.println("Select your option:");
                    choice3 = option.nextInt();
                    if((choice3 > 2 || choice3 < 1)){
                        System.out.println("Invalid Input!");
                    }
                    else
                        break;
                }
                if(choice3 == 1){
                    treat();
                }
                else {
                    home();
                }
            }
        }
        else if(choice == 2){
            continue;
        }
        else if(choice == 3){
            home();
        }
    }

}
}