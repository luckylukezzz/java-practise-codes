public class Main {
    public static void main(String[] args) {

        // set the dependancy inside the show method
        
        var report = new TaxReport();

        report.show( new  TaxCalculator(5000) );

        report.show(new TaxCalculatorV2(5000));
    }
}
