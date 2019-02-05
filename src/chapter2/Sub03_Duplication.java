package chapter2;

public class Sub03_Duplication {

    public static void main(String[] args) {

        int[] datas = {2, 3, 5, 4, 3, 2, 6, 7};
        int duplicate = getDuplication(datas);
        System.out.println("hhhhhhh");
        System.out.println("重复数字:" + duplicate);

    }

    private static int getDuplication(int[] datas) {

        if (datas == null || datas.length < 1) {
            return -1;
        }

        int start = 1;
        int end = datas.length - 1;
        while (end >= start) {

            int middle = start + ((end - start) >> 1);

            // 计算有多少个数字位于[start,middle]之间
            int count = countRange(datas, start, middle);
            if (start == end) { // 已经搜索到最后一个数字
                if (count > 1) { // 如果count>1则表示start是重复的数字
                    return start;
                }
                break;
            }
            if (count > (middle - start) + 1) {
                // [start,middle]之间的count > 一半,表示重复数字在前半段,middle作为新的end
                end = middle;
            } else {
                // [start,middle]之间的count < 一半,表示重复数字在后半段,middle+1作为新的start
                start = middle + 1;
            }

        }
        return -1;
    }

    /**
     * 计算数组中有多少个数在[start,middle]之间
     * 时间复杂度 O(n)
     *
     * @param datas
     * @param start
     * @param middle
     * @return
     */
    private static int countRange(int[] datas, int start, int middle) {

        if (datas == null) {
            return 0;
        }
        int count = 0;
        for (int i : datas) {
            if (i >= start && i <= middle) {
                count++;
            }
        }
        return count;
    }

}
