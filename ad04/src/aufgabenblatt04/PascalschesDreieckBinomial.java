/**
 * 
 */
package aufgabenblatt04;

/**
 *
 */
public class PascalschesDreieckBinomial{

	public long zaehler = 0;
	
	public long[] getZeile(int n) {
		
		long[] zeile = new long[n+1];

		for(int k=0; k <= n; k++ ){
			
			zaehler++;
			
			zeile[k] = (long) (fakultaet( n ) / ( fakultaet( k ) * fakultaet( n - k )));
			
		}
		return zeile;
	}
	
	private double fakultaet( int n ) {
		double fakul = 1;
        for(int i = 2; i <= n; i++){
        	zaehler++;
        	fakul *= i;               
        }
        return fakul;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("PascalschesDreieckBinomial");
		for (int N = 1; N <= 100000; N*=10) {
			PascalschesDreieckBinomial bino = new PascalschesDreieckBinomial();
			long[] zeile = bino.getZeile(N);
			
			System.out.println("\n\nZeile: " + N + "\nAufwand: " + bino.zaehler);
//			for(int i = 0; i < zeile.length; i++)
//			{
//				System.out.print(zeile[i]+", ");
//			}
		}
		
	} 
}
