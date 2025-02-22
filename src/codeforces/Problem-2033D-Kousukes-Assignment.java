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

        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int total_beautiful_segments = 0;
            int[] running_sums = new int[n];
            int l = 0;
            for(int i = 0; i < n; i++) {
                int element = s.nextInt();
                for(int j = l; j <= i; j++) {
                    running_sums[j] += element;
                    if(running_sums[j] == 0) {
                        l = i + 1;
                        total_beautiful_segments++;
                    }
                }
            }
            out.println(total_beautiful_segments);
        }
        out.close();
    }
}