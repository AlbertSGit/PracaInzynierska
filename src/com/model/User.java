package com.model;

public class User {

    private long id;
    private long aid;
    private String name;
    private String password;
    private Gender gender;
    private String address;
    private String addd;
    private String contact;
    private Role role;
    private long mid;
    private String fname;
    private String age;
    private String qua;
    private String addr;
    private String bname;
    private String cid;
    private String cadd;
    private String occ;
    private int agname;
    private String phno;
    private String gen;
    private String username;
    private String occu;
    private String sec;
    private String mname;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getOccu() {
        return occu;
    }

    public void setOccu(String occu) {
        this.occu = occu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCadd() {
        return cadd;
    }

    public void setCadd(String cadd) {
        this.cadd = cadd;
    }

    public String getOcc() {
        return occ;
    }

    public void setOcc(String occ) {
        this.occ = occ;
    }

    public int getAgname() {
        return agname;
    }

    public void setAgname(int agname) {
        this.agname = agname;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getAddd() {
        return addd;
    }

    public void setAddd(String addd) {
        this.addd = addd;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        if (getRole() != null) {
            return name;
        }
        return "User [id=" + id + ", aid=" + aid + ", name=" + name + ", password=" + password + ", gender=" + gender
                + ", address=" + address + ", addd=" + addd + ", contact=" + contact + ", role=" + role + ", mid=" + mid
                + ", fname=" + fname + ", age=" + age + ", qua=" + qua + ", addr=" + addr + ", bname=" + bname
                + ", cid=" + cid + ", cadd=" + cadd + ", occ=" + occ + ", agname=" + agname + ", phno=" + phno
                + ", gen=" + gen + ", username=" + username + ", occu=" + occu + ", sec=" + sec + ", mname=" + mname
                + ", phone=" + phone + "]";
    }

    public void setRole() {
       this.role = role;
    }
}
