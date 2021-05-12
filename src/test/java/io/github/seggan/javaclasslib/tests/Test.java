package io.github.seggan.javaclasslib.tests;

import io.github.seggan.javaclasslib.ClassAccessFlags;
import io.github.seggan.javaclasslib.JavaClass;
import io.github.seggan.javaclasslib.attributes.code.CodeAttribute;
import io.github.seggan.javaclasslib.attributes.code.instructions.JvmInstructions;
import io.github.seggan.javaclasslib.constantpool.UTF8Entry;
import io.github.seggan.javaclasslib.methods.Method;
import io.github.seggan.javaclasslib.methods.MethodAccessFlags;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        JavaClass javaClass = new JavaClass("Testy", "java.lang.Object", 16);
        javaClass.setClassAccessFlags(ClassAccessFlags.PUBLIC, ClassAccessFlags.FINAL);

        Method main = new Method(new UTF8Entry(javaClass.getConstantPool(), "main"),
            new UTF8Entry(javaClass.getConstantPool(), "([Ljava/jang/String;)V"));
        main.setAccessFlags(MethodAccessFlags.PUBLIC, MethodAccessFlags.STATIC);

        CodeAttribute code = new CodeAttribute(new UTF8Entry(javaClass.getConstantPool(), "Code"),
            2, 2, Arrays.asList(
            JvmInstructions.ALOAD.create(0)
        ));

        main.getAttributes().add(code);

        javaClass.getMethods().add(main);

        try (FileOutputStream outputStream = new FileOutputStream("Testy.class")) {
            javaClass.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
