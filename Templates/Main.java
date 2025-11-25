import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(boolean useStandardInput) throws FileNotFoundException {
             br = useStandardInput ? new BufferedReader(new InputStreamReader(System.in))
                     : new BufferedReader(new FileReader("in.txt"));
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
        boolean useStandardInputOutput = true;
        FastReader s = new FastReader(useStandardInputOutput);
        PrintWriter out = new PrintWriter(useStandardInputOutput ? new OutputStreamWriter(System.out) : new FileWriter("out.txt"));
        int numTestCases = s.nextInt();
        for(int testCase = 0; testCase < numTestCases; testCase++) {
        }
        out.close();
    }
}
