package org.iit.cs553;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Reducer class for Hadoop sort application cluster.
 * 
 * @author Aishwarya Anand (A20331867)
 * @mail aanand12@hawk.iit.edu
 * 
 */
public class HadoopTeraSortReducer extends Reducer<Text, Text, Text, Text> {

	@SuppressWarnings("unchecked")
	protected void reduce(Text fromMapperKey, Iterable<Text> fromReducerValue, org.apache.hadoop.mapreduce.Reducer.Context context) throws IOException,
			InterruptedException {

		context.write(fromMapperKey, fromReducerValue);
	}
}