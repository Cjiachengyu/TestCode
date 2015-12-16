package com.test;

public class QuickSort {

	public static void main(String[] args) throws InterruptedException {
		
		int a[]={7,6,1,4,3,2,5,9,8,14,11,2,3,7,18};
		
		int left = 1;
		int right = a.length-1;
		
		qucikSort(a,left,right,0);
		
		for(int i =0;i < a.length;i++)
		{
			System.out.print(a[i]+"\t");
		}
	}
	
	public static void qucikSort(int a[],int lef,int righ,int inde) 
	{
		int left = lef ;
		int right = righ;
		int index = inde ; 
		int value = a[index];
		
		while(left <= right)
		{
			if(a[left]<value)
			{
				int temp = a[left];
				a[left] = value;
				a[index] = temp;
				
				index = left ;
				value = a[index];
				
				left++;
			}
			else {
				left++;
			}
		}
		
		int tempIndex = index;
		
		if(1<tempIndex)
		qucikSort(a,1,tempIndex,0);
		
		if((tempIndex+2)<=right)
		qucikSort(a,tempIndex+2,right,tempIndex+1);
	}
}
