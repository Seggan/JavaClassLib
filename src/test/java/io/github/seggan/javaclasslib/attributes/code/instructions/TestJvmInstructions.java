package io.github.seggan.javaclasslib.attributes.code.instructions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class TestJvmInstructions {

    @Test
    @DisplayName("Checks for instruction bytes used in more than one instructions to prevent copy-paste errors")
    public void testNoDuplicates() throws IllegalAccessException {
        Set<Byte> found = new HashSet<>();

        for (Field field : JvmInstructions.class.getFields()) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                byte b = ((JvmInstruction) field.get(null)).getInstructionByte();
                if (found.contains(b)) {
                    throw new AssertionError(String.format("Duplicate instruction byte 0x%s of instruction %s",
                        Integer.toHexString(b),
                        field.getName()
                    ));
                } else {
                    found.add(b);
                }
            }
        }
    }
}
