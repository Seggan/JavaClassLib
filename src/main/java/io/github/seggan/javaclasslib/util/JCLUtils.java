package io.github.seggan.javaclasslib.util;

import com.google.common.collect.ImmutableMap;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;
import java.util.regex.Pattern;

public class JCLUtils {

    private static final Map<Class<?>, Character> BASE_TYPES;
    private static final Pattern PERIOD = Pattern.compile("\\.");

    static {
        ImmutableMap.Builder<Class<?>, Character> builder = ImmutableMap.builder();
        builder.put(Boolean.class, 'Z');
        builder.put(Character.class, 'C');
        builder.put(Byte.class, 'B');
        builder.put(Short.class, 'S');
        builder.put(Integer.class, 'I');
        builder.put(Long.class, 'J');
        builder.put(Float.class, 'F');
        builder.put(Double.class, 'D');
        builder.put(Void.class, 'V');
        BASE_TYPES = builder.build();
    }

    private JCLUtils() {}

    /**
     * Creates a method signature from the parameter types and the return type
     * @param returnType the return type of the method
     * @param parameterTypes the parameter types, in order. None of them must be the class of {@link Void}
     * @return a string conforming to the <a href="https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.3.3">Java method signature format</a>
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public static String generateMethodSignature(Class<?> returnType, Class<?>... parameterTypes) {
        StringBuilder sb = new StringBuilder("(");
        for (Class<?> type : parameterTypes) {
            if (type.equals(Void.TYPE)) throw new IllegalArgumentException("Void cannot be used as a method parameter");

            Class<?> c = type;
            while (c.isArray()) {
                sb.append('[');
                c = c.getComponentType();
            }

            if (BASE_TYPES.containsKey(c)) {
                sb.append(BASE_TYPES.get(c));
            } else {
                sb.append('L');
                sb.append(PERIOD.matcher(c.getName()).replaceAll("/"));
                sb.append(';');
            }
        }

        sb.append(')');

        Class<?> c = returnType;
        while (c.isArray()) {
            sb.append('[');
            c = c.getComponentType();
        }

        if (BASE_TYPES.containsKey(c)) {
            sb.append(BASE_TYPES.get(c));
        } else {
            sb.append('L');
            sb.append(PERIOD.matcher(c.getName()).replaceAll("/"));
            sb.append(';');
        }

        return sb.toString();
    }
}
