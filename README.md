# JavaClassLib

This is a Java class file manipulation library that, unlike other bytecode libraries, directly deals with the constructs in the class file without any abstraction. It is still unfinished.

## Examples
A generic example can be found [here](https://github.com/Seggan/JavaClassLib/blob/master/src/test/java/io/github/seggan/javaclasslib/tests/Test.java).

##### Creating a class
This will create a basic class named `TheName` extending `some.super.Class` compiled with Java version 11. Note that java versions less than 8 are not supported and using one will throw an exception.
```java
JavaClass aClass = new JavaClass("TheName", "some.super.Class", 11);
aClass.setAccessFlags(ClassAccessFlags.PUBLIC);
```

##### Adding constant pool entries
Assuming we have the code from above, adding a constant pool entry is simple. For example, here we add a `UTF8_info` constant pool entry.
```java
UTF8Entry entry = new UTF8Entry(aClass.getConstantPool(), "Write whatever you want in here");
```
The entry will automatically add itself to the constant pool on creation.

##### Adding methods
Here comes the juicy part: methods. Adding a method is slightly more complex.
```java
Method m = new Method(new UTF8Entry(aClass.getConstantPool(), "youMethodName"), new UTF8Entry(aClass.getConstantPool(), "(some.Type;)V"));
m.setAccessFlags(MethodAccessFlags.PUBLIC);
aClass.getMethods().add(m);
```

##### Bytecode
Finally, bytecode! In Java, bytecode goes into a thing called a *code attribute*, which then goes into the method. Here's a sample:
```java
List<JvmInstructionImpl> instructions = Arrays.asList(
    JvmInstructions.ALOAD.create(0),
    JvmInstructions.DUP.create()
);
CodeAttribute code = new CodeAttribute(new UTF8Entry(aClass.getConstantPool(), "Code"), 5, 2, instructions);
m.getAttributes().add(code);
```
The code attribute has 4 arguments: a `UTF8Entry` pointing to the value `Code` (this is very important!), the max stack size, the max local variable size, and a list of bytecode instructions. In this case the instructions are `aload 0, dup`

##### Writing
What's the point of having a Java class if you can't write it? The `JavaClass` has a method `write(OutputStream out)` that writes the class in byte form. It can be used with a `FileOutputStream`, `ByteArrayOutputStream`, and all the other variants.

## Todo
- Add the rest of the bytecode instructions
- Add more attributes
- Add interface, field, and attribute capabilities to classes
- Add exception tables to the code attribute