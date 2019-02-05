package chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/1/31 23:49
 * @description God Bless, No Bug!
 */
public class Sub12_StringPathInMatrix {

    public static void main(String[] args) {

        char[] matrix = "abtgcfcsjdeh".toCharArray();
        char[] str = "bfce".toCharArray();
        boolean hasPath = hasPath(matrix,3,4,str);
        System.out.println(hasPath);
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix==null || rows<1||cols<1||str==null){
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        int pathLength = 0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){

                if (hasPathCore(matrix,rows,cols,str,i,j,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int i, int j, int pathLength, boolean[] visited) {

        if (pathLength == str.length){
            return true;
        }
        int index = i*cols+j;
        boolean hasPath = false;
        if (i >= 0 && i < rows && j >= 0 && j < cols &&matrix[index]==str[pathLength]&& !visited[index]){
            pathLength++;
            visited[index]=true;
            hasPath = hasPathCore(matrix,rows,cols,str,i-1,j,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,str,i+1,j,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,str,i,j-1,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,str,i,j+1,pathLength,visited);
            if (!hasPath){
                --pathLength;
                visited[index] = false;
            }
        }
        return hasPath;
    }


}
