package io.github.seggan.javaclasslib.attributes.code.instructions;

import com.google.common.primitives.Bytes;
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

/**
 * All instructions that take a constant pool index as a parameter
 */
public class CPInstruction<T extends ConstantPoolEntry> extends JvmInstruction {
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
            return Bytes.concat(new byte[]{this.getInstruction().getInstructionByte()}, param.getIndexBytes());
        }
    }
}
