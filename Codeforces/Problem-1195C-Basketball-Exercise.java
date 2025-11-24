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
        int numStudentsPerRow = s.nextInt();
        int studentHeights[][] = new int[2][numStudentsPerRow];
        for(int col = 0; col < numStudentsPerRow; col++) {
            studentHeights[0][col] = s.nextInt();
        }
        for(int col = 0; col < numStudentsPerRow; col++) {
            studentHeights[1][col] = s.nextInt();
        }
        // dp[i][j] is the maximum overall height if you use the student in the i-th row and j-th column
        long dp[][] = new long[2][numStudentsPerRow+2];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = 0;
        for(int col = 2; col <= numStudentsPerRow+1; col++) {
            dp[0][col] = studentHeights[0][col-2] + Math.max(dp[1][col-1], Math.max(dp[0][col-2], dp[1][col-2]));
            dp[1][col] = studentHeights[1][col-2] + Math.max(dp[0][col-1], Math.max(dp[0][col-2], dp[1][col-2]));
        }
        out.println(Math.max(Math.max(dp[0][numStudentsPerRow], dp[1][numStudentsPerRow]), Math.max(dp[0][numStudentsPerRow+1], dp[1][numStudentsPerRow+1])));
        out.close();
    }
}
