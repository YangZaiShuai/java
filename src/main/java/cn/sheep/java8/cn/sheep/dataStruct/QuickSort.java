package cn.sheep.java8.cn.sheep.dataStruct;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {3,1,5,9,7,4,6,2,8};
        quick(arr,0,arr.length-1);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void quick(int[] arr,int start,int end){
         int i =start;
         int j = end;
         int key = arr[i];

         while(i<j){
             while(i<j&&arr[j]>=key){
                 j--;
             }
             if (i<j){
                 int temp = arr[i];
                 arr[i]= arr[j];
                 arr[j]=temp;
             }
             while(i<j&&arr[i]<=key){
                 i++;
             }
             if (i<j){
                 int temp = arr[j];
                 arr[j]= arr[i];
                 arr[i]=temp;
             }
         }
         if (i-start>1){

             quick(arr,start,i-1);
         }
         if (end-j>1){

             quick(arr,j+1,end);
         }

    }

}
