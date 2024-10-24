// https://codeforces.com/problemset/problem/479/A
import java.io.*;
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

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        /*
         * Cases
         * a + b + c
         * (a + b) * c
         * a * (b + c)
         * a * b * c
         */
        if(a == 1 && c == 1) {
            out.println(b + 2);
        } else {
            out.println(Math.max((a + b) * c, Math.max(a * b * c, a * (b + c))));
        }
        out.close();
    }
}
