import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair> {
        final int left;
        final int right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
        public int compareTo(Pair p) {
            return left == p.left ? right - p.right : left - p.left;
        }

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader s = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int numExams = s.nextInt();
        Pair[] datePairs = new Pair[numExams];
        for(int exam = 0; exam < numExams; exam++) {
            datePairs[exam] = new Pair(s.nextInt(), s.nextInt());
        }
        Arrays.sort(datePairs);
        int minDate = 0;
        for(Pair datePair : datePairs) {
            if(datePair.right < minDate) {
                minDate = datePair.left;
            } else {
                minDate = datePair.right;
            }
        }
        out.println(minDate);
        out.close();
    }
}
