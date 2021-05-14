package io.github.seggan.javaclasslib.attributes.code.instructions;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.classmembers.FieldrefEntry;
import io.github.seggan.javaclasslib.constantpool.classmembers.MethodrefEntry;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;

public final class JvmInstructions {
    public static final NoArgInstruction ACONST_NULL = new NoArgInstruction(0x01);
    public static final BPInstruction ALOAD = new BPInstruction(0x19);
    public static final CPInstruction<ClassEntry> ANEWARRAY = new CPInstruction<>(0xbd);
    public static final NoArgInstruction ARETURN = new NoArgInstruction(0xb0);
    public static final BPInstruction ASTORE = new BPInstruction(0x3a);
    public static final BPInstruction BIPUSH = new BPInstruction(0x10);
    public static final NoArgInstruction DCONST_0 = new NoArgInstruction(0x0e);
    public static final NoArgInstruction DCONST_1 = new NoArgInstruction(0x0f);
    public static final BPInstruction DLOAD = new BPInstruction(0x18);
    public static final NoArgInstruction DRETURN = new NoArgInstruction(0xaf);
    public static final BPInstruction DSTORE = new BPInstruction(0x39);
    public static final NoArgInstruction DUP = new NoArgInstruction(0x59);
    public static final NoArgInstruction FCONST_0 = new NoArgInstruction(0x0b);
    public static final NoArgInstruction FCONST_1 = new NoArgInstruction(0x0c);
    public static final NoArgInstruction FCONST_2 = new NoArgInstruction(0x0d);
    public static final BPInstruction FLOAD = new BPInstruction(0x17);
    public static final NoArgInstruction FRETURN = new NoArgInstruction(0xae);
    public static final BPInstruction FSTORE = new BPInstruction(0x38);
    public static final CPInstruction<FieldrefEntry> GETFIELD = new CPInstruction<>(0xb4);
    public static final CPInstruction<FieldrefEntry> GETSTATIC = new CPInstruction<>(0xb2);
    public static final BranchInstruction GOTO = new BranchInstruction(0xa7);
    public static final BranchInstruction GOTO_W = new BranchInstruction(0xc8);
    public static final NoArgInstruction IADD = new NoArgInstruction(0x60);
    public static final NoArgInstruction IALOAD = new NoArgInstruction(0x2e);
    public static final NoArgInstruction IASTORE = new NoArgInstruction(0x4f);
    public static final NoArgInstruction ICONST_0 = new NoArgInstruction(0x03);
    public static final NoArgInstruction ICONST_1 = new NoArgInstruction(0x04);
    public static final NoArgInstruction ICONST_2 = new NoArgInstruction(0x05);
    public static final NoArgInstruction ICONST_3 = new NoArgInstruction(0x06);
    public static final NoArgInstruction ICONST_4 = new NoArgInstruction(0x07);
    public static final NoArgInstruction ICONST_5 = new NoArgInstruction(0x08);
    public static final NoArgInstruction ICONST_M1 = new NoArgInstruction(0x02);
    public static final BranchInstruction IFNE = new BranchInstruction(0x9a);
    public static final BPInstruction ILOAD = new BPInstruction(0x15);
    public static final CPInstruction<MethodrefEntry> INVOKESTATIC = new CPInstruction<>(0xb8);
    public static final CPInstruction<MethodrefEntry> INVOKEVIRTUAL = new CPInstruction<>(0xb6);
    public static final NoArgInstruction IRETURN = new NoArgInstruction(0xac);
    public static final BPInstruction ISTORE = new BPInstruction(0x36);
    public static final NoArgInstruction ISUB = new NoArgInstruction(0x64);
    public static final NoArgInstruction LCONST_0 = new NoArgInstruction(0x09);
    public static final NoArgInstruction LCONST_1 = new NoArgInstruction(0x0a);
    public static final CPInstruction<ConstantPoolEntry> LDC = new CPInstruction<>(0x12);
    public static final CPInstruction<ConstantPoolEntry> LDC2_W = new CPInstruction<>(0x14);
    public static final CPInstruction<ConstantPoolEntry> LDC_W = new CPInstruction<>(0x13);
    public static final BPInstruction LLOAD = new BPInstruction(0x16);
    public static final NoArgInstruction LRETURN = new NoArgInstruction(0xad);
    public static final BPInstruction LSTORE = new BPInstruction(0x37);
    public static final CPInstruction<ClassEntry> NEW = new CPInstruction<>(0xbb);
    public static final BPInstruction NEWARRAY = new BPInstruction(0xbc);
    public static final NoArgInstruction NOP = new NoArgInstruction(0x00);
    public static final NoArgInstruction POP = new NoArgInstruction(0x57);
    public static final NoArgInstruction POP2 = new NoArgInstruction(0x58);
    public static final NoArgInstruction RETURN = new NoArgInstruction(0xb1);
    public static final NoArgInstruction SWAP = new NoArgInstruction(0x5f);

