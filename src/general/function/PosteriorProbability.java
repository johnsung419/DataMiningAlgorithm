package general.function;


public class PosteriorProbability 
{
	public static PosteriorProbability instance;
	private PosteriorProbability() {}
	
	public static PosteriorProbability getInstance()
	{
		if(instance == null)
			instance = new PosteriorProbability();
		
		return instance;
	}
	
	//compute each posterior probability so that I can get the product of each
	public double computeProbability(String testValue, String average, String stdev)
	{
		double posterior = 0.0;
		double t_val = Double.parseDouble(testValue);
		double avg = Double.parseDouble(average);
		double stv = Double.parseDouble(stdev);

		posterior =  ( 1 / Math.sqrt( 2 * Math.PI * stv) ) * Math.exp( - Math.pow(( t_val - avg) , 2) / (2 * stv) );
		
		return posterior;
	}

	
}
