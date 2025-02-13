import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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

        int testCases = s.nextInt();
        while(testCases-- > 0) {
            int number = s.nextInt();
            if(number < 11) {
                out.println("NO");
                continue;
            }
            if(number >= 1110) {
                out.println("YES");
                continue;
            }
            int remainder = number % 11;
            if(remainder <= number/111) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();
    }
}