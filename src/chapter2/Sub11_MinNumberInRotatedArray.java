package chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/1/31 22:53
 * @description God Bless, No Bug!
 */
public class Sub11_MinNumberInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int result = getMinNumber(arr);
        System.out.println(result);
    }

    private static int getMinNumber(int[] array) {
        if (array==null || array.length<=0) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        int preIdx = 0;
        int lastIdx = array.length-1;
        int midIdx = preIdx;
        while (array[preIdx]>=array[lastIdx]){

            if (preIdx+1==lastIdx){
                midIdx = lastIdx;
                break;
            }
            midIdx = (preIdx+lastIdx)/2;

            if (array[preIdx]==array[midIdx] && array[midIdx]==array[lastIdx]){
                return minInRotatedArray(array,preIdx,lastIdx);
            }

            if (array[midIdx]>array[preIdx]){
                preIdx = midIdx;
            }
            if (array[midIdx]<array[lastIdx]){
                lastIdx = midIdx;
            }
        }
        return array[midIdx];
    }

    private static int minInRotatedArray(int[] array, int preIdx, int lastIdx) {

        int min = array[preIdx];
        for (int i=preIdx+1;i<=lastIdx;i++){
            if (array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}
