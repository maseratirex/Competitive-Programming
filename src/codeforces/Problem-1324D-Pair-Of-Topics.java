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

        int numTopics = s.nextInt();
        int[] topicDifferences = new int[numTopics];
        for(int topic = 0; topic < numTopics; topic++) {
            topicDifferences[topic] += s.nextInt();
        }
        for(int topic = 0; topic < numTopics; topic++) {
            topicDifferences[topic] -= s.nextInt();
        }
        Arrays.sort(topicDifferences);
        long numGoodTopicPairs = 0;
        for(int l = 0, r = numTopics-1; l < r; ) {
            if(topicDifferences[l] + topicDifferences[r] > 0) {
                // All pairs of topics (i, r) are good for l <= i < r
                numGoodTopicPairs += r - l;
                r--;
            } else {
                l++;
            }
        }
        out.println(numGoodTopicPairs);
        out.close();
    }
}