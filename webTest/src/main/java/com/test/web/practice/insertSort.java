package com.test.web.practice;

import java.util.Arrays;

public class insertSort {

	public static void main(String[] args) {
		int[] array = {6,3,9,4,2,5};
		System.out.println(Arrays.toString(array));
//		insertSortImpl(array);
//		bubbleSort(array);
//		selectSort(array);
//		quickSort(array,0,5);
		
		mergeSort(array,0,5,new int[6]);
		System.out.println(Arrays.toString(array));

	}
	
	public static void insertSortImpl(int[] array){
		for(int i=0;i<array.length;i++){
			int k = array[i];int j;
			for(j=i-1;j>=0 && array[j]>k;j--){
				array[j+1] = array[j];
			}
			array[j+1]=k;
		}
	}

	public static void bubbleSort(int[] a){
		for(int i=0;i<a.length;i++){
			if(bubble(a,a.length-i)){
				break;
			}
		}
		
	}
	private static boolean bubble(int[] a,int n){
		boolean sorted = true;
		for(int i=0;i<n-1;i++){
			if(a[i]>a[i+1]){
				swap(i,i+1,a);
				sorted = false;
			}
		}
		return sorted;
	}
	private static void swap(int i,int j,int[] a){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;				
	}
	
	public static void selectSort(int[] a){
		for(int i=a.length;i>0;i--){
			int max=0;
			for(int j=0;j<i;j++){
				if(a[max]<a[j])max=j;
			}
			swap(max,i-1,a);
		}
	}
	public static void quickSort(int[] a,int first,int last){
		int q = quickOnce(a,first,last);
		if(q<=first||q>=last)return;
		quickSort(a,first,q-1);
		quickSort(a,q+1,last);
	}
	private static int quickOnce(int[] a,int first,int last){
		int k=a[last];int j=first-1;
		for(int i=first;i<last;i++){
			if(a[i]<k){
				swap(++j,i,a);
			}
		}
		swap(last,j+1,a);
		
		return j+1;
	}
	public static void mergeSort(int[] a,int first,int last,int[] temp){
		int mid = (first + last)/2;
		if(mid<=first || mid >=last)return;
		mergeSort(a,first,mid,temp);
		mergeSort(a,mid,last,temp);
		merge(a,first,mid,last,temp);
		
	}
	private static void merge(int[] a,int first,int mid,int last,int[] temp){
		int i=first;int j = mid+1;int k=0;
		while(i<=mid&&j<=last){
			temp[k++]=a[i]<a[j]?a[i++]:a[j++];
		}
		while(i<mid){
			temp[k++]=a[i++];
		}
		while(j<last){
			temp[k++]=a[j++];
		}
		k=first;
		for(int c=0;c<temp.length;c++){
			a[k++]=temp[c];
		}
	}
}
