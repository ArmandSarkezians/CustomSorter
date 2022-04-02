import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomSorter {
  private static final int SIZE = 10000000;

  public static int[] stupidSorter(int[] arr) {

    /* Find the maximum value of this array */
    int max = 0;
    for (int i = 0; i < arr.length; i++)
      if (arr[i] > max)
        max = arr[i];

    int[] bitArr = new int[max + 1];

    for (int i = 0; i < arr.length; i++)
      bitArr[arr[i]] = 1;

    int[] sorted = new int[arr.length];
    int count = 0;
    for (int i = 0; i < max + 1; i++)
      if (bitArr[i] == 1) {
        sorted[count] = i;
        count++;
      }

    return sorted;
  }

  /* Merge Sort */
  public static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
    if (lo >= hi)
      return;
    int mid = lo + (hi - lo) / 2;
    mergeSort(arr, aux, lo, mid);
    mergeSort(arr, aux, mid + 1, hi);
    merge(arr, aux, lo, mid, hi);
  }

  public static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++)
      aux[i] = arr[i];
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        arr[k] = aux[j++];
      else if (j > hi)
        arr[k] = aux[i++];
      else if (aux[i] < aux[j])
        arr[k] = aux[i++];
      else
        arr[k] = aux[j++];
    }
  }

  public static int[] convertToArray(List<Integer> lst) {
    int[] arr = new int[lst.size()];
    int i = 0;
    for (Integer x : lst) {
      arr[i++] = x;
    }
    return arr;
  }

  public static void main(String[] args) {
    /* Creating a List and filling it with the numbers 1 .. SIZE */
    List<Integer> lst = new ArrayList<Integer>();
    for (int i = 0; i < SIZE; i++) {
      lst.add(i);
    }

    /* Shuffling the list */
    Collections.shuffle(lst);

    /* Converting the set to an array */
    int[] arr = convertToArray(lst);

    /* Ensuring my complexity is smaller than that of merge sort in a good case */
    long customSorterStartTime = System.currentTimeMillis();
    stupidSorter(arr);
    long customSorterEndTime = System.currentTimeMillis();

    long mergeSorterStartTime = System.currentTimeMillis();
    mergeSort(arr, new int[SIZE], 0, SIZE - 1);
    long mergeSorterEndTime = System.currentTimeMillis();

    System.out.println("Best Case:");
    System.out.println("Custom Sorter: " + (customSorterEndTime - customSorterStartTime) + "ms");
    System.out.println("Merge Sorter: " + (mergeSorterEndTime - mergeSorterStartTime) + "ms");
    System.out.println();

    /* Showing that my sorter is worse than merge sort in the worst case */
    lst.add(200000000); // Worst case is an array {1, 2, 1000000000}
    Collections.shuffle(lst);
    arr = convertToArray(lst);

    customSorterStartTime = System.currentTimeMillis();
    stupidSorter(arr);
    customSorterEndTime = System.currentTimeMillis();

    mergeSorterStartTime = System.currentTimeMillis();
    mergeSort(arr, new int[SIZE], 0, SIZE - 1);
    mergeSorterEndTime = System.currentTimeMillis();

    System.out.println("Worst Case:");
    System.out.println("Custom Sorter: " + (customSorterEndTime - customSorterStartTime) + "ms");
    System.out.println("Merge Sorter: " + (mergeSorterEndTime - mergeSorterStartTime) + "ms");

  }
}