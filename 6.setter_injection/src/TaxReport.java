public class TaxReport {
    private CanCalculateTax calculator;

    public TaxReport(CanCalculateTax calculator) { //gets the var by getter
        this.calculator = calculator;
    }

   public void show(){ 
        var tax=calculator.calculateTax();
        System.out.println(tax);
   }
   public void setCalculator(CanCalculateTax calculator){  //when we need to use several versions of same method, we can use a setter to change values time to time
    this.calculator=calculator;
   }
  
}

//injected by constructor & setter .