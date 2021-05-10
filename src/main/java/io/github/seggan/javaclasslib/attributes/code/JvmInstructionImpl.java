package io.github.seggan.javaclasslib.attributes.code;

import io.github.seggan.javaclasslib.attributes.code.instructions.JvmInstruction;

import javax.annotation.Nonnull;

public abstract class JvmInstructionImpl {

    private final JvmInstruction instruction;

    protected JvmInstructionImpl(@Nonnull JvmInstruction instruction) {
        this.instruction = instruction;
    }

    public abstract byte[] getBytes();

    public JvmInstruction getInstruction() {
        return instruction;
    }
}
