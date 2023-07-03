public class Tower {
    public static void hanio(int n, int pos1, int pos2, int pos3) {
        if (n == 1) {
            System.out.printf("%d -> %d\n", pos1, pos3);
        } else {
            hanio(n - 1, pos1, pos3, pos2);
            System.out.printf("%d -> %d\n", pos1, pos3);
    
            hanio(n - 1, pos2, pos1, pos3);
        }
    }
    
    public static void main(String[] args) throws Exception {
        hanio(3,1,2,3);
    }
    }