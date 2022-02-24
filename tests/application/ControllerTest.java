package application;

import com.model.Payment;
import com.model.Policy;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    //Test dotyczący porównania dostępnych polis
    @Test
    void loadPolicyDataToTable_poprawny() {
        Controller controller = new Controller();
        ArrayList<String> policies = new ArrayList<String>();
        policies.add("Ubezpieczenie domu");
        policies.add("Ubezpieczenie podrózy");
        policies.add("Ubezpieczenie samochodowe");
        policies.add("Ubezpieczenie firmowe");
        policies.add("Ubezpieczenie zdrowotne");
        int size= 0;
        for (int i = 0 ; i < policies.size(); i++) {
            size = i+1;
        }
        if(size == policies.size()) {
            Assertions.assertEquals(size, controller.getAllPolicies().size());
            System.out.println("Ilość polis w bazie jest taka sama jak w teście : ");
            System.out.println(controller.getAllPolicies());
        }
    }




    //Test dotyczący porównania dostępnych polis inna wartość - test da odpowiedź błędną
    @Test
    void loadPolicyDataToTable_bledny() {
        Controller controller = new Controller();
        ArrayList<String> policies = new ArrayList<String>();
        policies.add("Ubezpieczenie domu");
        policies.add("Ubezpieczenie podrózy");
        policies.add("Ubezpieczenie firmowe");
        policies.add("Ubezpieczenie zdrowotne");
        int size= 0;
        for (int i = 0 ; i < policies.size(); i++) {
            size = i+1;
        }

            Assertions.assertEquals(size, controller.getAllPolicies().size());
            System.out.println("Ilość polis w bazie jest inna niż podane w teście teście : ");
            System.out.println("Polisy w bazie : " + controller.getAllPolicies());
            System.out.println("Polisy w teście : " + policies.toString());

    }


}
