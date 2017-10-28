package demo.lin1000.java8.labmda.templatemethod;

public class EmployeeLoanApplication extends LoanApplication{

	@Override
	protected void checkIdentity() throws ApplicationDenied {
        System.out.println("checkIdentity employee");
		
	}

	@Override
	protected void checkCreditHistory() throws ApplicationDenied {
        System.out.println("checkCreditHistory employee");
	}

	@Override
	protected void checkIncomeHistory() throws ApplicationDenied {
		System.out.println("checkIncomeHistory employee");
	}

	@Override
	protected void reportFindings() throws ApplicationDenied {
		System.out.println("reportFindings employee");
	}


    public static void main(String[] args){
        EmployeeLoanApplication employeeLoanApplication = new EmployeeLoanApplication();
        try {
            employeeLoanApplication.checkLoadApplication();
        } catch(ApplicationDenied e){
            e.printStackTrace();
        }
    }

}