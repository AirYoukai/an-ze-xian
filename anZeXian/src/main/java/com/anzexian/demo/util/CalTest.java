package com.anzexian.demo.util;

public class CalTest {
    public static void main(String[] args) {
        int num=5;
        int sum=1;
        for(int i=1;i<num;i++){
            sum+=i*(i+1)+(i+1)*(i+1);
        }
        System.out.println(sum);
    }
}
