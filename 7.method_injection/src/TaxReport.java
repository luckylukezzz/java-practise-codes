public class TaxReport {
    //private CanCalculateTax calculator;

    // public TaxReport(CanCalculateTax calculator) { 
    //     this.calculator = calculator;
    // }

   public void show(CanCalculateTax calculator){ 
        var tax=calculator.calculateTax();
        System.out.println(tax);
   }
//    public void setCalculator(CanCalculateTax calculator){  
//     this.calculator=calculator;
//    }
  
}

//injected in the method show .