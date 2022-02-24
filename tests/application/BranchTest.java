package application;

import com.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import org.apache.log4j.jmx.Agent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class BranchTest {

    // Sprawdzenie metod dodawania, usuwania, edycji
    @Test
    void DeleteUpdateTest() {
        Controller controller = new Controller();
        Branch branch = new Branch();
        Policy policy = new Policy();

        branch.setId(3);
        System.out.println("Test usuwania : ");
        System.out.println("Dostępne oddziały : "+controller.getAllBranches().size());
        controller.deleteBranch(branch);
        System.out.println("Oddziały po wywołaniu usuwania : " + controller.getAllBranches().size());
        Assertions.assertEquals(controller.getAllBranches().size(), controller.getMaxBranchId());

        policy.setId(3);policy.setPname("Ubezpieczenie fabryki");policy.setPterm("24");
        policy.setPamt(10000);policy.setPfamt(15000);policy.setPint(4);policy.setPbper(10);
        policy.setPrat(4);policy.setDesc("Fabryki żywności");policy.setPid(101);
        System.out.println("\nTest edycji : ");
        System.out.println("Edycja polisy : "+controller.getAllPolicies().get(3));
        System.out.println(controller.updatePolicy(policy));
    }






}
