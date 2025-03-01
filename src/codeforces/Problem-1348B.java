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
            int n = s.nextInt();
            int k = s.nextInt();
            Set<Integer> uniqueValues = new HashSet<>();
            int kValuesCount = 0;

            for(int i = 0; i < n; i++) {
                int a = s.nextInt();
                if(uniqueValues.size() <= k) {
                    uniqueValues.add(a);
                    kValuesCount++;
                }
            }
            if(uniqueValues.size() > k) {
                out.println(-1);
            } else {
                out.println(kValuesCount * k);
                StringBuilder uniqueValuesString = new StringBuilder();
                for(int value : uniqueValues) {
                    uniqueValuesString.append(value + " ");
                }
                int paddingValue = (int) uniqueValues.toArray()[0];
                for(int i = uniqueValues.size(); i < k; i++) {
                    uniqueValuesString.append(paddingValue + " ");
                }
                uniqueValuesString.deleteCharAt(uniqueValuesString.length()-1);
                out.print(uniqueValuesString);
                for(int i = 1; i < kValuesCount; i++) {
                    out.print(" " + uniqueValuesString);
                }
                out.println();
            }
        }
        out.close();
    }
}
