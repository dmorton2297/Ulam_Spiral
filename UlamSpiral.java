
/**
 * Write a description of class UlamSpiral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UlamSpiral
{
    private final int DECREMENT_COL = 0;
    private final int DECREMENT_ROW = 1;
    private final int INCREMENT_COL = 2;
    private final int INCREMENT_ROW = 3;

    private int addingMode;

    private int[][] matrix;
    private int row;
    private int col;

    /*
     * Constructor for the UlamSpiral class
     * initially matrix of length[4][4]
     * 
     * row = 1, col = 0 (start point)
     */
    public UlamSpiral()
    {
        matrix = new int[2][2];

        row = 1;
        col = 0;

        addingMode = INCREMENT_COL;
    }

    /*
     * Incremeting the size of the matrix by 2, for both row and column length
     */
    private void addMoreSpace()
    {
        int[][] newMatrix = new int[matrix.length+2][matrix[0].length+2];

        for (int row = 0; row< matrix.length; row++)
        {
            for (int col = 0; col< matrix[0].length; col++)
            {
                newMatrix[row+1][col+1] = matrix[row][col];
            }
        }

        matrix = newMatrix;
        col++;
    }

    /*
     * Add a value into this specific Ulam Spiral
     */
    public void add(int n)
    {

        matrix[row][col] = n;
        checkChangeInDirection();
        if (addingMode == INCREMENT_COL)
        {
            col++;
        }
        else if (addingMode == DECREMENT_ROW)
        {
            row--;
        }
        else if (addingMode == DECREMENT_COL)
        {
            col--;
        }
        else 
        {
            row++;
        }

    }

    public void checkChangeInDirection()
    {
        if (row == matrix.length-1 && col == 0)// bottom left
        {
            addingMode = INCREMENT_COL;
        }
        else if (row == matrix.length-1 && col == matrix[0].length-1)//bottom right
        {
            addingMode = DECREMENT_ROW;
        }
        else if (row == 0 && col == matrix[0].length-1)//top right
        {
            addingMode = DECREMENT_COL;
        }
        else if (row == 0 && col == 0)//top left
        {
            addMoreSpace();
            col--;
            addingMode = INCREMENT_ROW;
        }
    }

    /*
     * remove a specified value
     */
    public int remove(int n)
    {
        return -1;
    }

    /*
     * remove a specified value at this index
     */
    public int removeAtIndex(int index)
    {
        return -1;
    }

    /*
     * return a string representation of this object
     */
    public String toString()
    {
        String str = "";
        for (int row = 0; row< matrix.length; row++)
        {
            for (int col = 0; col< matrix[0].length; col++)
            {
                if (matrix[row][col] < 10)
                    str+= matrix[row][col]+ "   ";
                else if (matrix[row][col]<100)
                    str+= matrix[row][col]+ "  ";
                else if (matrix[row][col]<1000)
                    str+= matrix[row][col]+ " ";
                else
                    str+= matrix[row][col];
            }
            str+= "\n";
        }

        return str;
    }
    
    public String primeToString()
    {
        String str = "";
        for (int row = 0; row< matrix.length; row++)
        {
            for (int col = 0; col< matrix[0].length; col++)
            {
                if (checkPrime(matrix[row][col]))
                {
                    str+= "1  ";
                }
                else
                    str+= "   ";
            }
            str+= "\n";
        }
        
        return str;
    }
    
    public boolean checkPrime(int n)
    {
        for (int i=2; i< n; i++)
        {
            if (n%i == 0)
                return false;
        }
        return true;
    }
}
