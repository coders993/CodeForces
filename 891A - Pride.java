import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {
    static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n=sc.nextInt();
        int[] arr=new int[n];
        int ones=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if(arr[i]==1)ones++;
        }
        if(ones>0){
            System.out.println(n-ones);
            return;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int x=arr[i];
            int  j=i+1;
            for(;j<n;j++){
                x=gcd(x,arr[j]);
                if(x==1)break;
            }
            if(x==1)min=Math.min(min,j-i);
        }
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min+n-1);
    }
    static int gcd(int a,int b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
