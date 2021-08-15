package com.testex.t0817_basicalgo.w0813.N과M시리즈._8_n15657_중복조합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복 조합
public class Main {
	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] store;
	private static StringBuilder sb = new StringBuilder();
	
	private static void dupCombination(int cnt, int start) {
		if(cnt==M) {
			for(int i : store) {
				sb.append(i+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=start; i<N; i++) {
			
			store[cnt] = arr[i];
			dupCombination(cnt+1, i);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		store = new int [M];
		dupCombination(0, 0);
	
		bw.append(sb);
		bw.flush();
		bw.close();
	}

}
