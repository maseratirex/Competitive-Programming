import java.io.*;
import java.util.*;

public class Main {
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

        int n = s.nextInt();
        int m = s.nextInt();
        out.println(minNumClicks(n,m));
        out.close();
    }
    public static int minNumClicks(int n, int m) {
        if(n < m) {
            if(m % 2 == 1) {
                // If m is odd, add 1
                // m + 1 = 2k for some k
                // Now the goal is to get to k from n.
                return 2 + minNumClicks(n, (m+1)/2);
            } else {
                return 1 + minNumClicks(n, m/2);
            }
        } else if(n > m) {
            return n-m;
        } else return 0;
    }
}
