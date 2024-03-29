package io.github.seggan.javaclasslib;

import io.github.seggan.javaclasslib.attributes.Attribute;
import io.github.seggan.javaclasslib.constantpool.ClassEntry;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.methods.Method;
import io.github.seggan.javaclasslib.util.ByteUtils;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public final class JavaClass {

    private static final byte[] START_BYTES = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE, 0, 0};

    private final List<ConstantPoolEntry> constantPool = new LinkedList<>();

    private final ClassEntry thisClass;
    private final ClassEntry superClass;
    private final int classVersion;
    private final List<Method> methods = new LinkedList<>();
    private final List<Attribute> attributes = new LinkedList<>();
    private ClassAccessFlags[] classAccessFlags = new ClassAccessFlags[0];

    public JavaClass(@Nonnull String name, @Nonnull String superclass, int javaVersion) {
        if (javaVersion < 8) throw new IllegalArgumentException();
        classVersion = javaVersion + 44;
        this.thisClass = new ClassEntry(constantPool, name);
        this.superClass = new ClassEntry(constantPool, superclass);
    }

    public void write(@Nonnull OutputStream out) throws IOException {
        out.write(START_BYTES);
        out.write(ByteUtils.twoBytesFromInt(classVersion));
        out.write(ByteUtils.twoBytesFromInt(constantPool.size() + 1));
        for (ConstantPoolEntry entry : constantPool) {
            out.write(entry.getBytes());
        }
        out.write(ByteUtils.twoBytesFromInt(ClassAccessFlags.combine(classAccessFlags)));
        out.write(thisClass.getIndexBytes());
        out.write(superClass.getIndexBytes());
        out.write(new byte[]{0, 0, 0, 0});
        out.write(ByteUtils.twoBytesFromInt(methods.size()));
        for (Method method : methods) {
            out.write(method.getBytes());
        }
        out.write(ByteUtils.twoBytesFromInt(attributes.size()));
        for (Attribute attribute : attributes) {
            out.write(attribute.getBytes());
        }
    }

    public List<ConstantPoolEntry> getConstantPool() {
        return constantPool;
    }

    public ClassEntry getThisClass() {
        return thisClass;
    }

    public ClassEntry getSuperClass() {
        return superClass;
    }

    public int getClassVersion() {
        return classVersion;
    }

    public ClassAccessFlags[] getClassAccessFlags() {
        return classAccessFlags;
    }

    public void setClassAccessFlags(ClassAccessFlags... classAccessFlags) {
        this.classAccessFlags = classAccessFlags;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }
}
