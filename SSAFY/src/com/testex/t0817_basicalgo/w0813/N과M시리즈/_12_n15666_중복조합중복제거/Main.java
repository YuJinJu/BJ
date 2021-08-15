package com.testex.t0817_basicalgo.w0813.N과M시리즈._12_n15666_중복조합중복제거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

//중복 조합
public class Main {
	private static int N;
	private static int M;
	private static int [] arr;
	private static int [] store;
	private static LinkedHashSet<String> set = new LinkedHashSet<String>();
	
	private static void dupCombination(int cnt, int start) {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			
			for(int s : store)
				sb.append(s+" ");
			
			set.add(sb.toString()+"\n");
			return;
		}
		
		for(int i= start; i<N;i++) {
			store[cnt] = arr[i];
			// 중복되지 않은 조합은 재귀로 넘겨주는 start값이 i + 1이였는데 중복조합은 자기자신은 포함하므로 i로 넘겨준다.
			dupCombination(cnt+1, i);	
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		store = new int [M];
		dupCombination(0, 0);

		for(String s : set) bw.append(s);

		bw.flush();
		bw.close();
	}

}
