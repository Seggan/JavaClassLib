package io.github.seggan.javaclasslib.attributes.code.instructions;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.ByteUtils;
import io.github.seggan.javaclasslib.attributes.code.JvmInstructionImpl;
import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.classmembers.FieldrefEntry;
import io.github.seggan.javaclasslib.constantpool.classmembers.MethodrefEntry;
import io.github.seggan.javaclasslib.constantpool.types.DoubleEntry;
import io.github.seggan.javaclasslib.constantpool.types.FloatEntry;
import io.github.seggan.javaclasslib.constantpool.types.IntegerEntry;
import io.github.seggan.javaclasslib.constantpool.types.LongEntry;
import io.github.seggan.javaclasslib.constantpool.types.StringEntry;

import javax.annotation.Nonnull;

public final class JvmInstructions {
    /**
     * Pushes {@code null} onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., null</dd>
     * </dl>
     */
    public static final StackInstruction ACONST_NULL = new StackInstruction(0x01);
    /**
     * Loads an object reference from local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., objectref</dd>
     * </dl>
     */
    public static final BPInstruction ALOAD = new BPInstruction(0x19);
    /**
     * Creates a new array of size {@code count}, taking a {@link ClassEntry} as the array type
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to a {@link ClassEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., count →</dd>
     *     <dd>..., arrayref</dd>
     * </dl>
     */
    public static final CPInstruction<ClassEntry> ANEWARRAY = new CPInstruction<>(0xbd);
    /**
     * Stores an object reference into local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., objectref →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final BPInstruction ASTORE = new BPInstruction(0x3a);
    /**
     * Pushes the parameter onto the stack as an integer value
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>A byte</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final BPInstruction BIPUSH = new BPInstruction(0x10);
    /**
     * Pushes {@code 0.0} (a double) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 0.0</dd>
     * </dl>
     */
    public static final StackInstruction DCONST_0 = new StackInstruction(0x0e);
    /**
     * Pushes {@code 1.0} (a double) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 1.0</dd>
     * </dl>
     */
    public static final StackInstruction DCONST_1 = new StackInstruction(0x0f);
    /**
     * Loads a double from local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final BPInstruction DLOAD = new BPInstruction(0x18);
    /**
     * Stores a double into local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final BPInstruction DSTORE = new BPInstruction(0x39);
    /**
     * Duplicates the top value of the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>..., value, value</dd>
     * </dl>
     */
    public static final StackInstruction DUP = new StackInstruction(0x59);
    /**
     * Pushes {@code 0.0} (a float) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 0.0</dd>
     * </dl>
     */
    public static final StackInstruction FCONST_0 = new StackInstruction(0x0b);
    /**
     * Pushes {@code 1.0} (a float) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 1.0</dd>
     * </dl>
     */
    public static final StackInstruction FCONST_1 = new StackInstruction(0x0c);
    /**
     * Pushes {@code 2.0} (a float) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 2.0</dd>
     * </dl>
     */
    public static final StackInstruction FCONST_2 = new StackInstruction(0x0d);
    /**
     * Loads a float from local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final BPInstruction FLOAD = new BPInstruction(0x17);
    /**
     * Stores a float into local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final BPInstruction FSTORE = new BPInstruction(0x38);
    /**
     * Gets a field from the object on the stack. The field is specified by the parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to a {@link FieldrefEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., objectref →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final CPInstruction<FieldrefEntry> GETFIELD = new CPInstruction<>(0xb4);
    /**
     * Gets a static field specified by the parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to a {@link FieldrefEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final CPInstruction<FieldrefEntry> GETSTATIC = new CPInstruction<>(0xb2);
    /**
     * Goes to another instruction. The index of the other instruction is {@code thisIndex - parameter}
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Instruction offset of the instruction to go to (1 byte)</dd>
     *     <dt>Stack:</dt>
     *     <dd>[unchanged]</dd>
     * </dl>
     */
    public static final BranchInstruction GOTO = new BranchInstruction(0xa7);
    /**
     * Goes to another instruction. The index of the other instruction is {@code thisIndex - parameter}
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Instruction offset of the instruction to go to (2 bytes)</dd>
     *     <dt>Stack:</dt>
     *     <dd>[unchanged]</dd>
     * </dl>
     */
    public static final BranchInstruction GOTO_W = new BranchInstruction(0xc8);
    /**
     * Add two ints
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., value1, value2 →</dd>
     *     <dd>..., result</dd>
     * </dl>
     */
    public static final StackInstruction IADD = new StackInstruction(0x60);
    /**
     * Pushes {@code 0} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 0</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_0 = new StackInstruction(0x03);
    /**
     * Pushes {@code 1} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 1</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_1 = new StackInstruction(0x04);
    /**
     * Pushes {@code 2} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 2</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_2 = new StackInstruction(0x05);
    /**
     * Pushes {@code 3} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 3</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_3 = new StackInstruction(0x06);
    /**
     * Pushes {@code 4} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 4</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_4 = new StackInstruction(0x07);
    /**
     * Pushes {@code 5} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 5</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_5 = new StackInstruction(0x08);
    /**
     * Pushes {@code -1} (an int) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., -1</dd>
     * </dl>
     */
    public static final StackInstruction ICONST_M1 = new StackInstruction(0x02);
    /**
     * If value is not zero, go to another instruction as specified by {@link #GOTO_W}
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Instruction offset of the instruction to go to (2 bytes)</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final BranchInstruction IFNE = new BranchInstruction(0x9a);
    /**
     * Loads an int from local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final BPInstruction ILOAD = new BPInstruction(0x15);
    /**
     * Invokes a static method specified by the parameter. The arguments for the method must be on the
     * stack, with the first argument being deepest in the stack
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to a {@link MethodrefEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., [arg1, arg2, ...] →</dd>
     *     <dd>..., result</dd>
     * </dl>
     */
    public static final CPInstruction<MethodrefEntry> INVOKESTATIC = new CPInstruction<>(0xb8);
    /**
     * Invokes a virtual (i.e. instance) method on the object on the stack, taking a {@link MethodrefEntry}
     * as a parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to a {@link MethodrefEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., objectref, [arg1, arg2, ...] →</dd>
     *     <dd>..., result</dd>
     * </dl>
     */
    public static final CPInstruction<MethodrefEntry> INVOKEVIRTUAL = new CPInstruction<>(0xb6);
    /**
     * Stores an int into local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final BPInstruction ISTORE = new BPInstruction(0x36);
    /**
     * Subtract two ints
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., value1, value2 →</dd>
     *     <dd>..., result</dd>
     * </dl>
     */
    public static final StackInstruction ISUB = new StackInstruction(0x64);
    /**
     * Pushes {@code 0} (a long) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 0</dd>
     * </dl>
     */
    public static final StackInstruction LCONST_0 = new StackInstruction(0x09);
    /**
     * Pushes {@code 1} (a long) onto the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., 1</dd>
     * </dl>
     */
    public static final StackInstruction LCONST_1 = new StackInstruction(0x0a);
    /**
     * Loads a String, int, float, or Class from the constant pool (index specified by the parameter)
     * onto the stack
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to {@link StringEntry}, {@link IntegerEntry},
     *          {@link FloatEntry}, or {@link ClassEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final CPInstruction<ConstantPoolEntry> LDC = new CPInstruction<>(0x12);
    /**
     * Loads a double or long from the constant pool (index specified by the parameter)
     * onto the stack
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to either {@link DoubleEntry} or {@link LongEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final CPInstruction<ConstantPoolEntry> LDC2_W = new CPInstruction<>(0x14);
    /**
     * Loads a String, int, float, or Class from the constant pool (index specified by the parameter)
     * onto the stack
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to {@link StringEntry}, {@link IntegerEntry},
     *          {@link FloatEntry}, or {@link ClassEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final CPInstruction<ConstantPoolEntry> LDC_W = new CPInstruction<>(0x13);
    /**
     * Loads a long from local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., value</dd>
     * </dl>
     */
    public static final BPInstruction LLOAD = new BPInstruction(0x16);
    /**
     * Stores a long into local variable #parameter
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Index of variable</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final BPInstruction LSTORE = new BPInstruction(0x37);
    /**
     * Creates a new class (type of which is a {@link ClassEntry} specified by the parameter) and
     * pushes it onto the stack
     *
     * <dl>
     *     <dt>Parameters:</dt>
     *     <dd>Constant pool index that points to {@link ClassEntry}</dd>
     *     <dt>Stack:</dt>
     *     <dd>..., →</dd>
     *     <dd>..., objectref</dd>
     * </dl>
     */
    public static final CPInstruction<ClassEntry> NEW = new CPInstruction<>(0xbb);
    /**
     * Discards the top value of the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., value →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final StackInstruction POP = new StackInstruction(0x57);
    /**
     * Discards the top two values of the stack, or or the top value if it's a double or
     * long
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., {value1, value2} →</dd>
     *     <dd>...,</dd>
     * </dl>
     */
    public static final StackInstruction POP2 = new StackInstruction(0x58);
    /**
     * Swaps the top two values on the stack
     *
     * <dl>
     *     <dt>Stack:</dt>
     *     <dd>..., value1, value2 →</dd>
     *     <dd>..., value2, value1</dd>
     * </dl>
     */
    public static final StackInstruction SWAP = new StackInstruction(0x5f);

    private JvmInstructions() {
    }

    /**
     * An instruction that performs a simple operation on the stack
     */
    public static final class StackInstruction extends JvmInstruction {

        private StackInstruction(int instructionByte) {
            super(instructionByte);
        }

        @Nonnull
        public JvmInstructionImpl create() {
            return new SimpleInstructionImpl(this);
        }
    }

    /**
     * An instruction that has one byte as a parameter
     */
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

    /**
     * An instruction that takes a constant pool index as a parameter
     */
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
                if (getInstruction().getInstructionByte() == (byte) 0x12) {
                    bytes = new byte[]{(byte) param.getIndex()};
                } else {
                    bytes = param.getIndexBytes();
                }
                return Bytes.concat(getInstruction().getInstructionBytes(), bytes);
            }
        }
    }

    /**
     * Instructions that branch (e.x. {@code goto})
     */
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
                if (this.getInstruction().getInstructionByte() == (byte) 0xa7) {
                    bytes = new byte[]{(byte) offset};
                } else {
                    bytes = ByteUtils.twoBytesFromInt(offset);
                }
                return Bytes.concat(getInstruction().getInstructionBytes(), bytes);
            }
        }
    }
}