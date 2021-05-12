package io.github.seggan.javaclasslib.attributes.code;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.ByteUtils;
import io.github.seggan.javaclasslib.attributes.Attribute;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

import java.io.ByteArrayOutputStream;
import java.util.List;

public final class CodeAttribute extends Attribute {

    private final int maxStackSize;
    private final int maxLocalVarSize;
    private final List<JvmInstructionImpl> code;

    public CodeAttribute(UTF8Entry nameIndex, int maxStackSize, int maxLocalVarSize, List<JvmInstructionImpl> code) {
        super(nameIndex, "Code");
        this.maxStackSize = maxStackSize;
        this.maxLocalVarSize = maxLocalVarSize;
        this.code = code;
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

    public List<JvmInstructionImpl> getCode() {
        return code;
    }
}
