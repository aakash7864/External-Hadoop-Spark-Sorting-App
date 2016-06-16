package org.iit.cs553;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Mapper class for Hadoop sort application cluster.
 * 
 * @author Aishwarya Anand (A20331867)
 * @mail aanand12@hawk.iit.edu
 * 
 */
public class HadoopTeraSortMapper extends Mapper<Text, Text, Text, Text> {
	@SuppressWarnings("unchecked")
	@Override
	protected void map(Text key, Text value, org.apache.hadoop.mapreduce.Mapper.Context context) throws IOException, InterruptedException {

		context.write(key, value);
	}
}