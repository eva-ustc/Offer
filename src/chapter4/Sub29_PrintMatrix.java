package chapter4;

import java.util.ArrayList;


/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/3 14:03
 * @description God Bless, No Bug!
 */
public class Sub29_PrintMatrix {
    public static void main(String[] args) {
        int[][]  matrix = new int[1][1];
        matrix[0][0] = 1;
        System.out.println(printMatrix(matrix));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) return result;

        int startX = 0,startY = 0;
        int endX=matrix.length-1,endY = matrix[0].length-1;
        while (startX<=endX && startY<=endY){

            printMatrixInCircle(matrix,startX++,startY++,endX--,endY--,result);
        }
        return result;

    }

    private static void printMatrixInCircle(int[][] matrix, int startX, int startY, int endX, int endY, ArrayList<Integer> result) {

        if (startX == endX){ // 只有一行
            while (startY<=endY){
                result.add(matrix[startX][startY++]);
            }
        }else if (startY == endY){ // 只有一列
            while (startX<=endX){
                result.add(matrix[startX++][startY]);
            }
        }else { // 多行多列
            int curX = startX;
            int curY = startY;

            while (curY!=endY){// 从左到右
                result.add(matrix[curX][curY++]);
            }
            while (curX!=endX){ // 从上到下
                result.add(matrix[curX++][curY]);
            }
            while (curY!=startY){// 从右到左
                result.add(matrix[curX][curY--]);
            }
            while (curX!=startX){
                result.add(matrix[curX--][curY]);
            }
        }
    }


}
