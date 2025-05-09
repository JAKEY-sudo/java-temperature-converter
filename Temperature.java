import java.util.Scanner;

class Temperature {
    private static final String TEMP_PROMPT = "Enter the temperature: ";
    private static final String UNIT_PROMPT = "Convert to Celsius or Fahrenheit? (C/F): ";
    private static final String OUTPUT_FORMAT = "%.1f°%s";
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double inputTemp = getValidTemperature(scanner);
            String unit = getValidUnit(scanner);
            double convertedTemp = convertTemperature(inputTemp, unit);
            System.out.printf(OUTPUT_FORMAT, convertedTemp, unit);
        }
    }

    private static double getValidTemperature(Scanner scanner) {
        System.out.print(TEMP_PROMPT);  // Changed println to print
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. " + TEMP_PROMPT);
            scanner.next();        
        }
        return scanner.nextDouble();
    }

    private static String getValidUnit(Scanner scanner) {
        System.out.print(UNIT_PROMPT); 
        String unit;
        while (true) {
            unit = scanner.next().toUpperCase();
            if (unit.equals("C") || unit.equals("F")) {  
                return unit;
            }
            System.out.println("Invalid input. " + UNIT_PROMPT);
        }
    }

    private static double convertTemperature(double temp, String unit) {  
        if (unit.equals("C")) {
            return (temp - 32) * 5 / 9;
        } else {
            return (temp * 9 / 5) + 32;
        }
    }
}