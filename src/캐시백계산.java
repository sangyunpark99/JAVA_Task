import java.util.Scanner;

public class 캐시백계산 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        Scanner sc = new Scanner(System.in);
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int money = sc.nextInt();

        calculatePayBack(money);
    }

    public static void calculatePayBack(int money){
        int payBack = money / 10;

        if(payBack > 300){ // 300원 이상인 경우
            payBack = 300;
        }else { // 그 아래인 경우 - 십의자리 제거
           payBack = (payBack/100) * 100;
        }

        System.out.printf("결제 금액은 %s원이고, 캐시백은 %d원 입니다.",money,payBack);
    }
}
