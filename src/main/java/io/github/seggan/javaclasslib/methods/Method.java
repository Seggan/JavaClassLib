package io.github.seggan.javaclasslib.methods;

import com.google.common.primitives.Bytes;
import io.github.seggan.javaclasslib.ByteUtils;
import io.github.seggan.javaclasslib.attributes.Attribute;
import io.github.seggan.javaclasslib.constantpool.ConstantPoolEntry;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;

import javax.annotation.Nonnull;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class Method {

    private final UTF8Entry name;
    private final UTF8Entry descriptor;
    private final List<Attribute> attributes = new ArrayList<>();

    private MethodAccessFlags[] accessFlags = new MethodAccessFlags[0];

    public Method(UTF8Entry name, UTF8Entry descriptor) {
        this.name = name;
        this.descriptor = descriptor;
    }

    public Method(List<ConstantPoolEntry> constantPool, String name, String descriptor) {
        this(new UTF8Entry(constantPool, name), new UTF8Entry(constantPool, descriptor));
    }

    @Nonnull
    public byte[] getBytes() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (Attribute attribute : attributes) {
            for (byte b : attribute.getBytes()) {
                outputStream.write(b);
            }
        }

        return Bytes.concat(ByteUtils.twoBytesFromInt(MethodAccessFlags.combine(accessFlags)), name.getIndexBytes(),
            descriptor.getIndexBytes(), ByteUtils.twoBytesFromInt(attributes.size()), outputStream.toByteArray());
    }

    public UTF8Entry getName() {
        return name;
    }

    public UTF8Entry getDescriptor() {
        return descriptor;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public MethodAccessFlags[] getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(MethodAccessFlags... accessFlags) {
        this.accessFlags = accessFlags;
    }
}
