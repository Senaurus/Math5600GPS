import java.lang.Math;

public class VectorMagnitude {

	/**
	 * Calculates magnitude of a vector.
	 * Usage: ConvertAngle [Vector size] [x1] [x2] ...
	 * [Vector size] - Number of elements in the vector provided
	 * [x1] [x2] ... - elements of the vector separated by white space.
	 * @param args
	 */
	public static void main(String[] args) {
		double sum = 0.0;
		double x = 0.0;
		
		try {
			int n = Integer.parseInt(args[0]);
			
			for (int i = 1; i <= n; i++) {				
				if (i >= args.length)
					throw new java.lang.ArrayIndexOutOfBoundsException();
				else
					x = Double.parseDouble(args[i]);
				if (x != 0)
					if (x != 1)
						sum +=  x*x;
					else
						sum += 1;				
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("Not enough arguments provided.");
			e.printStackTrace();
		}
		catch(java.lang.NumberFormatException e){
			System.out.println("Non-numeric value provided where numeric value is expected.");
			e.printStackTrace();
		}
		System.out.println(Math.sqrt(sum));	
	}
}