#!python
from glob import iglob as glob
import os, os.path as path

os.chdir(path.dirname(path.abspath(__file__)))

numbers = tuple("0123456789")

tests = set()
for filename in glob(R'com\raptor\test??'):
    if not path.isdir(filename): continue
    basename = path.basename(filename)
    if len(basename) != 6: continue
    if basename[-1] not in numbers or basename[-2] not in numbers: continue
    tests.add(basename[-2:])

tests = list(sorted(tests))

result = f"""\
JAVADIR = 'C:/Program Files/Java/jdk-14.0.1/bin'
JAVAC = $(JAVADIR)/javac.exe --enable-preview --source=14
JAVAP = $(JAVADIR)/javap.exe -c -p -v

all: compile asm

compile: {' '.join('compile'+n for n in tests)}

asm: {' '.join('asm'+n for n in tests)}
"""

for n in tests:
    result += f"""
compile{n}:
	$(JAVAC) com/raptor/test{n}/*.java
"""

for n in tests:
    result += f"""
asm{n}:
	for file in com/raptor/test{n}/*.class; do \\
		$(JAVAP) $$file > $$file.disasm.txt; \\
		rm -f $$file; \\
	done
"""

for n in tests:
    result += f"""
test{n}: compile{n} asm{n}
"""

result += """
clean:
	find -iname *.class* -delete
"""

for n in tests:
    result += f"""
clean{n}:
	find com/raptor/test{n}/ -iname *.class* -delete
"""

result += """
update:
	./UpdateMakefile.py
"""

with open('Makefile', 'w') as Makefile:
    Makefile.write(result)
print("Updated Makefile.")
