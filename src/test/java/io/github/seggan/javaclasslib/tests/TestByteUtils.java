package io.github.seggan.javaclasslib.tests;

import io.github.seggan.javaclasslib.ByteUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TestByteUtils {

    @Test
    public void testIntToBytes() {
        Assertions.assertArrayEquals(new byte[]{1, (byte) 0x90}, ByteUtils.twoBytesFromInt(400));
    }

    @Test
    public void testFloatToByte() {
        Assertions.assertArrayEquals(new byte[]{0x3f, (byte) 0x99, (byte) 0x99, (byte) 0x9a},
            ByteUtils.floatToBytes((float) 1.2));
    }

    @Test
    public void testIntToByte() {
        Assertions.assertArrayEquals(new byte[]{0, 0, 0, 0x10},
            ByteUtils.intToBytes(16));
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x ", b));
        return sb.toString();
    }
}
