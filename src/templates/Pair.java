public class Pair implements Comparable<Pair> {
    final int left;
    final int right;
    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
    public int compareTo(Pair p) {
        return left == p.left ? right - p.right : left - p.left;
    }
}
