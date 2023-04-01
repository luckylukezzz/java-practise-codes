public class TaxCalculatorV2 implements CanCalculateTax {
    private double TaxableIncome;

    public TaxCalculatorV2(double taxableIncome) {
        this.TaxableIncome = taxableIncome;
    }
    @Override  
    public double calculateTax(){
        return TaxableIncome*0.5;
    };
    
}
