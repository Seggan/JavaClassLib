package io.github.seggan.javaclasslib;

import java.util.Arrays;

public enum ClassAccessFlags {
    PUBLIC(0x0001),
    FINAL(0x0010),
    SUPER(0x0020),
    INTERFACE(0x0200),
    ABSTRACT(0x0400),
    SYNTHETIC(0x1000),
    ANNOTATION(0x2000),
    ENUM(0x4000);

    private final int value;

    ClassAccessFlags(int value) {
        this.value = value;
    }

    public static int combine(ClassAccessFlags... flags) {
        return Arrays.stream(flags).mapToInt(ClassAccessFlags::getValue).sum();
    }

    public int getValue() {
        return value;
    }
}
