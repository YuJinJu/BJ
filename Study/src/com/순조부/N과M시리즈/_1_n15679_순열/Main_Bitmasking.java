package com.순조부.N과M시리즈._1_n15679_순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//순열 //비트마스크
public class Main_Bitmasking {
	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] number;
	private static boolean [] selected;
	private static StringBuilder sb = new StringBuilder();
	
	private static void dupPermut(int cnt, int flag) {
		if(cnt == M) {
			for(int i : number) sb.append(i+" ");
			sb.append("\n");
			
			return;
		}
		for(int i=0;i<N;i++) {
			if((flag & 1<<i) !=0) continue; 
			
			number[cnt] = arr[i];
			
			dupPermut(cnt+1, flag | 1<<i);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		number = new int[M];
		selected = new boolean[N];

		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		dupPermut(0,0);
		
		bw.append(sb);
		bw.flush();
		bw.close();
		
	}

}
