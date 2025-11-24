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
            int numNumbers = s.nextInt();
            int x = s.nextInt();
            int numbersOR = 0;
            int numbers[] = new int[numNumbers];
            int number;
            for (number = 0; number < numNumbers && number <= x; number++) {
                if (((numbersOR | number) & ~x) > 0) {
                    for (; number < numNumbers; number++) {
                        numbers[number] = 0;
                    }
                } else {
                    numbersOR |= number;
                    numbers[number] = number;
                }
            }
            if (numbersOR != x) {
                numbers[numNumbers - 1] = x;
            }
            out.print(numbers[0]);
            for (int numberIndex = 1; numberIndex < numNumbers; numberIndex++) {
                out.print(" " + numbers[numberIndex]);
            }
            out.println();
        }
        out.close();
    }
}
