package com.순조부.N과M시리즈._5_n15654_순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열
public class Main {
	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] numbers;
	private static boolean [] selected;
	private static StringBuilder sb = new StringBuilder();
	
	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i : numbers) sb.append(i+" ");
			sb.append("\n");
		
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(selected[i]) continue;
			
			numbers[cnt] = arr[i];
			selected[i]  = true;
			
			permutation(cnt+1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		numbers = new int[M];
		selected = new boolean[N];
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(arr);		//오름차순 정렬

		permutation(0);
		
		bw.append(sb);
		bw.close();
		
	}

}
