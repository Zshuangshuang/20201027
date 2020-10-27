import java.util.Arrays;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-27
 * Time:15:36
 **/
public class TestSort {

    public static void mergeSort(int[] array){
        mergeSortInternal(array, 0, array.length);
    }
    public static void mergeSortInternal(int[] array,int lowIndex,int highIndex){
        //size表示需要排序的部分
        int size = highIndex-lowIndex;
        if (size <= 1){
            return;
        }

        int midIndex = (highIndex+lowIndex)/2;
        //划分区间，左区间：[lowIndex,midIndex)
        //右区间：[midIndex, highIndex)
        mergeSortInternal(array,lowIndex,midIndex);
        mergeSortInternal(array,midIndex,highIndex);

        heBingTwoSortArray(array,lowIndex,midIndex,highIndex);
    }
 public static void heBingTwoSortArray(int[] array,int lowIndex,int midIndex,int highIndex){
     int size = highIndex - lowIndex;//待合并区件
     int[] extraArray = new int[size];//用来放有序区间的新数组

     int leftIndex = lowIndex;
     int rightIndex = midIndex;
     int extraIndex = 0;

     // 两个队伍都有人
     while (leftIndex < midIndex && rightIndex < highIndex) {
         if (array[leftIndex] <= array[rightIndex]) {
             extraArray[extraIndex] = array[leftIndex];
             extraIndex++;
             leftIndex++;
         } else {
             extraArray[extraIndex] = array[rightIndex];
             extraIndex++;
             rightIndex++;
         }
     }

     // 有个队伍没有人
     if (leftIndex < midIndex) {
         while (leftIndex <  midIndex) {
             extraArray[extraIndex] = array[leftIndex];
             extraIndex++;
             leftIndex++;
         }
     } else {
         while (rightIndex < highIndex) {
             extraArray[extraIndex] = array[rightIndex];
             extraIndex++;
             rightIndex++;
         }
     }
     // 最后，把数据从新数组统一搬回去
     // 新数组 [0, size)
     // 搬回去的下标范围 [lowIndex, highIndex)
     for (int i = 0; i < size; i++) {
         array[i + lowIndex] = extraArray[i];
     }

 }
    public static void main(String[] args) {

        int[] array = {1,3,9,7,6,4,2,8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
}
