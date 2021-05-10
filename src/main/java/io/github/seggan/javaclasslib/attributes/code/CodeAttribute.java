package io.github.seggan.javaclasslib.attributes.code;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.attributes.Attribute;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

public final class CodeAttribute extends Attribute {

    private final int maxStackSize;
    private final int maxLocalVarSize;
    private final JvmInstructionImpl[] code;

    public CodeAttribute(UTF8Entry nameIndex, int length, int maxStackSize, int maxLocalVarSize, JvmInstructionImpl... code) {
        super(nameIndex, "Code", length);
        this.maxStackSize = maxStackSize;
        this.maxLocalVarSize = maxLocalVarSize;
        this.code = code;
    }

    @Override
    public byte[] getBytes() {
        return Bytes.concat();
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
