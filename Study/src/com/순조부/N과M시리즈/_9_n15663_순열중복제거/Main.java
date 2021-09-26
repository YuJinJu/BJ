package com.순조부.N과M시리즈._9_n15663_순열중복제거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//중복순열인데 중복제거해야함

/*
input
4 2
9 7 9 1

output
1 7 
1 9 
7 1 
7 9 
9 1 
9 7 
9 9 
 */

//https://www.acmicpc.net/problem/15663
public class Main {

	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] numbers;
	private static boolean[] selected;
	private static LinkedHashSet<String> set;
	
	private static void dupPermutation(int cnt) {

		if (M == cnt) {
			StringBuilder sb = new StringBuilder();		//위치 중요!!

			for (int n : numbers) {
				sb.append(n).append(" ");
			}
			
			set.add(sb.toString()+"\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;

			numbers[cnt] = arr[i];

			selected[i] = true;
			dupPermutation(cnt + 1);
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
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		 set = new LinkedHashSet<String>();
		numbers = new int[M];
		selected = new boolean[N];

		dupPermutation(0);

		for(String s : set) {
			bw.append(s);
		}
		
		//set.forEach(System.out::println);
		
		bw.flush();
		bw.close();
	}
}
