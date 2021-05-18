package io.github.seggan.javaclasslib.constantpool.classmembers;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.constantpool.NameAndTypeEntry;

import javax.annotation.Nonnull;
import java.util.List;

abstract class ClassMemberEntry extends ConstantPoolEntry {

    private final ClassEntry clazz;
    private final NameAndTypeEntry nameAndType;

    protected ClassMemberEntry(List<ConstantPoolEntry> constantPool, ConstantPoolTag key, ClassEntry clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, key);
        this.clazz = clazz;
        this.nameAndType = nameAndType;
    }

    protected ClassMemberEntry(List<ConstantPoolEntry> constantPool, ConstantPoolTag key, ClassEntry clazz, String name, String descriptor) {
        this(constantPool, key, clazz, new NameAndTypeEntry(constantPool, name, descriptor));
    }

    protected ClassMemberEntry(List<ConstantPoolEntry> constantPool, ConstantPoolTag key, String clazz, NameAndTypeEntry nameAndType) {
        this(constantPool, key, new ClassEntry(constantPool, clazz), nameAndType);
    }

    protected ClassMemberEntry(List<ConstantPoolEntry> constantPool, ConstantPoolTag key, String clazz, String name, String descriptor) {
        this(constantPool, key, new ClassEntry(constantPool, clazz), new NameAndTypeEntry(constantPool, name, descriptor));
    }

    @Nonnull
    @Override
    public final byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), clazz.getIndexBytes(), nameAndType.getIndexBytes());
    }

    public ClassEntry getClassEntry() {
        return clazz;
    }

    public NameAndTypeEntry getNameAndType() {
        return nameAndType;
    }
}
