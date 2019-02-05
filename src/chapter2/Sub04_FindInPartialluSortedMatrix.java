package chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/1/30 14:50
 * @description God Bless, No Bug!
 *
 * 从二维数组的右上方开始查找：
    若元素值等于 target，返回 true；
    若元素值大于 target，砍掉这一列，即 --j；
    若元素值小于 target，砍掉这一行，即 ++i。
    也可以从二维数组的左下方开始查找，以下代码使用左下方作为查找的起点。

    注意，不能选择左上方或者右下方的数字，因为这样无法缩小查找的范围。
 */
public class Sub04_FindInPartialluSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        find(7,matrix);
    }
    private static boolean find(int target,int[][] matrix){

        boolean flag = false;
        if (matrix == null){
            return flag;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns-1;
       while (row < rows && column >0){
           if (matrix[row][column] == target){
               System.out.println("target位置: ["+row+","+column+"]:"+target);
               flag = true;
               break;
           }else if (matrix[row][column]>target){
               column--;
           }else {
               row++;
           }
       }
       if (!flag){
           System.out.println("数组不包含target");
       }
        return flag;
    }
}
