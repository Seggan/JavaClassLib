package io.github.seggan.javaclasslib.constantpool.types;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.ByteUtils;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;

import javax.annotation.Nonnull;
import java.util.List;

public final class IntegerEntry extends ConstantPoolEntry {

    private final int value;

    public IntegerEntry(List<ConstantPoolEntry> constantPool, int value) {
        super(constantPool, ConstantPoolTag.INTEGER);
        this.value = value;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), ByteUtils.intToBytes(value));
    }
}
