package io.github.seggan.javaclasslib.attributes;

import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

public final class CodeAttribute extends Attribute {

    public CodeAttribute(UTF8Entry nameIndex, int length) {
        super(nameIndex, length);
    }

    @Override
    public byte[] getBytes() {
        return new byte[0];
    }
}
