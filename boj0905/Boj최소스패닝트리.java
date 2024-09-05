package boj0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//49484kb
//620ms

public class Boj최소스패닝트리 {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int v,e;
	static int parents[];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		v = Integer.parseInt(tokens.nextToken());
		e = Integer.parseInt(tokens.nextToken());
		parents = new int[v+1];
		for(int i=1; i<=v; i++){
			parents[i] = i;
		}
		Edge edge[] = new Edge[e];
		for(int i=0; i<e; i++){
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			edge[i] = new Edge(a,b,c);
		}
		Arrays.sort(edge);
		int sum=0;
		for(Edge e : edge){
			if(union(e.start,e.end)){
				sum +=e.weight;
			}
		}
		System.out.print(sum);
	}
	private static int findSet(int x){
		if(parents[x] == x) return x;
		return parents[x] = findSet(parents[x]);
	}
	private static boolean union(int a, int b){
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB){
			return false;
		}
		if(parents[rootA] < parents[rootB]){
			parents[rootB] = rootA;
		}
		else{
			parents[rootA] = rootB;
		}
		return true;
	}
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
