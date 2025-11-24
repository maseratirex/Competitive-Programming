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

        int testCases = s.nextInt();
        for(int testCase = 0; testCase < testCases; testCase++) {
            int n = s.nextInt();
            int numbers[] = new int[n];
            Map<Integer, Integer> counts = new HashMap<>();
            for(int i = 0; i < n; i++) {
                numbers[i] = s.nextInt();
                counts.put(numbers[i], 1 + counts.getOrDefault(numbers[i], 0));
            }
            if(counts.size() == n) {
                out.println("1 " + n);
                continue;
            }
            int minL = 0;
            int maxR = -1;
            for(int l = 0, r = 0; l < n && r < n; r++) {
                if(counts.get(numbers[r]) > 1) {
                    l = r + 1;
                } else {
                    // Added a distinct
                    if(maxR - minL < r - l) {
                        minL = l;
                        maxR = r;
                    }
                }
            }
            minL++;
            maxR++;
            if(maxR == 0) {
                out.println(0);
            } else {
                out.println(minL + " " + maxR);
            }
        }
        out.close();
    }
}
