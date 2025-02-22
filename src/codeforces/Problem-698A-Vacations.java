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

        int numberDays = s.nextInt();
        int minRestIfDayJ[][] = new int[numberDays+1][3];
        minRestIfDayJ[0][0] = 0;
        minRestIfDayJ[0][1] = 0;
        minRestIfDayJ[0][2] = 0;
        for(int i = 1; i <= numberDays; i++) {
            int activityOfDay = s.nextInt();
            minRestIfDayJ[i][0] = 1 + Math.min(Math.min(minRestIfDayJ[i-1][0], minRestIfDayJ[i-1][1]), minRestIfDayJ[i-1][2]);
            if(activityOfDay == 0) {
                minRestIfDayJ[i][1] = Integer.MAX_VALUE;
                minRestIfDayJ[i][2] = Integer.MAX_VALUE;
            } else if(activityOfDay == 1) {
                minRestIfDayJ[i][1] = Math.min(1 + Math.min(minRestIfDayJ[i-1][0]-1, minRestIfDayJ[i-1][1]), minRestIfDayJ[i-1][2]);
                minRestIfDayJ[i][2] = Integer.MAX_VALUE;
            } else if(activityOfDay == 2) {
                minRestIfDayJ[i][2] = 1 + Math.min(Math.min(minRestIfDayJ[i-1][0], minRestIfDayJ[i-1][1])-1, minRestIfDayJ[i-1][2]);
                minRestIfDayJ[i][1] = Integer.MAX_VALUE;
            } else {
                minRestIfDayJ[i][2] = 1 + Math.min(Math.min(minRestIfDayJ[i-1][0], minRestIfDayJ[i-1][1])-1, minRestIfDayJ[i-1][2]);
                minRestIfDayJ[i][1] = Math.min(1 + Math.min(minRestIfDayJ[i-1][0]-1, minRestIfDayJ[i-1][1]), minRestIfDayJ[i-1][2]);
            }
        }
        out.println(Math.min(Math.min(minRestIfDayJ[numberDays][0], minRestIfDayJ[numberDays][1]), minRestIfDayJ[numberDays][2]));
        out.close();
    }
}
