package demo.lin1000.java8.labmda.templatemethod;

public abstract class LoanApplication {

    public void checkLoadApplication() throws ApplicationDenied{
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity() throws ApplicationDenied;
    protected abstract void checkCreditHistory() throws ApplicationDenied;
    protected abstract void checkIncomeHistory() throws ApplicationDenied;
    protected abstract void reportFindings() throws ApplicationDenied;

}