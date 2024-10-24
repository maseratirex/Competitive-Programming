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

        /*
         * 1. Count frequencies of groups of size 1, 2, 3, and 4
         * 2. Then form cars of 3's and 1's
         * 3. Then form cars of 3's with remaining 3's
         * 4. Then form cars of 2's and 1's
         * 5. Then form cars of 2's and 2's with remaining 2's
         * 6. Then form cars of 1's and 1's with remaining 1's
         * 7. Then form cars of 4's
         */

        int n = s.nextInt();
        int[] frequencies = { 0, 0, 0, 0 };
        for(int i = 0; i < n; i++) {
            frequencies[s.nextInt()-1]++;
        }
        int total_taxis = 0;
        if(frequencies[0] <= frequencies[2]) {
            // All 1's and 3's are consumed
            frequencies[0] = 0;
            total_taxis += frequencies[2];
        } else {
            // All 3's are consumed, 1's remain
            total_taxis += frequencies[2];
            frequencies[0] -= frequencies[2];
        }
        int cars_of_1_and_2 = (int) Math.ceil(frequencies[0]/2.0);
        if(cars_of_1_and_2 <= frequencies[1]) {
            // All 1's are consumed, then consume leftover 2's
            total_taxis += cars_of_1_and_2;
            frequencies[1] -= cars_of_1_and_2;
            int cars_of_2 = (int) Math.ceil(frequencies[1]/2.0);
            total_taxis += cars_of_2;
        } else {
            // All 2's are consumed, then consume leftover 1's
            total_taxis += frequencies[1];
            frequencies[0] -= 2 * frequencies[1];
            int cars_of_1 = (int) Math.ceil(frequencies[0]/4.0);
            total_taxis += cars_of_1;
        }
        total_taxis += frequencies[3];
        out.println(total_taxis);
        out.close();
    }
}
