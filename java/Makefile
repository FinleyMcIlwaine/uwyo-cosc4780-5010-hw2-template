## Makefile for UWYO COSC 4780/5010 HW2 - Java side
## Author: Finley McIlwaine

.PHONY : bnfc build parse compile

bnfc/r_exp/*.java: RExp.cf
	bnfc --java --makefile=bnfc.mk -p bnfc $^
	make -f bnfc.mk

*.class: *.java bnfc/r_exp/*.java
	javac $^

bnfc: bnfc/r_exp/*.java

build: *.class

parse: build bnfc
	@java bnfc.r_exp.Test

compile: bnfc build
	@java Main

compileDfa: bnfc
	@java Main -x
