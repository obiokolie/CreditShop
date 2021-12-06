
package com.obiokolie;

/**
 *
 * @author Obiokolie
 */
public class Customer {
    
	//Declaring class variables
	private String cID;
    private String cName;
    private int cCreditBalance;

    //Class Constructors.  Empty construct and constructors with different combination of arguments
    public Customer() {
    }
    
    public Customer(String cID, String cName, int cCreditBalance) {
        this.cID = cID;
        this.cName = cName;
        this.cCreditBalance = cCreditBalance;
    }
    
    public Customer(String cID, String cName) {
        this.cID = cID;
        this.cName = cName;
    }

    //Declaring Getter and Setters
    public int getcCreditBalance() {
		return cCreditBalance;
	}

	public void setcCreditLimit(int cCreditBalance) {
		this.cCreditBalance = cCreditBalance;
	}

	public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
    
           
}
