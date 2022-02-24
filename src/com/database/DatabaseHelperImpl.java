package com.database;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.encryption.Encrypt;
import com.model.*;

public class DatabaseHelperImpl extends Database implements DatabaseHelper {

    private Encrypt encrypt;

    public DatabaseHelperImpl() {
        encrypt = new Encrypt();
    }


    @Override
    public ArrayList<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int login(User user) {
        int status = 0;
        switch (user.getRole()) {
            case Admin:
                String strAdminQuery = "Select * from user_admin where name='" + user.getName() + "'";
                try {
                    ResultSet resultSet = getConnection().createStatement().executeQuery(strAdminQuery);
                    while (resultSet.next()) {
                        if (resultSet.getString("name").equals(user.getName())) {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("password"))) {

                                user.setPassword(resultSet.getString("password"));
                                status = 1;
                                break;
                            } else {

                                status = 2;
                            }
                        } else {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("password"))) {

                                status = 3;
                            } else {

                                status = 4;
                            }
                        }
                    }
                } catch (SQLException e) {
                    // Error
                    status = -1;
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                break;
            case Klient:
                String strCustomerQuery = "Select * from user_customer where name='" + user.getName() + "'";
                System.out.println(strCustomerQuery);
                try {
                    ResultSet resultSet = getConnection().createStatement().executeQuery(strCustomerQuery);
                    while (resultSet.next()) {
                        if (resultSet.getString("name").equals(user.getName())) {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("pass"))) {
                                // Correct
                                status = 1;
                                user.setPassword(resultSet.getString("pass"));
                                break;
                            } else {
                                // Wrong Password
                                status = 2;
                            }
                        } else {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("pass"))) {
                                // Wrong Username
                                status = 3;
                            } else {
                                // Wrong Username & Password;
                                status = 4;
                            }
                        }
                    }
                } catch (SQLException e) {
                    // Error
                    status = -1;
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                break;
            case Agent:
                String strAgentQuery = "Select * from user_agent where name='" + user.getName() + "'";
                try {
                    ResultSet resultSet = getConnection().createStatement().executeQuery(strAgentQuery);
                    while (resultSet.next()) {
                        if (resultSet.getString("name").equals(user.getName())) {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("pass"))) {
                                // Correct
                                status = 1;
                                user.setPassword(resultSet.getString("pass"));
                                break;
                            } else {
                                // Wrong Password
                                status = 2;
                            }
                        } else {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("pass"))) {
                                // Wrong Username
                                status = 3;
                            } else {
                                // Wrong Username & Password;
                                status = 4;
                            }
                        }
                    }
                } catch (SQLException e) {
                    // Error
                    status = -1;
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                break;
            case Menadżer:
                String strManagerQuery = "Select * from user_manager where name='" + user.getName() + "'";
                try {
                    ResultSet resultSet = getConnection().createStatement().executeQuery(strManagerQuery);
                    while (resultSet.next()) {
                        if (resultSet.getString("name").equals(user.getName())) {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("pass"))) {
                                // Correct
                                status = 1;
                                user.setPassword(resultSet.getString("pass"));
                                break;
                            } else {
                                // Wrong Password
                                status = 2;
                            }
                        } else {
                            if (encrypt.validatePassword(user.getPassword(), resultSet.getString("pass"))) {
                                // Wrong Username
                                status = 3;
                            } else {
                                // Wrong Username & Password;
                                status = 4;
                            }
                        }
                    }
                } catch (SQLException e) {
                    // Error
                    status = -1;
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        return status;
    }

    @Override
    public int deleteCustomer(User user) {
        String strQuery = "delete from user_customer where cid=" + user.getCid();
        int status = 0;
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteCustomerPolicyData(Policy policy) {
        String strQuery = "delete from customer_policy where cupid='" + policy.getCupid() + "'";
        int status = 0;
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updateCustomerPolicyData(Policy policy) {
        return 0;
    }

    @Override
    public int deleteAgent(User agent) {
        String strQuery = "delete from user_agent where aid=" + agent.getAid();
        int status = 0;
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public User getUser(User user) {
        User user1 = new User();
        if (user.getRole().equals(Role.Klient)) {
            String strQuery = "Select * from user_customer where name='" + user.getName() + "' and pass='"
                    + user.getPassword() + "'";
            System.out.println(strQuery);
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
                while (resultSet.next()) {
                    user1.setId(resultSet.getLong(1));
                    user1.setCid(resultSet.getString(2));
                    user1.setName(resultSet.getString(3));
                    user1.setFname(resultSet.getString(4));
                    user1.setAge(resultSet.getString(5));
                    user1.setGen(resultSet.getString(6));
                    user1.setQua(resultSet.getString(7));
                    user1.setCadd(resultSet.getString(8));
                    user1.setOcc(resultSet.getString(9));
                    user1.setPassword(resultSet.getString(10));
                    user1.setAgname(resultSet.getInt(11));
                    user1.setPhno(resultSet.getString(12));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (user.getRole().equals(Role.Menadżer)) {
            String strQuery = "Select * from user_manager where name='" + user.getName() + "' and pass='"
                    + user.getPassword() + "' or id=" + user.getMname();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
                while (resultSet.next()) {
                    user1.setId(resultSet.getLong(1));
                    user1.setName(resultSet.getString(2));
                    user1.setFname(resultSet.getString(3));
                    user1.setGen(resultSet.getString(4));
                    user1.setAge(resultSet.getString(5));
                    user1.setQua(resultSet.getString(6));
                    user1.setAddd(resultSet.getString(7));
                    user1.setBname(resultSet.getString(8));
                    user1.setPassword(resultSet.getString(9));
                    user1.setPhno(resultSet.getString(10));
                    user1.setMid(Long.valueOf(resultSet.getString(11)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (user.getRole().equals(Role.Agent)) {
            String strQuery = "Select * from user_agent where name='" + user.getMname() + "' and pass='"
                    + user.getPassword() + "'";
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
                while (resultSet.next()) {
                    user1.setId(resultSet.getInt(1));
                    user1.setAid(Long.valueOf(resultSet.getString(2)));
                    user1.setName(resultSet.getString(3));
                    user1.setFname(resultSet.getString(4));
                    user1.setAge(resultSet.getString(5));
                    user1.setGender(Gender.valueOf(resultSet.getString(6)));
                    user1.setQua(resultSet.getString(7));
                    user1.setOcc(resultSet.getString(8));
                    user1.setAddr(resultSet.getString(9));
                    user1.setSec(resultSet.getString(10));
                    user1.setMname(resultSet.getString(11));
                    user1.setPassword(resultSet.getString(11));
                    user1.setPhno(resultSet.getString(13));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user1;
    }

    @Override
    public Policy getPolicy(Policy policy) {
        String strQuery = "Select policy.pid, policy.pamt, policy.pfamt, policy.pint, policy.prat,policy.pbper\n" +
                "From policy\n" +
                "Where policy.pid = '" + policy.getPid() + "'";

        System.out.println(strQuery);
        Policy policy1 = new Policy();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                policy1.setPamt(Double.parseDouble(resultSet.getString("pamt")));
                policy1.setPrat(Double.parseDouble(resultSet.getString("policy.prat")));
                policy1.setPfamt(Double.parseDouble(resultSet.getString("policy.pfamt")));
                policy1.setPbper(Double.parseDouble(resultSet.getString("policy.pbper")));
                policy1.setPint(Double.parseDouble(resultSet.getString("policy.pint")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return policy1;
    }

    @Override
    public ArrayList<Policy> getPolicyStatus(User user) {
//        String strQuery = "Select customer_policy.pid As `Policy Id`, " + "policy.pname As `Policy Name`, "
//                + "customer_policy.pamt As Amount, " + "policy_details1.paamt As `Paid Amount` From "
//                + "user_customer Inner Join customer_policy On user_"
//                + "customer.cid = customer_policy.cid Inner Join policy On customer_"
//                + "policy.pid = policy.pid Inner Join policy_details policy_details1 On "
//                + "customer_policy.cupid = policy_details1.pid Where user_customer.cid = '" + user.getCid() + "'";

        String strQuery = "Select customer_policy.pid As `Policy Id`, " +
                "policy.pname As `Policy Name`, " +
                "customer_policy.pamt As Amount," +
                " policy_details1.paamt As `Paid Amount` , " +
                "policy.pterm As 'Term', " +
                "policy.pint As 'Interest', " +
                "policy.pbper As 'Period', " +
                "policy.desc_ As 'Desc' " +
                "From user_customer " +
                "Inner Join customer_policy On user_customer.cid = customer_policy.cid " +
                "Inner Join policy On customer_policy.pid = policy.pid " +
                "Inner Join policy_details policy_details1 On customer_policy.cupid = policy_details1.pid " +
                "Where user_customer.cid = '" + user.getCid() + "'";
        System.out.println(strQuery);
        ArrayList<Policy> policies = new ArrayList<Policy>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                Policy policy = new Policy();
                policy.setPid(resultSet.getLong("Policy Id"));
                policy.setPname(resultSet.getString("Policy Name"));
                policy.setPamt(resultSet.getLong("Amount"));
                policy.setPfamt(resultSet.getLong("Paid Amount"));
                policy.setPterm(resultSet.getString("Term"));
                policy.setPint(resultSet.getDouble("Interest"));
                policy.setPbper(resultSet.getDouble("Period"));
                policy.setDesc(resultSet.getString("Desc"));
                policies.add(policy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

    @Override
    public int addUser(User newUser) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUser(User user) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ArrayList<Branch> getAllBranches() {
        ArrayList<Branch> branchs = new ArrayList<Branch>();
        String strQeury = "Select * from branch";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                Branch branch = new Branch();
                branch.setId(resultSet.getLong("id"));
                branch.setLocation(resultSet.getString("location"));
                branch.setPhone(resultSet.getString("phone"));
                branch.setName(resultSet.getString("name"));
                branch.setState(resultSet.getString("state"));
                branchs.add(branch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branchs;
    }

    @Override
    public ArrayList<Policy> getAllPolicies() {
        ArrayList<Policy> policies = new ArrayList<Policy>();
        String strQuery = "Select * from policy";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                Policy policy = new Policy();
                policy.setId(resultSet.getLong("id"));
                policy.setPid(resultSet.getLong("pid"));
                policy.setPname(resultSet.getString("pname"));
                policy.setPterm(String.valueOf(resultSet.getLong("pterm")));
                policy.setPamt(resultSet.getLong("pamt"));
                policy.setPfamt(resultSet.getLong("pfamt"));
                policy.setPint(resultSet.getInt("pint"));
                policy.setPbper(resultSet.getInt("pbper"));
                policy.setPrat(resultSet.getInt("prat"));
                policy.setDesc(resultSet.getString("desc_"));
                policies.add(policy);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return policies;
    }

    @Override
    public int isPolicyExists(Policy policy) {
        int status = 0;
        String strQeury = "Select * from policy where pname='" + policy.getPname() + "'";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                status = 1;
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int addPolicy(Policy policy) {
        String strQuery = "insert into policy values(?,?,?,?,?,?,?,?,?,?)";
        int status = 0;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery);
            preparedStatement.setLong(1, getMaxPolicyId() + 1);
            preparedStatement.setLong(2, getMaxPolicyPId() + 1);
            preparedStatement.setString(3, policy.getPname());
            preparedStatement.setLong(4, Long.valueOf(policy.getPterm()));
            preparedStatement.setDouble(5, policy.getPamt());
            preparedStatement.setDouble(6, policy.getPfamt());
            preparedStatement.setDouble(7, policy.getPint());
            preparedStatement.setDouble(8, policy.getPbper());
            preparedStatement.setDouble(9, policy.getPrat());
            preparedStatement.setString(10, policy.getDesc());
            if (isPolicyExists(policy) == 1) {
                status = 2;
            } else {
                status = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int addManager(User user) {
        String strQuery = "insert into user_manager values(?,?,?,?,?,?,?,?,?,?,?)";
        int status = 0;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery);
            preparedStatement.setLong(1, getMaxManagerId() + 1);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getFname());
            preparedStatement.setString(4, user.getGender().name());
            preparedStatement.setString(5, user.getAge());
            preparedStatement.setString(6, user.getQua());
            preparedStatement.setString(7, user.getAddd());
            preparedStatement.setString(8, user.getBname());
            //preparedStatement.setString(9, user.getPassword());
            preparedStatement.setString(9, encrypt.generateStrongPasswordHash(user.getPassword()));
            preparedStatement.setString(10, user.getPhone());
            preparedStatement.setLong(11, getMaxManagerMid() + 1);
            if (isManagerExists(user) == 1) {
                status = 2;
            } else {
                status = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public long getMaxAgentAid() {
        String strQuery = "Select max(aid) from user_agent";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public long getMaxAgentId() {
        String strQuery = "Select max(id) from user_agent";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int isAgentExists(User user) {
        int status = 0;
        String strQeury = "Select * from user_agent";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                if (resultSet.getString("name").toLowerCase().equals(user.getName().toLowerCase())
                        && resultSet.getString("phno").equals(user.getPhno())) {
                    status = 1;
                    break;
                }
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int addAgent(User user) {
        String strQuery = "insert into user_agent values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int status = 0;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery);
            preparedStatement.setInt(1, (int) (getMaxAgentId() + 1));
            preparedStatement.setString(2, (getMaxAgentAid() + 1) + "");
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getFname());
            preparedStatement.setString(5, user.getAge());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setString(7, user.getQua());
            preparedStatement.setString(8, user.getOccu());
            preparedStatement.setString(9, user.getAddd());
            preparedStatement.setString(10, user.getSec());
            preparedStatement.setInt(11, Integer.parseInt(user.getMname()));
            //preparedStatement.setString(12, user.getPassword());
            preparedStatement.setString(12, encrypt.generateStrongPasswordHash(user.getPassword()));
            preparedStatement.setString(13, user.getPhno());
            if (isAgentExists(user) == 1) {
                status = 2;
            } else {
                status = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updateAgent(User user) {
        int status = 0;
        String strQuery = "update user_agent set name='" + user.getName() + "', fname='" + user.getFname()
                + "', gen='" + user.getGender().name() + "', aage='" + user.getAge() + "', qua='" + user.getQua()
                + "', aadd='" + user.getAddd() + "', occu='" + user.getOccu() + "', pass='" + user.getPassword()
                + "', phno='" + user.getPhno() + "', mname=" + user.getMname() + ", sec=" + user.getSec() + " where aid=" + user.getAid();
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }


    @Override
    public int updateCustomerPolicy(Policy policy) {
        int status = 0;
        String strQuery = "update customer_policy set aid='" + policy.getAid() +
                "', nom='" + policy.getNom()
                + "', rela='" + policy.getRela()
                + "', ptype='" + policy.getPoliceType().name()
                + "', pamt='" + policy.getPamt() + "' where cupid='" + policy.getCupid() + "'";
        System.out.println(strQuery);
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }



    @Override
    public int updateCustomer(User user) {
        int status = 0;
        String strQuery = "update user_customer set name='" + user.getName() + "', fname='" + user.getFname()
                + "', gen='" + user.getGender().name() + "', age='" + user.getAge() + "', qua='" + user.getQua()
                + "', cadd='" + user.getCadd() + "', occ='" + user.getOcc() + "', pass='" + user.getPassword()
                + "', phno='" + user.getPhno() + "', agname=" + user.getAgname() + " where cid=" + user.getCid();
        System.out.println(strQuery);
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Policy> getCustomerPolicies() {
        String strQuery = "Select customer_policy.id, customer_policy.cupid As `Customer Policy ID`,\n" +
                "  customer_policy.cid As `Customer ID```, customer_policy.pid As `Policy Type`,\n" +
                "  customer_policy.ptype As `Policy Type`, customer_policy.aid As `Agent ID`,\n" +
                "  customer_policy.nom As Nominee, customer_policy.rela As Relation,\n" +
                "  customer_policy.pamt As Amount\n" +
                "From customer_policy";

        ArrayList<Policy> policies = new ArrayList<>();

        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                Policy policy = new Policy();
                policy.setId(resultSet.getInt(1));
                policy.setCupid(resultSet.getString(2));
                policy.setCid(resultSet.getString(3));
                policy.setPid(Long.parseLong(resultSet.getString(4)));
                policy.setPoliceType(PolicyType.valueOf(resultSet.getString(5)));
                policy.setAid(resultSet.getString(6));
                policy.setNom(resultSet.getString(7));
                policy.setRela(resultSet.getString(8));
                policy.setPamt(Double.parseDouble(resultSet.getString(9)));
                policies.add(policy);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return policies;
    }

    @Override
    public int updateManager(User user) {
        int status = 0;
        String strQuery = "update user_manager set name='" + user.getName() + "', fname='" + user.getFname()
                + "', gen='" + user.getGender().name() + "', age='" + user.getAge() + "', qua='" + user.getQua()
                + "', addd='" + user.getAddd() + "', bname='" + user.getBname() + "', pass='" + user.getPassword()
                + "', phone='" + user.getPhone() + "' where mid=" + user.getMid();
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int isManagerExists(User user) {
        int status = 0;
        String strQeury = "Select * from user_manager";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                if (resultSet.getString("name").toLowerCase().equals(user.getName().toLowerCase())
                        || resultSet.getString("phone").equals(user.getPhone())) {
                    status = 1;
                    break;
                }
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public long getMaxManagerMid() {
        String strQuery = "Select max(mid) from user_manager";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public long getMaxManagerId() {
        String strQuery = "Select max(id) from user_manager";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Branch getBranch() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int addBranch(Branch branch) {
        String strQuery = "insert into branch values(?,?,?,?,?)";
        int status = 0;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery);
            preparedStatement.setLong(1, getMaxBranchId() + 1);
            preparedStatement.setString(2, branch.getName());
            preparedStatement.setString(3, branch.getLocation());
            preparedStatement.setString(4, branch.getPhone());
            preparedStatement.setString(5, branch.getState());
            if (isBranchExists(branch) == 1) {
                status = 2;
            } else {
                status = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int isBranchExists(Branch branch) {
        int status = 0;
        String strQeury = "Select * from branch";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                if (resultSet.getString("name").toLowerCase().equals(branch.getName().toLowerCase())) {
                    status = 1;
                    break;
                }
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public long getMaxPolicyId() {
        String strQuery = "Select max(id) from policy";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public long getMaxPolicyPId() {
        String strQuery = "Select max(pid) from policy";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public long getMaxBranchId() {
        String strQuery = "Select max(id) from branch";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int deleteBranch(Branch branch) {
        String strQuery = "delete from branch where id=" + branch.getId();
        int status = 0;
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteManager(User manager) {
        String strQuery = "delete from user_manager where mid=" + manager.getMid();
        int status = 0;
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deletePolicy(Policy policy) {
        String strQuery = "delete from policy where pid=" + policy.getPid();
        int status = 0;
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updateBranch(Branch branch) {
        int status = 0;
        String strQuery = "update branch set name='" + branch.getName() + "',location='" + branch.getLocation()
                + "',phone='" + branch.getPhone() + "',state='" + branch.getState() + "' where id=" + branch.getId();
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updatePolicy(Policy policy) {
        int status = 0;
        String strQuery = "update policy set pname='" + policy.getPname() + "', " + "pterm=" + policy.getPterm()
                + ", pamt=" + policy.getPterm() + ", pamt=" + policy.getPamt() + ", pfamt=" + policy.getPfamt()
                + ", pint=" + policy.getPint() + ", pbper=" + policy.getPbper() + ", prat=" + policy.getPrat()
                + ", desc_='" + policy.getDesc() + "'" + " where pid=" + policy.getPid();
        System.out.println(strQuery);
        try {
            Statement statement = getConnection().createStatement();
            status = statement.executeUpdate(strQuery);
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<User> getManagers() {
        String strQuery = "Select * from user_manager";
        ArrayList<User> managers = new ArrayList<User>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setFname(resultSet.getString(3));
                user.setGender(Gender.valueOf(resultSet.getString(4)));
                user.setGen(user.getGender().name());
                user.setAge(resultSet.getString(5));
                user.setQua(resultSet.getString(6));
                user.setAddd(resultSet.getString(7));
                user.setBname(resultSet.getString(8));
                user.setPassword(resultSet.getString(9));
                user.setPhone(resultSet.getString(10));
                user.setMid(resultSet.getLong(11));
                user.setRole(Role.Menadżer);
                managers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }

    @Override
    public User getManager(User uiUser) {
        String strQuery = "Select * from user_manager where mname=" + uiUser.getMname();
        User user = new User();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setFname(resultSet.getString(3));
                user.setGender(Gender.valueOf(resultSet.getString(4)));
                user.setGen(user.getGender().name());
                user.setAge(resultSet.getString(5));
                user.setQua(resultSet.getString(6));
                user.setAddd(resultSet.getString(7));
                user.setBname(resultSet.getString(8));
                user.setPassword(resultSet.getString(9));
                user.setPhone(resultSet.getString(10));
                user.setMid(resultSet.getLong(11));
                user.setRole(Role.Menadżer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int addCustomer(User user) {
        String strQuery = "insert into user_customer values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int status = 0;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery);
            preparedStatement.setInt(1, (int) (getMaxCustomerId() + 1));
            preparedStatement.setString(2, (getMaxCustomerCid() + 1) + "");
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getFname());
            preparedStatement.setString(5, user.getAge());
            preparedStatement.setString(6, user.getGender().name());
            preparedStatement.setString(7, user.getQua());
            preparedStatement.setString(8, user.getCadd());
            preparedStatement.setString(9, user.getOcc());
            //preparedStatement.setString(10, user.getPassword());
            preparedStatement.setString(10, encrypt.generateStrongPasswordHash(user.getPassword()));
            preparedStatement.setInt(11, user.getAgname());
            preparedStatement.setString(12, user.getPhno());
            if (isCustomerExists(user) == 1) {
                status = 2;
            } else {
                status = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public long getMaxCustomerId() {
        long id = 0;
        String strQuery = "Select max(id) from user_customer";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    @Override
    public long getMaxCustomerCid() {
        long id = 0;
        String strQuery = "Select max(cid) from user_customer";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    @Override
    public int isCustomerExists(User user) {
        int status = 0;
        String strQuery = "Select * from user_customer";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                if (resultSet.getString("name").toLowerCase().equals(user.getName().toLowerCase())
                        || resultSet.getString("phno").equals(user.getPhone())) {
                    status = 1;
                    break;
                }
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<User> getAllAgents() {
        String strQuery = "Select * from user_agent";
        ArrayList<User> agents = new ArrayList<User>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                User agent = new User();
                agent.setId(resultSet.getInt(1));
                agent.setAid(Long.valueOf(resultSet.getString(2)));
                agent.setName(resultSet.getString(3));
                agent.setFname(resultSet.getString(4));
                agent.setAge(resultSet.getString(5));
                agent.setGender(Gender.valueOf(resultSet.getString(6)));
                agent.setGen(agent.getGender().name());
                agent.setQua(resultSet.getString(7));
                agent.setOcc(resultSet.getString(8));
                agent.setAddr(resultSet.getString(9));
                agent.setSec(resultSet.getString(10));
                agent.setMname(resultSet.getString(11));
                agent.setPassword(resultSet.getString(12));
                agent.setPhno(resultSet.getString(13));
                agent.setRole(Role.Agent);
                agents.add(agent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agents;
    }

    @Override
    public ArrayList<User> getAllCustomers() {
        String strQuery = "Select * from user_customer";
        ArrayList<User> customers = new ArrayList<User>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setCid(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setFname(resultSet.getString(4));
                user.setAge(resultSet.getString(5));
                user.setGender(Gender.valueOf(resultSet.getString(6)));
                user.setGen(resultSet.getString(6));
                user.setQua(resultSet.getString(7));
                user.setCadd(resultSet.getString(8));
                user.setOcc(resultSet.getString(9));
                user.setPassword(resultSet.getString(10));
                user.setAgname(resultSet.getInt(11));
                user.setPhno(resultSet.getString(12));
                user.setRole(Role.Klient);
                customers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public int addCustomerPolicy(Policy policy) {
        String strQuery = "INSERT  INTO customer_policy VALUES(?,?,?,?,?,?,?,?,?)";
        int status = 0;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery);
            preparedStatement.setInt(1, getMaxCustomerPolicyId() + 1);
            preparedStatement.setString(2, String.valueOf(getMaxCustomerPolicyCupid() + 1));
            preparedStatement.setString(3, policy.getCid());
            preparedStatement.setString(4, String.valueOf(policy.getPid()));
            preparedStatement.setString(5, policy.getPoliceType().name());
            preparedStatement.setString(6, policy.getAid());
            preparedStatement.setString(7, policy.getNom());
            preparedStatement.setString(8, policy.getRela());
            preparedStatement.setString(9, String.valueOf(policy.getPamt()));
            if (isCustomerPolicyExits(policy) == 1) {
                status = 2;
            } else {
                status = preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            status = -1;
            e.printStackTrace();
        }

        if (status == 1) {
            String strQuery1 = "INSERT INTO policy_details (cid,paamt,pid)VALUES(?,?,?)";
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(strQuery1);
                preparedStatement.setString(1, policy.getCid());
                preparedStatement.setString(2, "0");
                preparedStatement.setString(3, policy.getCupid());
                status = preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                status = -1;
                throwables.printStackTrace();
            }
        }
        return status;
    }

    @Override
    public int isCustomerPolicyExits(Policy policy) {
        String strQuery = "select * from customer_policy where cid='" + policy.getCid() + "' and pid='" + policy.getPid() + "'";
        int status = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                status = 1;
                break;
            }
        } catch (SQLException throwables) {
            status = -1;
            throwables.printStackTrace();
        }
        return status;
    }

    @Override
    public Payment payPolictAndFetchPaymentDetails(Policy policy, double amountToPay) {
        Payment payment = new Payment();

        String policyQuery = "Select policy_details.paamt\n" +
                "From policy_details\n" +
                "Where policy_details.pid = '" + policy.getCupid() + "'";

        double policyAmount = 0;

        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(policyQuery);
            while (resultSet.next()) {
                policyAmount = Double.parseDouble(resultSet.getString("policy_details.paamt"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        double finalAmount = amountToPay + policyAmount;

        String policyUpdateQuery = "UPDATE policy_details SET paamt='" + finalAmount + "' WHERE pid='" + policy.getCupid() + "'";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(policyUpdateQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String policyNewData = "Select policy_details.pid, policy_details.paamt\n" +
                "From policy_details\n" +
                "Where policy_details.pid = '" + policy.getCupid() + "'";

        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(policyNewData);
            while (resultSet.next()) {
                payment.setStrBalAmt(resultSet.getString("policy_details.paamt"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String strQeury = "Select customer_policy.cupid, customer_policy.ptype, customer_policy.pamt,\n" +
                "  policy_details.paamt, user_customer.name, customer_policy.pid\n" +
                "From customer_policy Inner Join\n" +
                "  policy_details On customer_policy.cupid = policy_details.pid Inner Join\n" +
                "  user_customer On customer_policy.cid = user_customer.cid\n" +
                "Where customer_policy.cupid ='" + policy.getCupid() + "'";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                payment.setStrCusName(resultSet.getString("user_customer.name"));
                payment.setPolicyId(resultSet.getString("customer_policy.pid"));
                payment.setPolicType(PolicyType.valueOf(resultSet.getString("customer_policy.ptype")));
                payment.setStrPaidAmt(resultSet.getString("policy_details.paamt"));
                payment.setStrBalAmt(Double.toString(Double.parseDouble(resultSet.getString("customer_policy.pamt")) -
                        Double.parseDouble(resultSet.getString("policy_details.paamt"))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return payment;
    }

    @Override
    public Payment getPolicyPaymentDetails(Policy policy) {
        Payment payment = new Payment();
        String strQeury = "Select customer_policy.cupid, customer_policy.ptype, customer_policy.pamt,\n" +
                "  policy_details.paamt, user_customer.name, customer_policy.pid\n" +
                "From customer_policy Inner Join\n" +
                "  policy_details On customer_policy.cupid = policy_details.pid Inner Join\n" +
                "  user_customer On customer_policy.cid = user_customer.cid\n" +
                "Where customer_policy.cupid ='" + policy.getCupid() + "'";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQeury);
            while (resultSet.next()) {
                payment.setStrCusName(resultSet.getString("user_customer.name"));
                payment.setPolicyId(resultSet.getString("customer_policy.pid"));
                payment.setPolicType(PolicyType.valueOf(resultSet.getString("customer_policy.ptype")));
                payment.setStrPaidAmt(resultSet.getString("policy_details.paamt"));
                payment.setPolicyAmount(resultSet.getString("customer_policy.pamt"));
                payment.setStrBalAmt(Double.toString(Double.parseDouble(resultSet.getString("customer_policy.pamt")) -
                        Double.parseDouble(resultSet.getString("policy_details.paamt"))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return payment;
    }

    @Override
    public long getMaxCustomerPolicyCupid() {
        String strQuery = "select max(cupid) from customer_policy";
        long id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = Long.parseLong(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    @Override
    public int getMaxCustomerPolicyId() {
        String strQuery = "select max(id) from customer_policy";
        int id = 0;
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(strQuery);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }
}
