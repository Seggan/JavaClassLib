package io.github.seggan.javaclasslib.methods;

import java.util.Arrays;

public enum MethodAccessFlags {
    PUBLIC(0x0001),
    PRIVATE(0x0002),
    PROTECTED(0x0004),
    STATIC(0x0008),
    FINAL(0x0010),
    SYNCHRONIZED(0x0020),
    BRIDGE(0x0040),
    VARAGRGS(0x0080),
    NATIVE(0x0100),
    ABSTRACT(0x0400),
    STRICT(0x0800),
    SYNTHETIC(0x1000);

    private final int value;

    MethodAccessFlags(int value) {
        this.value = value;
    }

    public static int combine(MethodAccessFlags... flags) {
        return Arrays.stream(flags).mapToInt(MethodAccessFlags::getValue).sum();
    }

    public int getValue() {
        return value;
    }
}
