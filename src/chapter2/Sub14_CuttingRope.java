package chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/2/1 15:50
 * @description God Bless, No Bug!
 */
public class Sub14_CuttingRope {
    public static void main(String[] args) {

        int max = getMaxProduct2(14);
        System.out.println(max);
    }

    /**
     * 贪心算法:
     *      1 长度大于等于5米的时候尽可能多剪成3米
     *      2 最后剩下4米时剪成两个2米
     *
     * @param number
     * @return
     */
    private static int getMaxProduct2(int number) {

        if (number<2){
            return 0;
        }
        if (number <4) return number-1;
        int timesOf3 = number/3;
        if (number%3 == 1){ // 如果最后剩下4米
            timesOf3 -= 1;
        }
        int timesOf2 = (number-timesOf3*3)/2;
        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
    }

    /**
     * 动态规划: 长度为n的绳子剪成m段,使得成绩最大
     * @param number
     * @return
     */
    private static int getMaxProduct(int number) {

        if (number<2){
            return 0;
        }
        if (number == 2) return 1;
        if (number == 3) return 2;

        int[] product = new int[number+1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        int max=0;
        for (int i=4;i<=number;i++){
            max = 0;
           for (int j=1;j<=i/2;j++){
               int res = product[j]*product[i-j];
               if (max < res){
                   max = res;
               }
               product[i] = max;
           }
        }
        return product[number];
    }


}
