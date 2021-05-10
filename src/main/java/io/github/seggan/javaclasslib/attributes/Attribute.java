package io.github.seggan.javaclasslib.attributes;

import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

import java.nio.charset.StandardCharsets;

public abstract class Attribute {

    private final UTF8Entry nameIndex;
    private final int length;

    public Attribute(UTF8Entry nameIndex, String requiredName, int length) {
        if (!new String(nameIndex.getData(), StandardCharsets.UTF_8).equals(requiredName)) {
            throw new IllegalArgumentException(String.format(
                "Name of \"%s\" is not \"%s\"",
                this.getClass().getName(),
                requiredName
            ));
        }

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
