package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Department in an organisation
 */
public class Department {
    
    private String name;
    
    private ArrayList<String> ID1 = new ArrayList<String>();
    
    private ArrayList<String> temp1 = new ArrayList<String>();

    private ArrayList<Integer> employee = new ArrayList<Integer>();

    
    private int ID2;

    private String name;

    public String getID() {
        return ID2;
    }

    public void setID(int ID) {
        this.ID2 = ID;
    }

    
    public boolean checkEmployee(int eID) {

        if (employee.contains(eID)) {   //If the list of emloyee IDs contains the target employee
            System.out.println("Employee exists");  //return the true result and message
            return true;
        }
            //If the ID is not in this object, return false result and message
        System.out.println("Employee doesn't exists");
        return false;    
    }

    

    public void assignNew(string temp2, int ID) {
        this.temp1.add(temp2);
	  this.ID1.add(ID);
    }


}
