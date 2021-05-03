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

    public ClassMemberEntry(List<ConstantPoolEntry> constantPool, ConstantPoolTag key, ClassEntry clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, key);
        this.clazz = clazz;
        this.nameAndType = nameAndType;
    }

    @Nonnull
    @Override
    public final byte[] getBytes() {
        return Bytes.concat(getTag().getByte(), clazz.getIndexBytes(), nameAndType.getIndexBytes());
    }
}
