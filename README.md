# Imvision

Folders :
- Diagrams : UML class diagram , seqence diagram, use case diagram .
- src : source code 
- src\ Tests : tests

Main.java:
- Set the 'N' value 
- Craete math function using 'Expression' interface (Please see the full hierarchy in 'Diagrams/UML').
- For exmaple :  the math function "n/2 + n^2" as "new Plus(new Div(new Var("n"),new Num(2)), new Pow(new Var("n"),new Num(2)))"
	
Executor.java:
- Class for parallel calculation of the math function from 0 until N - value
