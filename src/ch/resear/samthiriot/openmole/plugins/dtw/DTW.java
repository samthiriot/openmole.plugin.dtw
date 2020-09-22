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
	
}
