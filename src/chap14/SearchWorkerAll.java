package chap14;

public class SearchWorkerAll implements Runnable {
    private int i;
    private int j;
    private int needle;
    private int haystack[];
    private int[] result = new int[0];

    public SearchWorkerAll(int i, int j, int needle, int haystack[]) {
        this.i = i;
        this.j = j;
        this.needle = needle;
        this.haystack = haystack;
    }

    public int[] searchHelper(int i, int j, int needle, int haystack[]) {
        int[] result = new int[0];
        for (int k=i; k<j; k++) {
            if (needle == haystack[k]) {
                int[] tempresult = new int[result.length + 1];
                for(int n = 0; n < result.length; n++){
                    tempresult[n] = result[n];
                }
                result = tempresult;
                result[result.length - 1] = k;
            }
        }
        return result;
    }

    public void run() {
        result = searchHelper(i, j, needle, haystack);
    }

    public int[] getResult() {
        return result;
    }
}
