In this part, you are required to use genetic programming to evolve a mathematical function (which is an individual program in the population) for a simple symbolic regression task. In real world applications, a
test set of data is needed in many situations but not needed in other scenarios, depending on the nature of the problems to be solved. In this assignment, to make the question simple, it is not required to have a test
set | you are just required to evolve a mathematical function to reveal the relationship between the output variable and the input variable(s) from a (training) set of instances.

## Problem Description
The task involves mapping a single input variable x to the (single) output variable y. In a 2D (two-dimensional) space (x-y coordinates), there are 20 points (x-y pairs). The task is to nd a mathematical
function to describe the relationship between the output variable y and input variable x. The 20 points are as follows. They are also saved in the le regression.txt in plain text format.

```
x -2.0 -1.75 -1.50 -1.25 -1.00 -0.75 -0.50 -0.25 0.00 0.25
y 37.0000 24.1602 15.0625 8.9102 5.0000 2.7227 1.5625 1.0977 1.0000 1.0352
x 0.50 0.75 1.00 1.25 1.50 1.75 2.00 2.25 2.50 2.75
y 1.0625 1.0352 1.0000 1.0977 1.5625 2.7227 5.0000 8.9102 15.0625 24.1602
```

## Requirements
It is very time consuming to write your own GP package from the beginning. As many GP packages are available, this is actually not necessary. In this assignment, we receommend three GP packages for the GP
questions. They are JGAP (a Java GP library), RMITGP (written in C++, fully documented), GPC++ (written in C++, fully documented). Again, you can choose other GP packages such as VGP (Developed by
VUW, in C/C++), ECJ (in Java). Please describe your choice in your report.

Your job is to use any of the genetic programming packages with necessary changes of the terminal set, function set, fitness function, parameters and termination criteria to solve the task described above.

## Prerequisite
- Make sure /ecj folder and ec.params, koza.params, regression.txt, simple.params, tutorial4.params and ecj.jar files are in the same directory.

Running steps:
1. Open Terminal console
2. Go to the project /part2 directory
3. Run command:
```
  java -jar ecj.jar -classpath "." ec.Evolve -file tutorial4.params -p stat.file=out.stat
```
4. Check out.stat for output details in the same folder
