package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj25206 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output= new StringBuilder();
	private static StringTokenizer tokens;
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double grade=0;
		double total=0;
		for(int i=0; i<20; i++) {
			tokens = new StringTokenizer(input.readLine());
			//과목이름
			String a = tokens.nextToken();
			//학점
			double b = Double.parseDouble(tokens.nextToken());
			//성적
			String c = tokens.nextToken();
			
			if(!c.equals("P")) {
				grade+=b;
			}
			
			if(c.equals("A+")) {
				total += b*4.5;
			}
			else if(c.equals("A0")) {
				total += b*4.0;
			}
			else if(c.equals("B+")) {
				total += b*3.5;
			}
			else if(c.equals("B0")) {
				total += b*3.0;
			}
			else if(c.equals("C+")) {
				total += b*2.5;
			}
			else if(c.equals("C0")) {
				total += b*2.0;
			}
			else if(c.equals("D+")) {
				total += b*1.5;
			}
			else if(c.equals("D0")) {
				total += b*1.0;
			}
		}
		System.out.printf("%.6f",total/grade);
		
	}

}
