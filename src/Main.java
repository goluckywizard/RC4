import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter key: ");
        String keyString = in.nextLine();
        byte[] key = keyString.getBytes();

        RC4 coder = new RC4(key);

        System.out.println("Enter string: ");
        String testString = in.nextLine();

        byte[] testBytes = testString.getBytes();
        byte[] result = coder.encode(testBytes, testBytes.length);
        System.out.println(new String(result));

        RC4 decoder = new RC4(key);
        byte[] decryptedBytes = decoder.decode(result, result.length);
        String decryptedString = new String(decryptedBytes);
        System.out.println(decryptedString);
    }
}
