package io.github.seggan.javaclasslib.constantpool.types;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

import javax.annotation.Nonnull;
import java.util.List;

public final class StringEntry extends ConstantPoolEntry {

    private final UTF8Entry string;

    public StringEntry(List<ConstantPoolEntry> constantPool, UTF8Entry string) {
        super(constantPool, ConstantPoolTag.STRING);
        this.string = string;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), string.getIndexBytes());
    }
}
