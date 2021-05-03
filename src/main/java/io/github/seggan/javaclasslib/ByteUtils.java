package io.github.seggan.javaclasslib;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ByteUtils {

    private ByteUtils() {}

    @Nonnull
    public static byte[] twoBytesFromInt(int i) {
        byte[] data = new byte[2];
        data[0] = (byte) ((i >> 8) & 0xFF);
        data[1] = (byte) (i & 0xFF);
        return data;
    }

    @Nonnull
    public static byte[] floatToBytes(float f) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putFloat(f).array();
    }

    @Nonnull
    public static byte[] intToBytes(int i) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(i).array();
    }

    @Nonnull
    public static byte[] longToBytes(long l) {
        return ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN).putLong(l).array();
    }

    @Nonnull
    public static byte[] doubleToBytes(double d) {
        return ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN).putDouble(d).array();
    }
}
