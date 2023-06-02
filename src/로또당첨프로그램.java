import java.util.*;

public class 로또당첨프로그램 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[로또 당첨 프로그램]");
        System.out.println();
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int lottoNum = sc.nextInt();

        ArrayList<HashSet> eachLottos = getLottoNum(lottoNum);

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 로또 출력시 필요한 알파벳

        for (int i = 0; i < lottoNum; i++) { // 로또 출력하기
            System.out.printf("%c\t",alphabet.charAt(i));
            showEachLotto(eachLottos.get(i));
            System.out.println();
        }

        System.out.println();
        System.out.println("[로또 발표]");

        ArrayList<HashSet> resultLotto = getLottoNum(1);
        ArrayList<Integer> sortedResultLotto = new ArrayList<>(resultLotto.get(0));

        Collections.sort(sortedResultLotto); // 번호 정렬

        System.out.print("\t");
        for (int i = 0; i < sortedResultLotto.size(); i++) { // 로또 발표 출력
            System.out.printf("%02d", sortedResultLotto.get(i));
            if(i!=sortedResultLotto.size()-1){
                System.out.print(",");
            }
        }

        showLottoResult(lottoNum,eachLottos,sortedResultLotto, alphabet);
    }

    public static ArrayList<HashSet> getLottoNum(int lottoNum){ // 랜덤한 로또 번호 받기

        Random random = new Random();

        ArrayList<HashSet> eachLotto = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            HashSet<Integer> lotto = new HashSet<>();
            for (int j = 0; lotto.size() < 5; j++) { // 중복되는 숫자 제거
                lotto.add(random.nextInt(1,46));
            }
            eachLotto.add(lotto);
        }

        return eachLotto;
    }

    public static void showEachLotto(HashSet eachLotto){ // 랜덤한 로또 번호 결과 보여주기

        ArrayList<Integer> sortedLotto = new ArrayList<>(eachLotto);
        Collections.sort(sortedLotto); // 로또 정렬

        for (int i = 0; i < sortedLotto.size(); i++) {
            System.out.printf("%02d", sortedLotto.get(i));
            if(i != sortedLotto.size()-1){
                System.out.print(",");
            }
        }
    }

    public static void showLottoResult(int lottoNum, ArrayList<HashSet> myLotto, ArrayList<Integer> resultLotto, String alphabet){ // 같은 값이 존재하는지 찾기

        System.out.println();
        System.out.println();
        System.out.println("[내 로또 결과]");

        HashMap<String,Integer> result = new HashMap<>();

        for (int i = 0; i < lottoNum; i++) {
            int sameNum = findLottoNum(myLotto.get(i), resultLotto);
            result.put(String.valueOf(alphabet.charAt(i)),sameNum);
        }

        for (int i = 0; i < lottoNum; i++) {

            System.out.printf("%S   ",alphabet.charAt(i));
            showEachLotto(myLotto.get(i));
            System.out.printf(" => %d개 일치", result.get(String.valueOf(alphabet.charAt(i))));
            System.out.println();
        }

    }

    public static int findLottoNum(HashSet myLotto, ArrayList<Integer> resultLotto){
        int sameValue = 0;

        ArrayList<Integer> myLottoList = new ArrayList<>(myLotto);

        for (int i = 0; i < myLotto.size(); i++) {
            for (int j = 0; j < myLotto.size(); j++) {
                if(myLottoList.get(i) == resultLotto.get(j)){ // 같은게 있는 경우
                    sameValue++;
                }
            }
        }

        return sameValue;
    }
}
