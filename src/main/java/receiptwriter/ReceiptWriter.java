package receiptwriter;

import models.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(Order order) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = "receipt-" + now.format(formatter) + ".txt";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(order.toString());
            writer.close();

            System.out.println("Receipt saved as: " + fileName);

            } catch (IOException e) {
                System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
