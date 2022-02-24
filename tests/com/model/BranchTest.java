package com.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    //Test bazodanowy POPRAWNY
    @Test
    public void testBranch_poprawny() {
        Branch branch = new Branch();
        branch.setName("Polex");
        branch.setPhone("606124123");
        branch.setId(1);
        branch.setState("Polska");
        branch.setLocation("Kielce");
        Assertions.assertEquals("Kielce", branch.getLocation());
        Assertions.assertEquals("Polex", branch.getName());
        Assertions.assertEquals("606124123", branch.getPhone());
        Assertions.assertEquals(1, branch.getId());
        Assertions.assertEquals("Polska", branch.getState());
    }

    //Test bazodanowy BŁĘDNY
    @Test
    public void testBranch_bledny() {
        Branch branch = new Branch();
        branch.setName("Polex");
        branch.setPhone("606124123");
        branch.setId(1);
        branch.setState("Niemcy");
        branch.setLocation("Kielce");
        Assertions.assertEquals("Kielce", branch.getLocation());
        Assertions.assertEquals("Polex", branch.getName());
        Assertions.assertEquals("606124123", branch.getPhone());
        Assertions.assertEquals(1, branch.getId());
        Assertions.assertEquals("Polska", branch.getState());
    }
}