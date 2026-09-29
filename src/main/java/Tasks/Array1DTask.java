package Tasks;

import java.util.Arrays;

public final class Array1DTask
{
    private Array1DTask() {}

    private static final int N = 12;
    private static final int A = 6;
    private static final int B = 5;
    private static final int I1 = 2;
    private static final int I2 = 11;

    public static void run()
    {
        System.out.println("\nPart A: 1D array");
        int[] x = new int[N];

        for (int i = 0; i < x.length; i++)
        {
            x[i] = A * i - B;
        }
        print(x, "Initial array x:");

        System.out.println("Minimum element = " + min(x));
        System.out.println("Maximum element = " + max(x));
        System.out.println("Sum of elements = " + sum(x));

        int[] sorted = x.clone();
        Arrays.sort(sorted);
        print(sorted, "Sorted array:");

        int[] swapped = sorted.clone();
        swap(swapped, I1, I2);
        print(swapped, "After swapping elements at indices [" + I1 + "] and [" + I2 + "]:");

        int[] compressed = compressRemoveNegative(swapped);
        print(compressed, "Compressed array (negative elements removed):");

        copyDemo(compressed);
    }

    private static void print(int[] x, String title)
    {
        System.out.println(title);
        System.out.println(Arrays.toString(x));
    }

    private static int min(int[] x)
    {
        int m = x[0];
        for (int i = 1; i < x.length; i++) if (x[i] < m) m = x[i];
        return m;
    }

    private static int max(int[] x)
    {
        int m = x[0];
        for (int i = 1; i < x.length; i++) if (x[i] > m) m = x[i];
        return m;
    }

    private static long sum(int[] x)
    {
        long s = 0;
        for (int v : x) s += v;
        return s;
    }

    private static void swap(int[] x, int i, int j)
    {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

    private static int[] compressRemoveNegative(int[] x)
    {
        int[] tmp = new int[x.length];
        int k = 0;
        for (int v : x) {
            if (v >= 0) tmp[k++] = v;
        }
        return Arrays.copyOf(tmp, k);
    }

    private static void copyDemo(int[] x)
    {
        System.out.println("\nCopy demonstration:");
        int[] ref = x;
        int[] clone = x.clone();
        int[] copyOf = Arrays.copyOf(x, x.length);
        int[] sysCopy = new int[x.length];
        System.arraycopy(x, 0, sysCopy, 0, x.length);

        if (ref.length > 0)
        {
            ref[0] += 999;
        }
        System.out.println("ref after ref[0]+=999: " + Arrays.toString(ref));
        System.out.println("x after ref[0]+=999: " + Arrays.toString(x));
        System.out.println("clone (independent): " + Arrays.toString(clone));
        System.out.println("copyOf (independent): " + Arrays.toString(copyOf));
        System.out.println("sysCopy (independent): " + Arrays.toString(sysCopy));
        System.out.println("Arrays.equals(x, clone) = " + Arrays.equals(x, clone));
        System.out.println("Arrays.equals(copyOf, sysCopy) = " + Arrays.equals(copyOf, sysCopy));
    }
}