Program to sort data set having for larger size than memory. Program takes
input file generated from gensort and consider first 10bytes as key and
remaining 90 bytes as value. Program uses producer - consumer approach to
read and write sorted data files into chunks based on number of lines.
Program uses K-way Merge Sort algorithm with the help of priority queue to
merge sorted file chunks to a new File Chunks having all file records in
sorted order.
 
ThreadedSharedMemSort is a single class. So no need to create jar file for this.
Compilation: All we need to do is write to have JDK on machine and compile with below command

javac ThreadedSharedMemSort.java

For Running We need to pass differnt parameter to the main function of class
@param args0 - inputfile - File to sort
@param args1 - output folder - Directory to store sorted file chunks and produce output as output.txt
@param args2- total number of records present in input file
@param args3- Number of lines from where file will be splited
@param args4- Number of Threads to run as consumer
@param args5- Max size of queue for producer - consumer
@param args6- Time for thread to sleep if queue is full in ms 

Example :: 	 
java ThreadedSharedMemSort /root/input.txt /root/outputdir 1024000000 1024000 10 15 4000 