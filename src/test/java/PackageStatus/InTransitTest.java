package PackageStatus;

import PackageStatus.InTransit;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InTransitTest {
    @Test
    public void testPrintStatus() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        InTransit inTransit = new InTransit();
        inTransit.printStatus();

        String expectedMessage = "package is in transit!\n";
        assertEquals(expectedMessage, outputStream.toString());
    }
}
