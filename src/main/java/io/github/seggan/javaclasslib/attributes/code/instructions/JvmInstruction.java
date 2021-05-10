package io.github.seggan.javaclasslib.attributes.code.instructions;

public abstract class JvmInstruction {

    private final byte instructionByte;

    protected JvmInstruction(int instructionByte) {
        this.instructionByte = (byte) instructionByte;
    }

    public byte getInstructionByte() {
        return instructionByte;
    }
}
