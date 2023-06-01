public class 구구단 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%02d x %02d = %02d     ", j,i,i*j);
            }
            System.out.println();
        }
    }
}
