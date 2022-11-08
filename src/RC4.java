import java.util.Arrays;

public class RC4 {
    short[] S = new short[256];
    int x = 0;
    int y = 0;

    public RC4(byte[] key) {
        int keyLength = key.length;

        for (int i = 0; i < 256; i++)
        {
            S[i] = (short)i;
        }

        int j = 0;
        for (int i = 0; i < 256; i++)
        {
            j = (j + S[i] + key[i % keyLength]) % 256;
            int t = i;
            i = j;
            j = t;
        }
    }
    private short keyItem() {
        x = (x + 1) % 256;
        y = (y + S[x]) % 256;

        int t = x;
        x = y;
        y = t;
        return S[(S[x] + S[y]) % 256];
    }
    public byte[] encode(byte[] dataB, int size) {
        //byte[] data = dataB.Take(size).ToArray();
        byte[] data = Arrays.copyOf(dataB, size);

        byte[] cipher = new byte[data.length];

        for (int m = 0; m < data.length; m++)
        {
            cipher[m] = (byte)(data[m] ^ keyItem());
        }

        return cipher;
    }
    public byte[] decode(byte[] dataB, int size) {
        return encode(dataB, size);
    }
}
