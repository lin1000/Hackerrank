package demo.lin1000.java8.labmda.templatemethod;

public class CompanyLambda{


    //Experimental : return a Criteria functional interface
    Criteria supplyCheckIdentity(){
        return () -> {
            System.out.println("checking company identify");
        };
    }

     //Experimental : implement a functional interface
    public void checkIdentity(){
        System.out.println("checking company identity pass");
    }

     //Experimental : implement a functional interface
     public void checkCreditHistory(){
        System.out.println("checking Credit History pass");
    }
    
     //Experimental : implement a functional interface
     public void checkIncomeHistory(){
        System.out.println("checking Income History pass");
    }    
    
}
