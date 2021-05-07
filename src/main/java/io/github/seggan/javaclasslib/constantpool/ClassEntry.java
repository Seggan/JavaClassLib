package io.github.seggan.javaclasslib.constantpool;

import com.google.common.primitives.Bytes;

import javax.annotation.Nonnull;
import java.util.List;

public final class ClassEntry extends ConstantPoolEntry {

    private final UTF8Entry name;

    public ClassEntry(List<ConstantPoolEntry> constantPool, UTF8Entry name) {
        super(constantPool, ConstantPoolTag.CLASS);
        this.name = name;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), name.getIndexBytes());
    }

    public UTF8Entry getName() {
        return name;
    }
}
