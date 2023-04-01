public class TaxReport {
    private CanCalculateTax calculator;

    public TaxReport(CanCalculateTax calculator) {
        this.calculator = calculator;
    }

   public void show(){ 
        var tax=calculator.calculateTax();
        System.out.println(tax);
   }
  
}

//injected by constructor. now this doesnt depend on taxcalculator class 