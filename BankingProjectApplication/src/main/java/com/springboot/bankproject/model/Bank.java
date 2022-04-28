package com.springboot.bankproject.model;

import java.util.List;

public class Bank implements Comparable<Bank> {
    Integer bankCode;
    String bankName;
    Address mainofficeAddr;
    
    List<Branch> branches;

    public Bank() {
    	this.bankCode = null;
        this.bankName = "";
        this.mainofficeAddr = null;
    }

    public Bank(Integer bankCode, String bankName, Address mainofficeAddr) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.mainofficeAddr = mainofficeAddr;
    }
    public Bank(Integer bankCode, String bankName) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.mainofficeAddr = null;
    }

    public Bank(String bankName, Address mainofficeAddr) {
        this.bankName = bankName;
        this.mainofficeAddr = mainofficeAddr;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Address getMainofficeAddr() {
        return mainofficeAddr;
    }

    public void setMainofficeAddr(Address mainofficeAddr) {
        this.mainofficeAddr = mainofficeAddr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
        result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bank other = (Bank) obj;
        if (bankCode == null) {
            if (other.bankCode != null)
                return false;
        } else if (!bankCode.equals(other.bankCode))
            return false;
        if (bankName == null) {
            if (other.bankName != null)
                return false;
        } else if (!bankName.equals(other.bankName))
            return false;
        return true;
    }

    @Override
    public int compareTo(Bank m) {
        return this.bankCode - m.bankCode;
    }

    @Override
    public String toString() {
        return "Bank [bankCode=" + bankCode + ", bankName=" + bankName + ", mainofficeAddr=" + mainofficeAddr + "]";
    }

}
