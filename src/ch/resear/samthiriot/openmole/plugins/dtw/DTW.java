package ch.resear.samthiriot.openmole.plugins.dtw;

import com.dtw.FastDTW;
import com.timeseries.TimeSeries;
import com.util.DistanceFunction;
import com.util.DistanceFunctionFactory;

/**
 * What will be published in OpenMOLE 
 * 
 * @author Samuel Thiriot
 *
 */
public class DTW {

	
	public static double getWarpDistBetween(double[] a, double[] b) {
		
		final TimeSeries ta = new TimeSeries(a);
		final TimeSeries tb = new TimeSeries(b);
		final DistanceFunction df = DistanceFunctionFactory.EUCLIDEAN_DIST_FN;
		
		return com.dtw.DTW.getWarpDistBetween(ta, tb, df);
		
	}
	
	public static double getFastWarpDistBetween(double[] a, double[] b) {
		
		final TimeSeries ta = new TimeSeries(a);
		final TimeSeries tb = new TimeSeries(b);
		final DistanceFunction df = DistanceFunctionFactory.EUCLIDEAN_DIST_FN;
		
		return FastDTW.getWarpDistBetween(ta, tb, df);
		
	}
	
	public static double getSum(double[] a) {
		
		double total = 0;
		for (int i=0; i<a.length; i++) {
			total += a[i];
		}
		return total;
	}
	

	public static double[] getNormalized(double[] a) {
		
		double sum = getSum(a);
		double[] res = a.clone();
		
		for (int i=0; i<a.length; i++)
			res[i] = a[i]/sum;
		
		return res;
	}
	
	
	public static double getMSEBetweenNormalized(double[] a, double[] b) {

		double[] a_norm = getNormalized(a);
		double[] b_norm = getNormalized(b);
		
		return getMSE(a_norm, b_norm);
		
	}
		
	
	public static double getMSE(double[] a, double[] b) {

		if (a.length != b.length)
			throw new RuntimeException(
					"in order to compute MSE, your series should have the same length, "
					+ "but we found "+a.length+" and "+b.length);
		
		double total = 0;
		
		for (int i=0; i<a.length; i++) {
			total += Math.pow( a[i] - b[i], 2 );
		}
		
		return total / a.length;
		
	}
	
	public static double getRMSE(double[] a, double[] b) {
		
		return Math.sqrt(getMSE(a,b));
		
	}
	
	
	public static double getMAE(double[] a, double[] b) {

		if (a.length != b.length)
			throw new RuntimeException(
					"in order to compute MAE, your series should have the same length, "
					+ "but we found "+a.length+" and "+b.length);
		
		double total = 0;
		
		for (int i=0; i<a.length; i++) {
			total += Math.abs( a[i] - b[i] );
		}
		
		return total / a.length;
		
	}
	
	
}
