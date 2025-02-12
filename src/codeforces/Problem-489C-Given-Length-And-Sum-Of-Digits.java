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

        int numDigits = s.nextInt();
        int sum = s.nextInt();
        if(numDigits == 1) {
            if(sum <= 9 * numDigits) {
                out.println(String.valueOf(sum) + " " + String.valueOf(sum));
            } else {
                out.println("-1 -1");
            }
        } else {
            if(1 <= sum && sum <= 9 * numDigits) {
                // Start by calculating the minimum
                String minimum = "";
                int remainingMinimumSum = sum;
                // Maximize all the right-most digits from right to left
                for(int right = numDigits; right > 1; right--) {
                    if(remainingMinimumSum >= 10) {
                        remainingMinimumSum -= 9;
                        minimum = "9" + minimum;
                    } else {
                        minimum = String.valueOf(remainingMinimumSum - 1) + minimum;
                        remainingMinimumSum = 1;
                    }
                }
                // The left-most digit is minimized
                minimum = String.valueOf(remainingMinimumSum) + minimum;

                // Now calculate the maximum
                String maximum = "";
                int remainingMaximumSum = sum;
                // Maximize all the left-most digits from left to right
                for(int left = 1; left <= numDigits; left++) {
                    if(remainingMaximumSum >= 9) {
                        remainingMaximumSum -= 9;
                        maximum = maximum + "9";
                    } else {
                        maximum = maximum + String.valueOf(remainingMaximumSum);
                        remainingMaximumSum = 0;
                    }
                }

                out.println(minimum + " " + maximum);
            } else {
                out.println("-1 -1");
            }
        }
        out.close();
    }
}