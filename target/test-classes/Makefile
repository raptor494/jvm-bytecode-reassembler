JAVADIR = 'C:/Program Files/Java/jdk-14.0.1/bin'
JAVAC = $(JAVADIR)/javac.exe --enable-preview --source=14
JAVAP = $(JAVADIR)/javap.exe -c -p -v

all: compile asm

compile: compile01 compile02 compile03 compile04

asm: asm01 asm02 asm03 asm04

compile01:
	$(JAVAC) com/raptor/test01/*.java

compile02:
	$(JAVAC) com/raptor/test02/*.java

compile03:
	$(JAVAC) com/raptor/test03/*.java

compile04:
	$(JAVAC) com/raptor/test04/*.java

asm01:
	for file in com/raptor/test01/*.class; do \
		$(JAVAP) $$file > $$file.disasm.txt; \
		rm -f $$file; \
	done

asm02:
	for file in com/raptor/test02/*.class; do \
		$(JAVAP) $$file > $$file.disasm.txt; \
		rm -f $$file; \
	done

asm03:
	for file in com/raptor/test03/*.class; do \
		$(JAVAP) $$file > $$file.disasm.txt; \
		rm -f $$file; \
	done

asm04:
	for file in com/raptor/test04/*.class; do \
		$(JAVAP) $$file > $$file.disasm.txt; \
		rm -f $$file; \
	done

test01: compile01 asm01

test02: compile02 asm02

test03: compile03 asm03

test04: compile04 asm04

clean:
	find -iname *.class* -delete

clean01:
	find com/raptor/test01/ -iname *.class* -delete

clean02:
	find com/raptor/test02/ -iname *.class* -delete

clean03:
	find com/raptor/test03/ -iname *.class* -delete

clean04:
	find com/raptor/test04/ -iname *.class* -delete

update:
	./UpdateMakefile.py
