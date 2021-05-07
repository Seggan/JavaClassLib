package io.github.seggan.javaclasslib.tests;

import io.github.seggan.javaclasslib.ClassAccessFlags;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAccess {

    @Test
    public void testAccess() {
        Assertions.assertEquals("401", Integer.toHexString(ClassAccessFlags.combine(ClassAccessFlags.PUBLIC, ClassAccessFlags.ABSTRACT)));
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x ", b));
        return sb.toString();
    }
}
