package com.qst.test;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		int []a = new int[1024];
		int a1=0, a2=0, a3=0, a5=0;
		double a4 = 0.0;
		
		int flag = 0, count = 0;
	
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 1; i <= n; i++) {
			
			int number = scanner.nextInt(); 
			
			//判断a1
			if(number % 10 == 0 ) {
				a1+=number;
			}
			//判断a2
			if(number % 5 == 1) {
				if(flag == 0) {
					a2+=number;
					flag = 1;
				} else {
					a2 += number*(-1);
					flag = 0;
				}
			}
			if(number % 5 == 2) {
				a3++;
			}
			if(number % 5 == 3) {
				a4+=number;
				count++;
			}
			if(number % 5 == 4) {
				if(number > a5) {
					a5 = number;
				}
			}
		}
		if(a1 != 0) {
			System.out.print(a1+" ");
		} else{
			System.out.print("N ");
		}
		
		if(a2 != 0) {
			System.out.print(a2+" ");
		} else{
			System.out.print("N ");
		}
		
		
		if(a3 != 0) {
			System.out.print(a3+" ");
		} else{
			System.out.print("N ");
		}
		
		if(a4 != 0) {
			System.out.print(String.format("%.1f",(a4/count))+" ");
		} else{
			System.out.print("N ");
		}
		
		if(a5 != 0) {
			System.out.print(a5);
		} else{
			System.out.print("N");
		}
		

	}

}
