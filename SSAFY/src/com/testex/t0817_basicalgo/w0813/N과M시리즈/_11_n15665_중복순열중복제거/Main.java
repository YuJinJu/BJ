package com.testex.t0817_basicalgo.w0813.N과M시리즈._11_n15665_중복순열중복제거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//중복 순열
public class Main {
	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] number;
	private static boolean [] selected;
	private static LinkedHashSet<String> set;
	
	private static void dupPermut(int cnt) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();

			for(int n : number) {
				sb.append(n+" ");
			}
			
			set.add(sb.toString()+"\n");
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
		 set = new LinkedHashSet<String>();
		 
		 st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dupPermut(0);
		
		for(String s : set) bw.append(s);
		
		bw.flush();
		bw.close();
		
	}

}
