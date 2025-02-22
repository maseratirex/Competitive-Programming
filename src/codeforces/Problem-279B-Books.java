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

        int numBooks = s.nextInt();
        int timeAvailable = s.nextInt();
        int bookLengths[] = new int[numBooks];

        for(int i = 0; i < numBooks; i++) {
            bookLengths[i] = s.nextInt();
        }

        int maxBooksReadable = 0;
        int lengthBooksInWindow = 0;
        for(int left = 0, right = 0; right < numBooks; right++) {
            lengthBooksInWindow += bookLengths[right];
            while(lengthBooksInWindow > timeAvailable) {
                // Remove left-most book length
                lengthBooksInWindow -= bookLengths[left];
                // Remove left-most book from window
                left++;
            }
            maxBooksReadable = Math.max(maxBooksReadable, right - left + 1);
        }
        out.println(maxBooksReadable);
        out.close();
    }
}
