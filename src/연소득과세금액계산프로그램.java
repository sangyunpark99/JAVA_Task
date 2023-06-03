import java.util.Scanner;

public class 연소득과세금액계산프로그램 {

    private static final int[] TAX_RANGES = { 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
    private static final double[] TAX_RATES = { 0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42, 0.45 };

    private static final int[] PUBLIC_TAX = {1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        int annualIncome = sc.nextInt();

        taxAccount(annualIncome);
        deductionAccount(annualIncome);
    }

    public static void taxAccount(int annualIncome){ // 세율에 의한 세금

        double tax = 0;
        int lowerBound = 0;

        for (int i = 0; i < TAX_RANGES.length; i++) {
            if (annualIncome > TAX_RANGES[i]) {
                tax += (TAX_RANGES[i] - lowerBound) * TAX_RATES[i];
                System.out.printf("%10d * %2.0f%% = %10d%n", (TAX_RANGES[i] - lowerBound), TAX_RATES[i] * 100, (int) ((TAX_RANGES[i] - lowerBound) * TAX_RATES[i]));
                lowerBound = TAX_RANGES[i];
            } else {
                tax += (annualIncome - lowerBound) * TAX_RATES[i];
                System.out.printf("%10d * %2.0f%% = %10d%n", (annualIncome - lowerBound), TAX_RATES[i] * 100, (int) ((annualIncome - lowerBound) * TAX_RATES[i]));
                break;
            }
        }
        System.out.println();
        System.out.print("[세율에 의한 세금]:");
        System.out.printf("%18d",(int)tax);
    }

    public static void deductionAccount(int annualIncome){ // 누직공제계산에 의한 세금
        double tax = 0;
        int taxIndex = 0;

        for (int i = 0; i < TAX_RANGES.length; i++) { // 어느 구간인지 선정하기
            if(annualIncome < TAX_RANGES[i]){
                taxIndex = i;
                break;
            }
        }

        tax = annualIncome*TAX_RATES[taxIndex] - PUBLIC_TAX[taxIndex>0?taxIndex-1 : taxIndex];
        System.out.println();
        System.out.print("[누진공세에 의한 세금]:");
        System.out.printf("%15d",(int)(Math.round(tax)));
    }
}
