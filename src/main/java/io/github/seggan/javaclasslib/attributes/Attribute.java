package io.github.seggan.javaclasslib.attributes;

import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

public abstract class Attribute {

    private final UTF8Entry nameIndex;
    private final int length;

    public Attribute(UTF8Entry nameIndex, int length) {
        this.nameIndex = nameIndex;
        this.length = length;
    }

    public abstract byte[] getBytes();

    public UTF8Entry getNameIndex() {
        return nameIndex;
    }

    public int getLength() {
        return length;
    }
}
