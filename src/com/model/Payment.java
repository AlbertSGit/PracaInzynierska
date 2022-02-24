package com.model;

public class Payment {

    String strCusName;
    String policyId;
    String policyAmount;
    PolicyType policType;
    String strPaidAmt;
    String strBalAmt;

    public String getStrCusName() {
        return strCusName;
    }

    public void setStrCusName(String strCusName) {
        this.strCusName = strCusName;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(String policyAmount) {
        this.policyAmount = policyAmount;
    }

    public PolicyType getPolicType() {
        return policType;
    }

    public void setPolicType(PolicyType policType) {
        this.policType = policType;
    }

    public String getStrPaidAmt() {
        return strPaidAmt;
    }

    public void setStrPaidAmt(String strPaidAmt) {
        this.strPaidAmt = strPaidAmt;
    }

    public String getStrBalAmt() {
        return strBalAmt;
    }

    public void setStrBalAmt(String strBalAmt) {
        this.strBalAmt = strBalAmt;
    }
}
