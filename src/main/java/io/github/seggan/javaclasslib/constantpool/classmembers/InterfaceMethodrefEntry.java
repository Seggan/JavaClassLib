package io.github.seggan.javaclasslib.constantpool.classmembers;

import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.constantpool.NameAndTypeEntry;

import java.util.List;

public final class InterfaceMethodrefEntry extends ClassMemberEntry {

    public InterfaceMethodrefEntry(List<ConstantPoolEntry> constantPool, ClassEntry clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, ConstantPoolTag.INTERFACE_METHODREF, clazz, nameAndType);
    }
}
