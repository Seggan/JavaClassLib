package io.github.seggan.javaclasslib.attributes;

import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

import java.nio.charset.StandardCharsets;

public abstract class Attribute {

    private final UTF8Entry nameIndex;

    public Attribute(UTF8Entry nameIndex, String requiredName) {
        if (!new String(nameIndex.getData(), StandardCharsets.UTF_8).equals(requiredName)) {
            throw new IllegalArgumentException(String.format(
                "Name of \"%s\" is not \"%s\"",
                this.getClass().getName(),
                requiredName
            ));
        }

        this.nameIndex = nameIndex;
    }

    public abstract byte[] getBytes();

    public UTF8Entry getNameIndex() {
        return nameIndex;
    }
}
