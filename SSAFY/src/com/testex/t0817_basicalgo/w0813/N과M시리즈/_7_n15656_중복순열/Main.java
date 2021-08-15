package com.testex.t0817_basicalgo.w0813.N과M시리즈._7_n15656_중복순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복순열
public class Main {

	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] numbers;
	private static boolean [] selected;
	private static StringBuilder sb = new StringBuilder();
	
	private static void dupPermutation(int cnt) {
		if(M == cnt) {
			for(int i : numbers) sb.append(i+" ");
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			numbers[cnt] = arr[i];
			dupPermutation(cnt+1);
		}
	}

		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int [N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		numbers = new int[M];
		selected = new boolean[N];
		
		dupPermutation(0);
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}
