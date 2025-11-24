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

        int inputDigitCount = s.nextInt();

        String inputString = s.next();
        int output7s = 0;
        int output5s = 0;
        int output3s = 0;
        int output2s = 0;
        for(int i = 0; i < inputDigitCount; i++) {
            char currDigit = inputString.charAt(i);
            switch(currDigit) {
                case '0':
                case '1':
                    continue;
                case '2':
                    output2s++;
                    break;
                case '3':
                    output3s++;
                    break;
                case '4':
                    output3s++;
                    output2s += 2;
                    break;
                case '5':
                    output5s++;
                    break;
                case '6':
                    output5s++;
                    output3s++;
                    break;
                case '7':
                    output7s++;
                    break;
                case '8':
                    output7s++;
                    output2s += 3;
                    break;
                case '9':
                    output7s++;
                    output3s += 2;
                    output2s++;
                    break;
            }
        }
        StringBuilder result = new StringBuilder(output2s + output3s + output5s + output7s);
        for (int freq7s = 0; freq7s < output7s; freq7s++)
        {
            result.append(7);
        }
        for (int freq5s = 0; freq5s < output5s; freq5s++)
        {
            result.append(5);
        }
        for (int freq3s = 0; freq3s < output3s; freq3s++)
        {
            result.append(3);
        }
        for (int freq2s = 0; freq2s < output2s; freq2s++)
        {
            result.append(2);
        }
        out.println(result);
        out.close();
    }
}
