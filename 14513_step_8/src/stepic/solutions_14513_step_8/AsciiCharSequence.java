package stepic.solutions_14513_step_8;

/**
 * Created by ipetrash on 19.09.2016.
 */
public class AsciiCharSequence implements CharSequence {
    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] sub_bytes = new byte[end - start];
        System.arraycopy(bytes, start, sub_bytes, 0, sub_bytes.length);

        return new AsciiCharSequence(sub_bytes);
    }

    @Override
    public String toString() {
        return new String(bytes);
    }
}