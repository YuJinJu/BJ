package com.testex.t0817_basicalgo.w0813.N과M시리즈._3_n15651_중복순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//중복 순열
public class Main {
	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] number;
	private static boolean [] selected;
	private static StringBuilder sb = new StringBuilder();
	
	private static void dupPermut(int cnt) {
		if(cnt == M) {
			for(int i : number)
				sb.append(i+" ");
			
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(selected[i]) continue;
			
			number[cnt] = arr[i];
			//selected[i] = true;		//중복순열 하려면 선택했던것 확인 안해도 됨!
			
			dupPermut(cnt+1);
			//selected[i] = false;
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

		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		
		dupPermut(0);
		
		bw.append(sb);
		bw.flush();
		bw.close();
		
	}

}
