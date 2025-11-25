public class BitwiseOperations {
    public static int getPositionOfRightmostUnsetBit(int x) {
        if((x & (x+1)) == 0) {
            return -1;
        }
        return getPositionOfRightmostSetBit(~x);
    }
    public static int getPositionOfRightmostSetBit(int x) {
        return (int) ( Math.log(x & -x) / Math.log(2));
    }
    public static int getNearestPowerOfTwo(int x) {
        x--;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        x++;
        return x;
    }
}
