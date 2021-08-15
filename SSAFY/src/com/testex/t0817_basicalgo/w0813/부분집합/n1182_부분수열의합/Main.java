package com.testex.t0817_basicalgo.w0813.부분집합.n1182_부분수열의합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	private static int N;
	private static int S;
	private static int [] arr;
	private static int sCnt = 0;
	private static StringBuilder sb= new StringBuilder();
	
	private static void powerSet(int cnt, boolean [] selected) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0;i<N;i++) {
				if(selected[i]) {
					sum += arr[i];
					sb.append(sum+" ");
				}
			}
			sb.append("="+sum+" ");
			if(sum==S) 
				sCnt++;
			
			sb.append("\n");
			return;
		}
		selected[cnt] = true;
		powerSet(cnt+1, selected);
		
		selected[cnt] = false;
		powerSet(cnt+1, selected);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		powerSet(0, new boolean[N]);
		
		bw.append(sb);
		bw.append(sCnt+" ");
		bw.flush();
		bw.close();
	}

}
