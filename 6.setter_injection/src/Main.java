public class Main {
    public static void main(String[] args) {

        // we use main method for concrete implementations
        
        var report =new TaxReport(new TaxCalculator(5000));
        report.show();

        report.setCalculator(new TaxCalculatorV2(5000));
        report.show();
    }
}
