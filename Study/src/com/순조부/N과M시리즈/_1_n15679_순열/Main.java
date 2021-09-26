package com.순조부.N과M시리즈._1_n15679_순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//순열(중복허용X)
public class Main {

	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] numbers;
	private static boolean [] selected;
	static StringBuilder sb = new StringBuilder();
	
	private static void solution(int cnt) {
		if(cnt == M) {
			
			for(int i : numbers)
				sb.append( i +" ");
			
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i]) continue;
			
			numbers[cnt] = arr[i];
			selected[i] = true;
			
			solution(cnt+1);
			selected[i] = false;
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
		selected = new boolean[N];
		
		solution(0);
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}
