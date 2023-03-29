public class TaxCalculator implements CanCalculateTax {
    private double TaxableIncome;

    public TaxCalculator(double taxableIncome) {
        this.TaxableIncome = taxableIncome;
    }
    @Override  // not essential but good practise to show this method is implemented
    public double calculateTax(){
        return TaxableIncome*0.3;
    };
    
}
