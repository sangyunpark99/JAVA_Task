import java.util.Random;
import java.util.Scanner;

public class 주민등록번호생성프로그램 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String birthYear = sc.next();
        System.out.print("출생월을 입력해 주세요.(mm):");
        String birthMonth = sc.next();
        System.out.print("출생일을 입력해 주세요(dd):");
        String birthDay = sc.next();
        System.out.print("성별을 입력해 주세요(m/f):");
        String sex = sc.next();

        System.out.println(getRegistrationNumber(birthYear, birthMonth, birthDay, sex));
    }

    public static String getRegistrationNumber(String birthYear, String birthMonth, String birthDay, String sex){
        // 남자 3, 여자 4
        String registrationNumber = "";

        registrationNumber += birthYear.substring(2,4) + birthMonth + birthDay + "-";

        if(sex.equals("m")){
            registrationNumber += "3";
        }else{
            registrationNumber += "4";
        }

        registrationNumber += getRandomNum();

        return registrationNumber;
    }

    public static String getRandomNum(){

        String backNum = "";

        Random random = new Random();
        backNum = String.valueOf(random.nextInt(999999) + 1);

        return backNum;
    }
}