    private JvmInstructions() {
    }

    public static final class NoArgInstruction extends JvmInstruction {

        private NoArgInstruction(int instructionByte) {
            super(instructionByte);
        }

        @Nonnull
        public JvmInstructionImpl create() {
            return new SimpleInstructionImpl(this);
        }
    }

    public static final class BPInstruction extends JvmInstruction {

        private BPInstruction(int instructionByte) {
            super(instructionByte);
        }

        @Nonnull
        public JvmInstructionImpl create(int param) {
            return new StorageInstructionImpl(this, param);
        }

        private static final class StorageInstructionImpl extends JvmInstructionImpl {

            private final int param;

            protected StorageInstructionImpl(@Nonnull JvmInstruction instruction, int param) {
                super(instruction);
                this.param = param;
            }

            @Override
            public byte[] getBytes() {
                return new byte[]{getInstruction().getInstructionByte(), (byte) param};
            }
        }
    }

    public static class CPInstruction<T extends ConstantPoolEntry> extends JvmInstruction {

        private CPInstruction(int instructionByte) {
            super(instructionByte);
        }

        @Nonnull
        public JvmInstructionImpl create(@Nonnull T param) {
            return new CPInstructionImpl(this, param);
        }

        private static final class CPInstructionImpl extends JvmInstructionImpl {

            @Nonnull
            private final ConstantPoolEntry param;

            protected CPInstructionImpl(@Nonnull JvmInstruction instruction, @Nonnull ConstantPoolEntry param) {
                super(instruction);
                this.param = param;
            }

            @Override
            public byte[] getBytes() {
                byte[] bytes;
                if (getInstruction().getInstructionByte() == LDC.getInstructionByte()) {
                    bytes = new byte[]{(byte) param.getIndex()};
                } else {
                    bytes = param.getIndexBytes();
                }
                return Bytes.concat(getInstruction().getInstructionBytes(), bytes);
            }
        }
    }

    public static final class BranchInstruction extends JvmInstruction {

        private BranchInstruction(int instructionByte) {
            super(instructionByte);
        }

        @Nonnull
        public JvmInstructionImpl create(int offset) {
            return new BranchInstructionImpl(this, offset);
        }

        private static final class BranchInstructionImpl extends JvmInstructionImpl {

            private final int offset;

            protected BranchInstructionImpl(@Nonnull JvmInstruction instruction, int offset) {
                super(instruction);
                this.offset = offset;
            }

            @Override
            public byte[] getBytes() {
                byte[] bytes;
                if (this.getInstruction().getInstructionByte() == GOTO.getInstructionByte() ) {
                    bytes = new byte[]{(byte) offset};
                } else {
                    bytes = ByteUtils.twoBytesFromInt(offset);
                }
                return Bytes.concat(getInstruction().getInstructionBytes(), bytes);
            }
        }
    }
}
