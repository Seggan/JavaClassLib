package io.github.seggan.javaclasslib.constantpool.classmembers;

import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolTag;
import io.github.seggan.javaclasslib.constantpool.NameAndTypeEntry;

import java.util.List;

public final class FieldrefEntry extends ClassMemberEntry {

    public FieldrefEntry(List<ConstantPoolEntry> constantPool, ClassEntry clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, ConstantPoolTag.FIELDREF, clazz, nameAndType);
    }

    public FieldrefEntry(List<ConstantPoolEntry> constantPool, ClassEntry clazz, String name, String descriptor) {
        super(constantPool, ConstantPoolTag.FIELDREF, clazz, name, descriptor);
    }

    public FieldrefEntry(List<ConstantPoolEntry> constantPool, String clazz, NameAndTypeEntry nameAndType) {
        super(constantPool, ConstantPoolTag.FIELDREF, clazz, nameAndType);
    }

    public FieldrefEntry(List<ConstantPoolEntry> constantPool, String clazz, String name, String descriptor) {
        super(constantPool, ConstantPoolTag.FIELDREF, clazz, name, descriptor);
    }
}
