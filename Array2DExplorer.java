
/**
 * Write a description of class Array2DExplorer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Array2DExplorer
{
    public boolean evenRow(int[][] mat, int row){
        boolean allEven = true;
        for (int i : mat[row]){
            if (i % 2 != 0){
                allEven = false;
            }
        }
        return allEven;
    }
    
    public boolean oddColSum(int[][] nums, int col){
        int sum = 0;
        for (int[] row : nums){
            sum += row[col];
        }
        if (sum % 2 == 0){
            return false;
        }
        return true;
    }
    
    public int[] minRowPractice(int[][] nums){
        int min = Integer.MAX_VALUE;
        int minRow = 0;
        for (int row = 0; row < nums.length; row++){
            for (int col = 0; col < nums[row].length; col++){
                if (nums[row][col] < min){
                    min = nums[row][col];
                    minRow = row;
                }
            }
        }
        return nums[minRow];
    }
    
    // Looks through each element of the chosen row and returns the smallest integer from that row
    public int minRowAssignment(int[][] nums, int row){
        int minIndex = 0;
        for (int i = 0; i < nums[row].length; i++){
            if (nums[row][i] < nums[row][minIndex]){
                minIndex = i;
            }
        }
        return nums[row][minIndex];
    }
    
    // Searches through each column of an array and returns an array with the largest integer from each column
    public int[] colMaxs(int[][] matrix){
        int[] maxes = new int[matrix[0].length];
        for (int i = 0; i < maxes.length; i++){
            int localMax = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++){
                if (matrix[j][i] > localMax){
                    localMax = matrix[j][i];
                }
            }
            maxes[i] = localMax;
        }
        return maxes;
    }
    
    // Calculates the row sum for every row and returns each of the values in an array. Index i of the
    // return array contains the sum of elements from row i
    public int[] allRowSums(int[][] data){
        int[] sums = new int[data.length];
        for (int i = 0; i < data.length; i++){
            int localSum = 0;
            for (int j = 0; j < data[i].length; j++){
                localSum += data[i][j];
            }
            sums[i] = localSum;
        }
        return sums;
    }
    
    // Calculates the average of each column in the array nums, and returns those values in an array of doubles
    public double[] averageCol(int[][] nums){
        double[] avgs = new double[nums[0].length];
        for (int j = 0; j < nums[0].length; j++){
            int localSum = 0;
            for (int i = 0; i < nums.length; i++){
                localSum += nums[i][j];
            }
            double localAvg = (double)localSum / nums.length;
            avgs[j] = localAvg;
        }
        return avgs;
    }
    
    // Finds and returns the smallest even number in the array matrix. Assume that the array is filled with only
    // positive ints.
    public int smallEven(int[][] matrix){
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix){
            for (int col : row){
                if (col < min && col % 2 == 0){
                    min = col;
                }
            }
        }
        return min;
    }
    
    // Returns the row index number that has the greatest sum of its elements
    public static int biggestRow(int[][] nums){
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int localSum = 0;
            for (int j = 0; j < nums[i].length; j++){
                localSum += nums[i][j];
            }
            sums[i] = localSum;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxSumIndex = -1;
        for (int i = 0; i < sums.length; i++){
            if (sums[i] > maxSum){
                maxSum = sums[i];
                maxSumIndex = i;
            }
        }
        return maxSumIndex;
    }
    
    public static void main(String[] args) {
        int array [][] = {  {4,1,8,5},
                            {0,2,3,4},
                            {6,6,2,2} };
        Array2DExplorer exp = new Array2DExplorer();

        System.out.println("Test evenRow: \n Row w/ odd, Expecting: false \n Actual: " + exp.evenRow(array,0));
        System.out.println("Test evenRow: \n Row w/o odd, Expecting: true \n Actual: " + exp.evenRow(array,2));

        System.out.println();

        System.out.println("Test oddColSum: \n Col w/ odd Sum, Expecting: true \n Actual: " + exp.oddColSum(array,1));
        System.out.println("Test oddColSum: \n Col w/ even, Expecting: false \n Actual: " + exp.oddColSum(array,0));

        System.out.println();


        System.out.print("Test minRow: \n Expecting: {0 2 3 4} \n Actual: {");
        int [] row = exp.minRowPractice(array);
        for(int i = 0; i < row.length; i++){
            System.out.print(row[i] + " ");
        }
        System.out.print("}");

        System.out.println();

        System.out.print("Test minRowAssignment: \n Expecting: 2 \n Actual: ");
        System.out.println(exp.minRowAssignment(array, 2));

        System.out.println();

        System.out.print("Test colMax: \n Expecting: {6 6 8 5} \n Actual: {");
        int [] colMaxs = exp.colMaxs(array);
        for(int i = 0; i < colMaxs.length; i++){
            System.out.print(colMaxs[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test allRowSum: \n Expecting: {18 9 16} \n Actual: {");
        int [] sum = exp.allRowSums(array);
        for(int i = 0; i < sum.length; i++){
            System.out.print(sum[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test averageCol: \n Expecting: {3.333333 3.0 4.333333 3.6666667} \n Actual: {");
        double [] avg = exp.averageCol(array);
        for(int i = 0; i < avg.length; i++){
            System.out.print(avg[i] + " ");
        }
        System.out.print("}");


        System.out.println();
        System.out.println();

        System.out.print("Test smallEven: \n Expecting: 0 \n Actual: ");
        System.out.println(exp.smallEven(array));

        System.out.println();
        System.out.println();

        System.out.print("Test biggestRow: \n Expecting: 0 \n Actual: ");
        System.out.println(exp.biggestRow(array));

        System.out.println();
    }
}
