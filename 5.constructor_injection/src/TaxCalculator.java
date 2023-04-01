public class TaxCalculator implements CanCalculateTax {
    private double TaxableIncome;

    public TaxCalculator(double taxableIncome) {
        this.TaxableIncome = taxableIncome;
    }
    @Override  
    public double calculateTax(){
        return TaxableIncome*0.3;
    };
    
}
