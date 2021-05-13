package io.github.seggan.javaclasslib.attributes.code;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.attributes.Attribute;
import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.5">Oracle Documentation</a>
 */
public final class ExceptionsAttribute extends Attribute {

    private final ClassEntry[] exceptions;

    /**
     * Creates a new Exceptions attribute
     * @param nameIndex must be a {@link UTF8Entry} pointing to the string "{@code Exceptions}"
     * @param exceptions a list of exceptions the method is declared to throw
     */
    public ExceptionsAttribute(@Nonnull UTF8Entry nameIndex, @Nonnull ClassEntry... exceptions) {
        super(nameIndex, "Exceptions");
        this.exceptions = exceptions;
    }

    public ExceptionsAttribute(@Nonnull UTF8Entry nameIndex, @Nonnull List<ClassEntry> exceptions) {
        this(nameIndex, exceptions.toArray(new ClassEntry[0]));
    }

    @Override
    public byte[] getBytes() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (ClassEntry entry : exceptions) {
            for (byte b : entry.getIndexBytes()) {
                outputStream.write(b);
            }
        }
        byte[] bytes = outputStream.toByteArray();

        return Bytes.concat(getNameIndex().getIndexBytes(), ByteUtils.intToBytes(bytes.length + 2),
            ByteUtils.twoBytesFromInt(exceptions.length), bytes);
    }
}
