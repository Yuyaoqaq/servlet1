package com.cy.model.VO;

import com.cy.model.Contract;
import com.cy.model.House;
import com.cy.model.Lessee;

public class ContractVO extends Contract {
    private String address;
    private String name;

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ContractVO{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
