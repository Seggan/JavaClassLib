package io.github.seggan.javaclasslib.constantpool;

import com.google.common.primitives.Bytes;

import javax.annotation.Nonnull;
import java.util.List;

public final class NameAndTypeEntry extends ConstantPoolEntry {

    private final UTF8Entry name;
    private final UTF8Entry descriptor;

    public NameAndTypeEntry(List<ConstantPoolEntry> constantPool, UTF8Entry name, UTF8Entry descriptor) {
        super(constantPool, ConstantPoolTag.NAME_AND_TYPE);
        this.name = name;
        this.descriptor = descriptor;
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), name.getIndexBytes(), descriptor.getIndexBytes());
    }

    public UTF8Entry getName() {
        return name;
    }

    public UTF8Entry getDescriptor() {
        return descriptor;
    }
}
