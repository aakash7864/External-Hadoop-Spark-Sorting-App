SparkApp is a java program that uses Spark Java API to sort data generated 
by gensort considering first 10 bytes of line as key and remaining as key.

As source code and library need for the source code are present in folder we can easily create a jar file.
I am also submiting runnable jar file for same.

Program is created in Eclipse IDE.So one way to compile it is to open in eclispe and export as runnable Jarfile 
Another way is to use any IDE for java and use my code and library export it as runnable jar file 

How to run jar file is created 

simply we need to go to spark directory 

Running Spark code:
First parameter to jar file is inputfile and second parameter is output directory
root@ip-172-31-18-128 ~]$ ./spark/bin/spark-submit --num-executors 5 SparkApp1.jar /input/input.txt /vol0/