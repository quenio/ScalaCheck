package sorting;

public class InsertionSort
{
    public static void sort(int[] a)
    {
        for (int j = 1; j < a.length; j++)
        {
            final int key = a[j];
            int i = j - 1;
            while ((i >= 0) && (a[i] > key))
            {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
}
