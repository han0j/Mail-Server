#!/bin/bash

rm */*.class */*/*.class */*/*/*.class;
javac */*.java */*/*.java */*/*/*.java;
java Main/Server $1 $2;
