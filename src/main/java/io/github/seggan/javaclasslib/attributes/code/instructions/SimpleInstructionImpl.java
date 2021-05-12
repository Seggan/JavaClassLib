package io.github.seggan.javaclasslib.attributes.code.instructions;

import io.github.seggan.javaclasslib.attributes.code.JvmInstructionImpl;

import javax.annotation.Nonnull;

final class SimpleInstructionImpl extends JvmInstructionImpl {

    protected SimpleInstructionImpl(@Nonnull JvmInstruction instruction) {
        super(instruction);
    }

    @Override
    public byte[] getBytes() {
        return getInstruction().getInstructionBytes();
    }
}
