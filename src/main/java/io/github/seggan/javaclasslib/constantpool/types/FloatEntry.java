package io.github.seggan.javaclasslib.constantpool.types;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;
import java.util.List;

public final class FloatEntry extends ConstantPoolEntry {

    private final float value;

    public FloatEntry(List<ConstantPoolEntry> constantPool, float value) {
        super(constantPool, ConstantPoolTag.FLOAT);
        this.value = value;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), ByteUtils.floatToBytes(value));
    }

    public float getValue() {
        return value;
    }
}
