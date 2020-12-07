JAVADIR = 'C:/Program Files/Java/jdk-14.0.1/bin'
JAVAC = $(JAVADIR)/javac.exe --enable-preview --source=14
JAVAP = $(JAVADIR)/javap.exe -c -p -v

tests = $(foreach path,$(wildcard com/raptor/test*),$(subst com/raptor/,,$(path)))

err:
	@echo 'Please specify targets explicitly.'
	@false

compile%:
	$(JAVAC) com/raptor/$(subst compile,test,$@)/*.java

asm%:
	for file in com/raptor/$(subst asm,test,$@)/*.class; do \
		$(JAVAP) $$file > $$file.disasm.txt; \
		rm -f $$file; \
	done

$(tests): test%: compile% asm%

clean:
	find -iname *.class* -delete

clean%:
	find com/raptor/$(subst clean,test,$@)/ -iname *.class* -delete

update:
	./UpdateMakefile.py
