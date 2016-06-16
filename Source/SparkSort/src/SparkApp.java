import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

/**
 * Class to sort data on Spark Cluster.
 * 
 * @author Aishwarya Anand (A20331867)
 * @mail aanand12@hawk.iit.edu
 * 
 */
public class SparkApp {

	/**
	 * Starting point of program
	 * 
	 * @param args0
	 *            - input file location on HDFS
	 * @param args1
	 *            - output folder location to store file on HDFS
	 * 
	 */
	public static void main(String[] args) {
		Long fileReadTime;
		Long sortTime;
		@SuppressWarnings("resource")
		JavaSparkContext sc = new JavaSparkContext("local[*]", "Sorting App");
		Long progStartTime = System.currentTimeMillis();
		JavaRDD<String> lines = sc.textFile(args[0]);

		fileReadTime = System.currentTimeMillis() - progStartTime;
		Long sortStartTime = System.currentTimeMillis();
		JavaPairRDD<String, String> sortedOutput = lines.mapToPair(new KeyPairSeperator()).sortByKey(true);
		sortedOutput.flatMap(new FlatMapFunction<Tuple2<String, String>, String>() {

			private static final long serialVersionUID = -7248241893219206222L;

			public Iterable<String> call(Tuple2<String, String> t) throws Exception {
				List<String> returnValues = new ArrayList<String>();
				returnValues.add(t._1() + "  " + t._2().trim() + "\t");
				return returnValues;
			}
		}).saveAsTextFile(args[1]);
		sortTime = System.currentTimeMillis() - sortStartTime;
		System.out.println("File Load Time \t" + fileReadTime + " File Sort Time \t" + sortTime);
	}

	/**
	 * Class to separate line into key and apir
	 * 
	 */
	private static class KeyPairSeperator implements PairFunction<String, String, String> {

		private static final long serialVersionUID = 1L;

		public Tuple2<String, String> call(String s) {
			String key = s.substring(0, 10);
			String value = s.substring(10);
			return new Tuple2<String, String>(key, value);
		}
	}
}
