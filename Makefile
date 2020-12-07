JAVA = "$$JAVA_HOME/bin/java.exe" --enable-preview

PROGRAM = $(JAVA) -jar $$(realpath --relative-to=$$(pwd) ~0/target/asm-recompiler*.jar)

testfiles%:
	$(PROGRAM) --debug testfiles/$(subst testfiles,Test,$@).jvmasm