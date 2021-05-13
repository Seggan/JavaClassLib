package io.github.seggan.javaclasslib.attributes;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.10">Oracle Documentation</a>
 */
public final class SourceFileAttribute extends Attribute {

    private final UTF8Entry sourceFile;

    /**
     * Creates a new SourceFile attribute
     * @param nameIndex must be a {@link UTF8Entry} pointing to the string "{@code SourceFile}"
     * @param sourceFile a {@link UTF8Entry} pointing to the name of the source file this was generated from
     */
    public SourceFileAttribute(@Nonnull UTF8Entry nameIndex, @Nonnull UTF8Entry sourceFile) {
        super(nameIndex, "SourceFile");
        this.sourceFile = sourceFile;
    }

    @Override
    public byte[] getBytes() {
        return Bytes.concat(getNameIndex().getIndexBytes(), ByteUtils.intToBytes(2), sourceFile.getIndexBytes());
    }
}
