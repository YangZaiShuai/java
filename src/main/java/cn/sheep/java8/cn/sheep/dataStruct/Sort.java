package cn.sheep.java8.cn.sheep.dataStruct;

/**冒泡排序
 * @auther create by jhy
 * @date 2018/5/2 16:41
 */
public class Sort {
    public static void main(String[] args) {

        int[] arr = {3,1,5,9,7,4,6,2,8};







        for (int i=0;i<arr.length-1;i++){
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                }





            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
