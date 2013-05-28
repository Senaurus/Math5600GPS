/**
 * Author: 	Arthur V. Stefanishin
 * Date :	2013/05/28
 */

import java.lang.Math;

public class ConvertAngle {

	/**
	 * Converts angle from degrees to radians and other way around.
	 * Usage: ConvertAngle [ConvertingFrom] [Value 1] [Value 2] [Value 3]
	 * [ConvertFrom] - use "r" for converting from radians and "d" if from degrees
	 * [Value 1] - (required) value of angle in radians or degree component 
	 * 			   (if converting from degrees has to be integer)
	 * [Value 2] - required if converting from degrees and represents minutes (has to be integer)
	 * [Value 3] - requited if converting from degrees and represents seconds
	 * @param args
	 */
	public static void main(String[] args) {
		double[] degrees = {57,17,45};
		
		try{
			if ("d".equals(args[0]) || "D".equals(args[0]) ){
				degrees[0] = Integer.parseInt(args[1]);
				degrees[1] = Integer.parseInt(args[2]);
				degrees[2] = Double.parseDouble(args[3]);
				System.out.println(DegreesToRadians(degrees));				
			}
			else if ("r".equals(args[0])  || "R".equals(args[0]) ){
				degrees = RadiansToDegrees(Double.parseDouble(args[1]));
				System.out.println((int)degrees[0] + " " + (int)degrees[1] + " " + degrees[2]);
			}
			else {
				System.out.println("First parameter is invalid.\n" + 
								   "Should be \"d\" if converting from degrees or \"r\" if from radians.");
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("Not enough arguments provided.");
			e.printStackTrace();
		}
		catch(java.lang.NumberFormatException e){
			System.out.println("Non-integer value provided where integer value is expected.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Converts angle provided in the form of an array that contains degrees, minutes, 
	 * seconds as 3 elements to radians
	 * @param degree - an array containing degree, minutes and seconds of the angle	
	 * @return angle value in radians
	 */
	public static double DegreesToRadians(double [] degrees)
	{
		double degreesCombined = degrees[0] + degrees[1] / 60 + degrees[2] / 3600;
		return degreesCombined * Math.PI / 180;
	}
	
	/**
	 * Converts angle from radians to degrees
	 * @param radians - value of an angle in radians
	 * @return - array with 3 elements in format {degrees, minutes, seconds}
	 */
	public static double[] RadiansToDegrees(double radians) {
		double[] degrees = {0, 0, 0};
		double nonComponentDegrees = radians * 180 / Math.PI;
		degrees[0] = Math.floor(nonComponentDegrees);
		degrees[1] = Math.floor((nonComponentDegrees - degrees[0]) * 60);
		degrees[2] = (nonComponentDegrees - degrees[0] - degrees[1] / 60) * 3600;
		return degrees;
	}
	

	}