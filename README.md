# JVM Bytecode Reassembler
This project aims to allow you to directly write Java Virtual Machine (JVM) bytecode into class files.

### Usage
Once you have compiled the project, run the jar with `java -jar ASMRecompiler.jar <filename>`. You can run the program with the argument `--help` to get advanced command-line usage.

### Features
This project uses the [jcpp](https://github.com/shevek/jcpp) C preprocessor implementation to preprocess each file before reassembling it.

### Syntax
The recommended file extension is `.jvmasm`. The syntax is very similar to the output of `javap -v`. See the [testfiles](./testfiles) directory for examples, and see [the grammar](./src/main/java/com/raptor/asmrecomp/ASMParser.g4) for the full syntax.

A simple example:
```java
public class test.Test {
    public test.Test();
      Code:
        aload_0         // this
        invokespecial   java.lang.Object.<init>: () void
        return

    /**
     * Prints "Hello, world!" to the console.
     */
    public static void sayHello();
      Code:
        getstatic       java.lang.System.out: java.io.PrintStream
        ldc             "Hello, world!"
        invokevirtual   java.io.PrintStream.println: (java.lang.String) void
        return
}
```

In Java, the source file would look like this:
```java
package test;
public class Test {
    /**
     * Prints "Hello, world!" to the console.
     */
    public static void sayHello() {
        System.out.println("Hello, world!");
    }
}
```

Declaring a constructor in disassembled code looks like this:
    
    [modifiers] <fully-qualified class name> ( [arguments] );
      Code :
        <bytecode>

#### Local Variables
The number of local variables and the max stack size is automatically computed by ObjectWeb's ASM library, so you don't need to worry about that.

Each function declaration actually has two syntax modes for local variables: the *unnamed* mode and the *named* mode.

The *unnamed* mode is when you don't use variable names. If you declare a parameter without giving it a name, or use any variable instruction with an index instead of a name, then you enter *unnamed* mode.

The *named* mode allows you to not worry about explicitly specify local variable indices. Wherever a bytecode instruction would expect a local variable index, just give it a name. The indices will be assigned automatically.

The instructions whose syntaxes are affected by this mode are: `aload`, `astore`, `iload`, `istore`, `lload`, `lstore`, `fload`, `fstore`, `dload`, `dstore`, `iinc`, and `ret`.

In *unnamed* mode, you must do things like `aload_0`, `fstore_2`, `dload 7`. Note that `aload_0` and `aload 0` (note the underscore) achieve the same thing, but `aload_0` is a keyword.
You must declare parameters like `(final java.lang.String[], int, float[])`.

If you use variable indices 0, 1, and 3 (for example) but don't ever use index 2, the behaviour is undefined.

In *named* mode, you must do things like `aload this` (only in non-static methods), `fstore f1`, `dload tempvalue`. The `aload_0` and similar instructions are prohibited in this mode.
You must declare parameters like `(final java.lang.String[] strs, int x, float[] floats)`.

You *cannot* mix modes within the same function declaration, but you *can* mix them within the same class file.

#### Labels
Since there are no instruction offset indices like in the output of `javap -v`, you can specify the target of jump and branch instructions by declaring *labels*. A label is declared by doing `name :` before an instruction, just like in regular assembly and also Java source code. Note that you cannot use an instruction keyword as a label name, nor can the label name be `Code`.

Example:
```java
int greater(int x, int y);
  Code:
    iload       x
    iload       y
    if_icmplt   else_0
    iload       x
    ireturn
  else_0:
    iload       y
    ireturn
```

#### Types
All types are written **not** by their JVM internal names, but by how their fully-qualified names would appear in a Java source file. This includes type parameters and arguments.

For example, the `javap` output of the return type of a method returning a `List<String>[]` would actually be in two separate places: the actual erased type and the signature. The erased type would be output as `[Ljava/util/List;` and the type signature would be output as `[Ljava/util/List<Ljava/lang/String;>;`. In *this* project, however, you can write it like `java.util.List<java.lang.String>[]`.

#### Some things to note:
- The JVM actually allows you to declare multiple fields with the same name but different types, and also multiple methods with different return types. It doesn't care because the `invoke` instructions always include the expected return type.
- The JVM also does not require non-abstract class files to have a constructor.
- If you *do* declare a constructor, you *must* call the super constructor. However, you do *not* need to call it immediately like in Java.
- Inner classes are not supported yet.
- Annotations are not supported yet.
- Enums are not supported yet.
- Records are not supported yet.
- Class initializers are not supported yet.
- Annotations are not supported yet.
- Line number attributes and source file attributes *will not* be supported.
- Other attributes are not supported yet.

### References
- [The JVM Instruction Set](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-6.html)
- [ObjectWeb ASM](https://asm.ow2.io/)
- [ANTLR 4 Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
- ~~[ANTLR Indentation-aware Helper](https://github.com/yshavit/antlr-denter)~~ (Unused code in [com.raptor.antlr.denterhelper](./src/main/java/com/raptor/antlr/denterhelper) was copied from this) (Didn't end up using it)