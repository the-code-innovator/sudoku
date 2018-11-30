#!/bin/bash

# javadoc routines
# mvn javadoc:javadoc
# mvn javadoc:jar
mvn javadoc:aggregate
mvn javadoc:aggregate-jar
# mvn javadoc:test-javadoc
# mvn javadoc:test-jar
# mvn javadoc:test-aggregate
# mvn javadoc:test-aggregate-jar
