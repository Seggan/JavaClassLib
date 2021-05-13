package io.github.seggan.javaclasslib.constantpool;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class UTF8Entry extends ConstantPoolEntry {

    private final byte[] data;

    public UTF8Entry(List<ConstantPoolEntry> constantPool, byte[] data) {
        super(constantPool, ConstantPoolTag.UTF_8);
        this.data = data;
    }

    public UTF8Entry(List<ConstantPoolEntry> constantPool, String s) {
        this(constantPool, s.getBytes(StandardCharsets.UTF_8));
    }

    @Nonnull
    @Override
    public byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), ByteUtils.twoBytesFromInt(data.length), data);
    }

    public byte[] getData() {
        return data;
    }
}
