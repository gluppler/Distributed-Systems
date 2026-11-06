import java.io.*;
import java.util.*;

public class DataProcessor {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java DataProcessor <input_file> <output_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        List<Double> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found: " + inputFile);
            System.exit(1);
        }

        if (numbers.isEmpty()) {
            System.out.println("Warning: No numbers found in input file.");
            return;
        }

        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }

        double average = sum / numbers.size();

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("=== HTCondor Data Processing Summary ===");
            writer.println("Total Records Processed: " + numbers.size());
            writer.printf("Sum:                   %.2f\n", sum);
            writer.printf("Average:               %.2f\n", average);
            writer.printf("Minimum Value:         %.2f\n", min);
            writer.printf("Maximum Value:         %.2f\n", max);
            writer.println("========================================");
            System.out.println("Processing completed. Output written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
            System.exit(1);
        }
    }
}
