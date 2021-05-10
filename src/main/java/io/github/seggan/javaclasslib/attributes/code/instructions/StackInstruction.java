package io.github.seggan.javaclasslib.attributes.code.instructions;

import io.github.seggan.javaclasslib.attributes.code.JvmInstructionImpl;

import javax.annotation.Nonnull;

/**
 * An instruction that performs a simple operation on the stack
 */
public final class StackInstruction extends JvmInstruction {

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

    private StackInstruction(int instructionByte) {
        super(instructionByte);
    }

    @Nonnull
    public JvmInstructionImpl create() {
        return new SimpleInstructionImpl(this);
    }
}
