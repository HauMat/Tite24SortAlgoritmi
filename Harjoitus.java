import java.util.*;
import java.util.function.Function;

public class Harjoitus {

    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            int key = data[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }

    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n){
        
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    // partition function
    static int partition(int[] arr, int low, int high) {
        
        // choose the pivot
        int pivot = arr[high];
        
        // index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);  
        return i + 1;
    }

    // swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
        private static void QuickSort(int[] a, int lo, int hi)
        {
            //  lo is the lower index, hi is the upper index
            //  of the region of array a that is to be sorted
            int i = lo, j = hi, h;
 
            // comparison element x
            int x = a[(lo + hi) / 2];
 
            //  partition
            do
            {
                while (a[i] < x) i++;
                while (a[j] > x) j--;
                if (i <= j)
                {
                    h = a[i];
                    a[i] = a[j];
                    a[j] = h;
                    i++; j--;
                }
            } while (i <= j);
 
            //  recursion
            if (lo < j) QuickSort(a, lo, j);
            if (i < hi) QuickSort(a, i, hi);
        }

        // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce it step by step
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform a "gapped" insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                
                // Current element to be placed correctly
                int temp = arr[i]; 
                int j = i;

                // Shift earlier elements that are greater than temp
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                // Place temp in its correct position
                arr[j] = temp;
            }
        }
    }

    public static void printData(int[] data) {
        for (int x : data) {
            System.out.print(x + " ");
        }
        System.out.println("--------------------------");
        System.out.println();
    }

    public static int[] createRandomData(int n) {
        int[] data = new int[n];

        Random gen = new Random();

        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt(n);
        }

        return data;
    }

    public static int[] CreateAscendingTable(int n) { 
        int[] data = new int[n];
        
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        return data;
    }

    public static int[] CreateDescendingTable(int n) {
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++){
            data[i] = n - i;
        }

        return data;
    }

    static volatile long kohde = 0; //JIT ja DCE takia muuttuja jota muutetaan

    //Käytetään funktiota TimeTest funktion sisällä
    public static long TimeTest(Function<int[], int[]> func, int[] data) {
        int[] copy = data.clone(); //Kopioidaan data kloonaamalla -> Kaikilla sama data -> Nähdään selkeämmin aikaerot
        long timeStart = System.nanoTime(); //Alku aika
        int[] tulos = func.apply(copy); //Käytetään kutsussa annettua funktiota. Tallennetaan jotain tulos muuttujaan
        long timeStop = System.nanoTime(); //Loppu aika

        //Näillä käytetään tulosta ja muutetaan kohdetta.
        long sum = 0;
        for (int v : tulos) sum += v;
        kohde += sum; 
        //JIT ja DCE Ymmärrykseen apua AI:lta

        return timeStop - timeStart; //Palautetaan Sorttauksen aika
    }

    public static void main(String[] args) {
        int size = 10000;
        System.out.printf("N arvolla %d%n", size);

        //Random taulu
        int[] data = createRandomData(size); 
        System.out.println("Random taulu tulokset:");
        
        long insertionTime = TimeTest(arr -> {insertionSort(arr);return arr;}, data);
        System.out.println("Insertion sort time: " + insertionTime / 1000000000.0 + " seconds");
        
        long bubbleTime = TimeTest(arr -> {bubbleSort(arr, arr.length); return arr;}, data);
        System.out.println("Bubble sort time: " + bubbleTime / 1000000000.0 + " seconds");

        long quickTime = TimeTest(arr -> {QuickSort(arr, 0, arr.length - 1); return arr;}, data);
        System.out.println("Quick sort time: " + quickTime / 1000000000.0 + " seconds");

        long mergeTime = TimeTest(arr -> {mergeSort(arr, 0, arr.length - 1); return arr;}, data);
        System.out.println("Merge sort time: " + mergeTime / 1000000000.0 + " seconds");

        long shellTime = TimeTest(arr -> {shellSort(arr); return arr;}, data);
        System.out.println("Shell sort time: " + shellTime / 1000000000.0 + " seconds");

        long arraySortTime = TimeTest(arr -> {Arrays.sort(arr); return arr;}, data);
        System.out.println("Array sort time: " + arraySortTime / 1000000000.0 + " seconds");
        System.out.println();
        

        //Nouseva taulu
        int ascend[] = CreateAscendingTable(size);
        System.out.println("Nousevan taulun tulokset");

        long AscinsertionTime = TimeTest(arr -> {insertionSort(arr);return arr;}, ascend);
        System.out.println("Insertion sort time: " + AscinsertionTime / 1000000000.0 + " seconds");
        
        long AscbubbleTime = TimeTest(arr -> {bubbleSort(arr, arr.length); return arr;}, ascend);
        System.out.println("Bubble sort time: " + AscbubbleTime / 1000000000.0 + " seconds");
         
        long AscquickTime = TimeTest(arr -> {QuickSort(arr, 0, arr.length - 1); return arr;}, ascend);
        System.out.println("Quick sort time: " + AscquickTime / 1000000000.0 + " seconds");
        
        long AscmergeTime = TimeTest(arr -> {mergeSort(arr, 0, arr.length - 1); return arr;}, ascend);
        System.out.println("Merge sort time: " + AscmergeTime / 1000000000.0 + " seconds");

        long AscshellTime = TimeTest(arr -> {shellSort(arr); return arr;}, ascend);
        System.out.println("Shell sort time: " + AscshellTime / 1000000000.0 + " seconds");

        long AscarraySortTime = TimeTest(arr -> {Arrays.sort(arr); return arr;}, ascend);
        System.out.println("Array sort time: " + AscarraySortTime / 1000000000.0 + " seconds");
        System.out.println();
        

        //Laskeva taulu
        int Descend[] = CreateDescendingTable(size);
        System.out.println("Laskevan taulun tulokset");

        long DescinsertionTime = TimeTest(arr -> {insertionSort(arr);return arr;}, Descend);
        System.out.println("Insertion sort time: " + DescinsertionTime / 1000000000.0 + " seconds");
        
        long DescbubbleTime = TimeTest(arr -> {bubbleSort(arr, arr.length); return arr;}, Descend);
        System.out.println("Bubble sort time: " + DescbubbleTime / 1000000000.0 + " seconds");
        
        long DescquickTime = TimeTest(arr -> {QuickSort(arr, 0, arr.length - 1); return arr;}, Descend);
        System.out.println("Quick sort time: " + DescquickTime / 1000000000.0 + " seconds");
        
        long DescmergeTime = TimeTest(arr -> {mergeSort(arr, 0, arr.length - 1); return arr;}, Descend);
        System.out.println("Merge sort time: " + DescmergeTime / 1000000000.0 + " seconds");

        long DescshellTime = TimeTest(arr -> {shellSort(arr); return arr;}, Descend);
        System.out.println("Shell sort time: " + DescshellTime / 1000000000.0 + " seconds");

        long DescarraySortTime = TimeTest(arr -> {Arrays.sort(arr); return arr;}, Descend);
        System.out.println("Array sort time: " + DescarraySortTime / 1000000000.0 + " seconds");
        System.out.println();
    }
}