package com.database;

import com.model.Branch;
import com.model.Payment;
import com.model.Policy;
import com.model.User;

import java.util.ArrayList;

public interface DatabaseHelper {
    ArrayList<User> getAllUsers();

    ArrayList<User> getManagers();

    ArrayList<User> getAllCustomers();

    User getUser(User user);

    int addUser(User newUser);

    int deleteUser(User user);

    int updateUser(User user);

    int updateCustomer(User user);

    ArrayList<User> getAllAgents();

    ArrayList<Branch> getAllBranches();

    ArrayList<Policy> getAllPolicies();

    Branch getBranch();

    int addBranch(Branch branch);

    int addManager(User user);

    int deleteBranch(Branch branch);

    int deletePolicy(Policy policy);

    int updateBranch(Branch branch);

    int updatePolicy(Policy policy);

    int login(User user);

    long getMaxBranchId();

    int isBranchExists(Branch branch);

    int addPolicy(Policy policy);

    int isPolicyExists(Policy policy);

    int isManagerExists(User user);

    int updateManager(User user);

    int deleteManager(User manager);

    int deleteAgent(User agent);

    long getMaxPolicyId();

    long getMaxPolicyPId();

    long getMaxManagerId();

    long getMaxManagerMid();

    ArrayList<Policy> getPolicyStatus(User user);

    User getManager(User user);

    int addAgent(User user);

    int addCustomer(User user);

    int isAgentExists(User user);

    long getMaxAgentId();

    long getMaxAgentAid();

    long getMaxCustomerId();

    long getMaxCustomerCid();

    int isCustomerExists(User user);

    int deleteCustomer(User user);

    int deleteCustomerPolicyData(Policy policy);

    int updateCustomerPolicyData(Policy policy);

    ArrayList<Policy> getCustomerPolicies();

    int addCustomerPolicy(Policy policy);

    int isCustomerPolicyExits(Policy policy);

    long getMaxCustomerPolicyCupid();

    int getMaxCustomerPolicyId();

    Payment payPolictAndFetchPaymentDetails(Policy policy, double amountToPay);

    Payment getPolicyPaymentDetails(Policy policy);

    Policy getPolicy(Policy policy);

    int updateAgent(User user);

    int updateCustomerPolicy(Policy policy);

}
