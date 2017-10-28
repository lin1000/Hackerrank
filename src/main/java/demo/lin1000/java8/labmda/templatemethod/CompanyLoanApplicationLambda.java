package demo.lin1000.java8.labmda.templatemethod;

public class CompanyLoanApplicationLambda extends LoanApplicationLambda{

    public CompanyLoanApplicationLambda(CompanyLambda company){

        super(company::checkIdentity,company::checkCreditHistory,company::checkIncomeHistory);
    }

    public static void main(String[] args){
        CompanyLambda company = new CompanyLambda();
        CompanyLoanApplicationLambda companyLoanApplicationLambda = new CompanyLoanApplicationLambda(company);
        try {
			companyLoanApplicationLambda.checkLoanApplication();
		} catch (ApplicationDenied e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}