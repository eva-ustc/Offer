package chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/2/1 15:10
 * @description God Bless, No Bug!
 */
public class Sub13_RobotMove {

    public static void main(String[] args) {

        int n = movingCount(18, 40, 40);
        System.out.println(n);
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int count = countCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private static int countCore(int threshold, int rows, int cols, int i, int j, boolean[] visited) {

        int count = 0;
        int index = i * cols + j;
        if (i >= 0 && i < rows && j >= 0 && j < cols && (getSum(i) + getSum(j)) <= threshold && !visited[index]) {

            visited[index] = true;
            // 递归调用,判断上下左右四个点是否满足条件
            count = 1 + countCore(threshold, rows, cols, i - 1, j, visited) +
                    countCore(threshold, rows, cols, i + 1, j, visited) +
                    countCore(threshold, rows, cols, i, j - 1, visited) +
                    countCore(threshold, rows, cols, i, j + 1, visited);
        }
        return count;
    }

    private static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}
