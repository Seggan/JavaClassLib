package io.github.seggan.javaclasslib.tests;

import io.github.seggan.javaclasslib.ClassAccessFlags;
import io.github.seggan.javaclasslib.JavaClass;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        JavaClass javaClass = new JavaClass("Testy", "java.lang.Object", 16);
        javaClass.setClassAccessFlags(ClassAccessFlags.PUBLIC, ClassAccessFlags.FINAL);
        try (FileOutputStream outputStream = new FileOutputStream("Testy.class")) {
            javaClass.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
