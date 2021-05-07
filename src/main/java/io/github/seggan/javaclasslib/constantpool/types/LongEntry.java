package io.github.seggan.javaclasslib.constantpool.types;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.ByteUtils;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;

import javax.annotation.Nonnull;
import java.util.List;

public final class LongEntry extends ConstantPoolEntry {

    private final long value;

    public LongEntry(List<ConstantPoolEntry> constantPool, long value) {
        super(constantPool, ConstantPoolTag.LONG);
        this.value = value;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), ByteUtils.longToBytes(value));
    }

    public long getValue() {
        return value;
    }
}
