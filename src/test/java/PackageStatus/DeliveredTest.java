package PackageStatus;

import PackageStatus.Delivered;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveredTest {
    @Test
    public void testPrintStatus() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Delivered delivered = new Delivered();
        delivered.printStatus();

        String expectedMessage = "package has been delivered!\n";
        assertEquals(expectedMessage, outputStream.toString());
    }
}
