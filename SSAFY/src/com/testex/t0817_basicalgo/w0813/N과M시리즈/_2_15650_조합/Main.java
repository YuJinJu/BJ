package com.testex.t0817_basicalgo.w0813.N과M시리즈._2_15650_조합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//조합 (중복X)
public class Main {

	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] numbers;
	private static StringBuilder sb = new StringBuilder();
	
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i : numbers)
				sb.append(i+" ");
			
			sb.append("\n");
			
			return;
		}
		
		for(int i= start; i<N; i++) {
			numbers[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N];
		for(int i=1;i<=N;i++) arr[i-1] = i;
		
		numbers = new int[M];
		combination(0, 0);
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}
