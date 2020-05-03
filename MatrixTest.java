public class MatrixTest {
    
    public static void main(String[] args)
    {
    	Matrix a = new Matrix(2, 2);
    	Matrix b = new Matrix(2, 2);

    	a.setEntry(1, 1, 0);
    	a.setEntry(1, 2, 1);
    	a.setEntry(2, 1, 1);
    	a.setEntry(2, 2, 0);

    	b.setEntry(1, 1, 2);
    	b.setEntry(1, 2, 3);
    	b.setEntry(2, 1, 4);
    	b.setEntry(2, 2, 5);


        System.out.println("Matrix A:");
        System.out.println(a);
        System.out.println("Matrix B:");
        System.out.println(b);


        System.out.println("A + B:");
        System.out.println(a.matrixAdd(b));

        System.out.println("AB:");
        System.out.println(a.matrixMultiply(b));

        System.out.println("B^2:");
        System.out.println(b.matrixPower(2));

        System.out.println("B^3:");
        System.out.println(b.matrixPower(3));

        System.out.println("B^4:");
        System.out.println(b.matrixPower(4));

    }

}