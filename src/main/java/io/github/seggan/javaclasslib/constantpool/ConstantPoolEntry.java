package io.github.seggan.javaclasslib.constantpool;

import io.github.seggan.javaclasslib.ByteUtils;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class ConstantPoolEntry {

    private final List<ConstantPoolEntry> constantPool;
    private final ConstantPoolTag tag;

    @ParametersAreNonnullByDefault
    public ConstantPoolEntry(List<ConstantPoolEntry> constantPool, ConstantPoolTag tag) {
        this.constantPool = constantPool;
        this.tag = tag;
        constantPool.add(this);
    }

    public final ConstantPoolTag getTag() {
        return tag;
    }

    /**
     * Returns the index of this entry in the constant pool. Not to be confused with {@link #getIndexBytes()}
     *
     * @return the index of this constant pool entry
     */
    public final int getIndex() {
        return constantPool.indexOf(this) + 1;
    }

    /**
     * Returns the bytes that make up the index of this entry in the constant pool. Not to
     * be confused with {@link #getIndex()}
     *
     * @return a byte array of size 2 representing the index of this constant pool entry
     */
    @Nonnull
    public final byte[] getIndexBytes() {
        return ByteUtils.twoBytesFromInt(getIndex());
    }

    /**
     * Converts this constant pool entry into its byte representation in a class file
     */
    @Nonnull
    public abstract byte[] getBytes();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstantPoolEntry)) return false;
        ConstantPoolEntry that = (ConstantPoolEntry) o;
        return getTag() == that.getTag() && Arrays.equals(getBytes(), that.getBytes());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getTag());
        result = 31 * result + Arrays.hashCode(getBytes());
        return result;
    }
}
