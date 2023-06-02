import java.util.Calendar;
import java.util.Scanner;

public class 달력출력프로그램 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        getCalendar(year,month);
    }

    public static void getCalendar(int year, int month) {
        Calendar cal = Calendar.getInstance();

        System.out.printf("[%d년 %02d월]", year,month);
        System.out.println();
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        cal.set(year,month-1,1);

        int startDay = cal.get(Calendar.DAY_OF_WEEK); // 각 요일을 숫자로 표현

        for (int i = 1; i < startDay; i++) { // 시작요일 이전까지
            System.out.print('\t');
        }

        for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
            System.out.printf("%02d\t",i);
            if(startDay % 7 == 0){
                System.out.println();
            }
            startDay++;
        }
    }
}


