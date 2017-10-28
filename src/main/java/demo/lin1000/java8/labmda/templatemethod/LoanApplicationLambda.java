package demo.lin1000.java8.labmda.templatemethod;

public class LoanApplicationLambda {

    private  Criteria identity;
    private  Criteria creditHistory;
    private  Criteria incomeHistory;

    public LoanApplicationLambda(Criteria identity, Criteria creditHistory,Criteria incomeHistory){
        this.identity = identity;
        this.creditHistory = creditHistory;
        this.incomeHistory = incomeHistory;
    }

    public void checkLoanApplication() throws ApplicationDenied{
        identity.check();
        creditHistory.check();
        incomeHistory.check();
        reportFindings();
    }

    private void reportFindings(){
    }
}