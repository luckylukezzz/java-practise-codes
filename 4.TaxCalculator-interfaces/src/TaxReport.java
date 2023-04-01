public class TaxReport {
    private TaxCalculator calculator;

    public TaxReport() {
        calculator = new TaxCalculator(5000);
    }

   public void show(){ 
        var tax=calculator.calculateTax();
        System.out.println(tax);
   }
  
}

//check next code to see how to change this injected