package io.github.seggan.javaclasslib.constantpool.classmembers;

import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.constantpool.NameAndTypeEntry;

import java.util.List;

public final class MethodrefEntry extends ClassMemberEntry {

    public MethodrefEntry(List<ConstantPoolEntry> constantPool, ClassEntry clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, ConstantPoolTag.METHODREF, clazz, nameAndType);
    }

    public MethodrefEntry(List<ConstantPoolEntry> constantPool, ClassEntry clazz, String name, String descriptor) {
        super(constantPool, ConstantPoolTag.METHODREF, clazz, name, descriptor);
    }

    public MethodrefEntry(List<ConstantPoolEntry> constantPool, String clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, ConstantPoolTag.METHODREF, clazz, nameAndType);
    }

    public MethodrefEntry(List<ConstantPoolEntry> constantPool, String clazz, String name, String descriptor) {
        super(constantPool, ConstantPoolTag.METHODREF, clazz, name, descriptor);
    }
}
