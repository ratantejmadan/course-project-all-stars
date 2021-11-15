package container;

import person.Patient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PriorityTreatment extends Container {

    public PriorityTreatment() {
        super();
    }

    public void add(Patient newPatient, Method priortization) throws InvocationTargetException, IllegalAccessException {
        //Patient with top priority at the start of the queue
        if (this.patientList.size() == 0) {
            this.patientList.add(newPatient);
        }
        int i = 0;
        while (!this.patientList.contains(newPatient)) {
            if (higherPriority(this.patientList.get(i), newPatient)) {
                int num;
                num = this.patientList.indexOf(this.patientList.get(i));
                this.patientList.add(num, newPatient);
        }
            else if ( i == this.patientList.size() - 1) {
                this.patientList.add(this.patientList.size(), newPatient);
            }
            else {
                i += 1;
            }
        }
    }


    private boolean higherPriority(Patient p, Patient newPatient) {
        //Order by lowest HP and who got into the queue first for now
        //Later, will also sort by urgency level once the patient has been diagnosed
        return p.getHealth() > newPatient.getHealth();
    }
}
