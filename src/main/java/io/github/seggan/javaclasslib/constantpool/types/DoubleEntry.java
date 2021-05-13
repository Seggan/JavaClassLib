package io.github.seggan.javaclasslib.constantpool.types;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;
import java.util.List;

public final class DoubleEntry extends ConstantPoolEntry {

    private final double value;

    public DoubleEntry(List<ConstantPoolEntry> constantPool, double value) {
        super(constantPool, ConstantPoolTag.DOUBLE);
        this.value = value;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), ByteUtils.doubleToBytes(value));
    }

    public double getValue() {
        return value;
    }
}
