package Tasks;

public final class Array2DTask
{
    private Array2DTask() {}

    private static final int ROWS = 5;
    private static final int COLS = 4;
    private static final int R1 = 0;
    private static final int R2 = 4;
    private static final int C1 = 1;
    private static final int C2 = 2;

    public static void run()
    {
        System.out.println("\nPart B: 2D array");
        int[][] m = new int[ROWS][COLS];

        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                m[i][j] = (i + 1) * 10 + (j + 1);
            }
        }
        print(m, "Initial matrix:");

        swapRows(m, R1, R2);
        print(m, "After swapping rows " + R1 + " and " + R2 + ":");

        swapCols(m, C1, C2);
        print(m, "After swapping columns " + C1 + " and " + C2 + ":");
    }

    private static void print(int[][] m, String title)
    {
        System.out.println(title);
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void swapRows(int[][] m, int r1, int r2)
    {
        int[] t = m[r1];
        m[r1] = m[r2];
        m[r2] = t;
    }

    public static void swapCols(int[][] m, int c1, int c2)
    {
        for (int i = 0; i < m.length; i++) {
            int t = m[i][c1];
            m[i][c1] = m[i][c2];
            m[i][c2] = t;
        }
    }
}