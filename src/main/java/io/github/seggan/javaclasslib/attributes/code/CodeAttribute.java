package io.github.seggan.javaclasslib.attributes.code;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.attributes.Attribute;
import io.github.seggan.javaclasslib.attributes.code.instructions.JvmInstructionImpl;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * <a href="https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.7.3">Oracle Documentation</a>
 */
public final class CodeAttribute extends Attribute {

    private final int maxStackSize;
    private final int maxLocalVarSize;
    private final JvmInstructionImpl[] code;

    /**
     * Creates a new Code attribute
     * @param nameIndex must be a {@link UTF8Entry} pointing to the string "{@code Code}"
     * @param maxStackSize maximum size of the stack
     * @param maxLocalVarSize maximum amount of local variables
     * @param code the actual code to execute
     */
    @ParametersAreNonnullByDefault
    public CodeAttribute(UTF8Entry nameIndex, int maxStackSize, int maxLocalVarSize, JvmInstructionImpl... code) {
        super(nameIndex, "Code");
        this.maxStackSize = maxStackSize;
        this.maxLocalVarSize = maxLocalVarSize;
        this.code = code;
    }

    @ParametersAreNonnullByDefault
    public CodeAttribute(UTF8Entry nameIndex, int maxStackSize, int maxLocalVarSize, List<JvmInstructionImpl> code) {
        this(nameIndex, maxStackSize, maxLocalVarSize, code.toArray(new JvmInstructionImpl[0]));
    }

    @Override
    public byte[] getBytes() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (JvmInstructionImpl instruction : code) {
            for (byte b : instruction.getBytes()) {
                outputStream.write(b);
            }
        }
        byte[] codeByteArray = outputStream.toByteArray();

        byte[] attribute = Bytes.concat(
            ByteUtils.twoBytesFromInt(maxStackSize),
            ByteUtils.twoBytesFromInt(maxLocalVarSize),
            ByteUtils.intToBytes(codeByteArray.length),
            codeByteArray,
            new byte[]{0, 0, 0, 0}
        );

        return Bytes.concat(getNameIndex().getIndexBytes(), ByteUtils.intToBytes(attribute.length), attribute);
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public int getMaxLocalVarSize() {
        return maxLocalVarSize;
    }

    public JvmInstructionImpl[] getCode() {
        return code;
    }
}
