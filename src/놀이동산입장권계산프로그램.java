import java.util.Scanner;

public class 놀이동산입장권계산프로그램 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age  = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요(숫자입력):");
        int enterTime = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String nationalMerit = sc.next();
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String welfareCard = sc.next();

        int entranceFee = calculateEntranceFee(age, enterTime, nationalMerit, welfareCard);

        System.out.printf("입장료 : " + entranceFee);
    }

    public static int calculateEntranceFee(int age, int enterTime, String nationMerit, String welfareCard){
        int entranceFee = 10000;

        if(age < 3){ // 무료
            entranceFee = 0;
            return entranceFee;
        }

        if(age < 13){ // 특별 할인
            entranceFee = 4000;
            return entranceFee;
        }

        if(enterTime >= 17){ // 특별 할일
            entranceFee = 4000;
            return entranceFee;
        }

        if(nationMerit.equals("y") || welfareCard.equals("y")){ // 일반 할인
            entranceFee = 8000;
            return entranceFee;
        }

        return entranceFee;
    }
}
