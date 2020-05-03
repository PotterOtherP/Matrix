public class Matrix {

    private final int MAX_SIZE = 10;

    private int rows;
    private int cols;
    private boolean square;
    private int[][] entries;


    public Matrix(int m, int n)
    {
        if (m < 1 || n < 1 || m > MAX_SIZE || n > MAX_SIZE)
        {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }

        rows = m;
        cols = n;

        entries = new int[rows][cols];

        square = (rows == cols)? true : false;
    }


    public int getEntry(int i, int j)
    {
        if (i > rows || j > cols || i < 1 || j < 1)
        {
            throw new IndexOutOfBoundsException("Element index out of bounds.");
        }

        return entries[i - 1][j - 1];
    }

    public void setEntry(int i, int j, int value)
    {
    	if (i > rows || j > cols || i < 1 || j < 1)
    	{
    		throw new IndexOutOfBoundsException("Element index out of bounds.");
    	}

    	entries[i - 1][j - 1] = value;
    }


    public boolean scalarMultiply(int scalar)
    {
    	for (int i = 0; i < rows; ++i)
	    	for (int j = 0; j < cols; ++j)
	    	{
	    		int result = entries[i][j] * scalar;
	    	}

	    return true;
    }

    public Matrix matrixAdd(Matrix mat)
    {
    	if (rows != mat.rows || cols != mat.cols)
    	{
    		throw new IllegalArgumentException("Matrices must have the same dimensions.");
    	}

    	Matrix result = new Matrix(rows, cols);

    	for (int i = 0; i < rows; ++i)
    		for (int j = 0; j < rows; ++j)
    		{
    			result.entries[i][j] = this.entries[i][j] + mat.entries[i][j];
    		}

    	return result;
    }

    public Matrix matrixMultiply(Matrix mat)
    {
    	if (this.cols != mat.rows)
    	{
    		throw new IllegalArgumentException("Matrix dimensions do not match.");
    	}

    	Matrix result = new Matrix(rows, cols);

    	for (int i = 0; i < rows; ++i)
    		for (int j = 0; j < mat.cols; ++j)
    		{
    			int sum = 0;

    			for (int x = 0; x < cols; ++x)
    			{
    				sum += (this.entries[i][x] * mat.entries[x][j]);
    			}


    			result.entries[i][j] = sum;
    		}

    	return result;

    }


    public Matrix matrixPower(int pow)
    {
    	if (!square)
    	{
    		throw new IllegalArgumentException("Matrix must be square.");
    	}

    	Matrix result = new Matrix(rows, cols);

    	for (int i = 0; i < rows; ++i)
    		result.entries[i][i] = 1;

    	for (int x = 1; x <= pow; ++x)
    		result = result.matrixMultiply(this);

    	return result;

    }


    public boolean equals(Object o)
    {
        if (o instanceof Matrix)
        {
            Matrix mat = (Matrix)(o);
            if (rows != mat.rows || cols != mat.cols)
            {
                return false;
            }

            for (int i = 0; i < rows; ++i)
            {
                for (int j = 0; j < cols; ++j)
                {
                    if (entries[i][j] != mat.entries[i][j])
                        return false;
                }
            }

            return true;
        }

        return false;
    }

    public String toString()
    {
        String result = "";

        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                result += entries[i][j];
                if (j < cols - 1)
                    result += " ";
            }

            result += "\n";
        }


        return result;
    }
    
}