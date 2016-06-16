package org.iit.cs553;

import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Program to sort data o Hadoop cluster.
 * 
 * @author Aishwarya Anand (A20331867)
 * @mail aanand12@hawk.iit.edu
 * 
 */
public class HadoopTeraSort {

	/**
	 * Logger for logging on console
	 */
	private final static Logger LOGGER = Logger.getLogger(HadoopTeraSort.class.getName());

	/**
	 * Main method of class that to do all driver configuration for hadoop
	 * 
	 * @param args
	 *            - input directory , output directory
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		LOGGER.info("Starting Hadoop Application");
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Hadoop TeraSort");
		Long progStartTime = System.currentTimeMillis();
		job.setInputFormatClass(KeyValueTextInputFormat.class);
		job.setJarByClass(HadoopTeraSort.class);
		job.setMapperClass(HadoopTeraSortMapper.class);
		job.setCombinerClass(HadoopTeraSortReducer.class);
		job.setReducerClass(HadoopTeraSortReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean status = job.waitForCompletion(true);
		LOGGER.info("*****Total Time : " + (System.currentTimeMillis() - progStartTime));
	}

}
