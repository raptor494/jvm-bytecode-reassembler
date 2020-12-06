# JVM Bytecode Reassembler
This project aims to allow you to directly write Java Virtual Machine (JVM) bytecode into class files.

### Usage
Once you have compiled the project, run the jar with `java -jar ASMRecompiler.jar <filename>`. You can run the program with the argument `--help` to get advanced command-line usage.

### Features
This project uses the [jcpp](https://github.com/shevek/jcpp) C preprocessor implementation to preprocess each file before reassembling it.

### Syntax
The recommended file extension is `.jvmasm`. The syntax is very similar to the output of `javap -v`. See the [testfiles](./testfiles) directory for examples, and see [the grammar](./src/main/java/com/raptor/asmrecomp/ASMParser.g4) for the full syntax.

### References
- [The JVM Instruction Set](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-6.html)
- [ANTLR 4 Documentation](https://github.com/antlr/antlr4/blob/master/doc/index.md)
- ~~[ANTLR Indentation-aware Helper](https://github.com/yshavit/antlr-denter)~~ (Unused code in [com.raptor.antlr.denterhelper](./src/main/java/com/raptor/antlr/denterhelper) was copied from this) (Didn't end up using it)