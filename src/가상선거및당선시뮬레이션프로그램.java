import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class 가상선거및당선시뮬레이션프로그램 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("총 진행할 투표수를 입력해 주세요.");
        int totalVote = sc.nextInt();
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요.");
        int people = sc.nextInt();

        HashMap<String,Integer> candidates = new HashMap<>();

        for (int i = 0; i < people; i++) { // 후보자 추가
            System.out.printf("%d 번째 후보자이름을 입력해 주세요.", i+1);
            candidates.put(sc.next(),0); // 이름, 투표수
        }

        startVote(candidates,totalVote); // 투표 시작

    }

    public static void startVote(HashMap<String, Integer> candidates, int totalVote){

        int currentVote = 0;

        while(currentVote < totalVote){

            currentVote++;

            float voteProgress = (float)currentVote/totalVote*100;

            int randomIndex = new Random().nextInt(candidates.size());


            ArrayList<String> candidatesList = new ArrayList<>(candidates.keySet());
            String selectedName = candidatesList.get(randomIndex);
            System.out.println();
            System.out.printf("[투표진행률]: %.2f%%, %d명 투표 => %s", voteProgress, currentVote, selectedName);
            System.out.println();

            int beforeVoteNum = candidates.get(selectedName);
            candidates.replace(selectedName,++beforeVoteNum);

            int candidateNum = 1;
            for (String candidate : candidates.keySet()) {

                float eachVotePercent = (float)candidates.get(candidate)/totalVote * 100;
                System.out.printf("[기호:%d] %s:  %.2f%%  (투표수:%d)", candidateNum, candidate, eachVotePercent, candidates.get(candidate));
                System.out.println();
                candidateNum++;
            }
        }

        findElectedPerson(candidates);
    }

    public static void findElectedPerson(HashMap<String,Integer> candidates){

        int voteNum = -9999;
        String electedPerson = "";
        int maxCandidateCount = 0;

        for (String candidate : candidates.keySet()) {

            int candidateVoteNum = candidates.get(candidate);

            if(voteNum == maxCandidateCount){ // 동률일 겨우
                maxCandidateCount++;
            }

            if(voteNum < candidateVoteNum){
                electedPerson = candidate;
                voteNum = candidateVoteNum;
                maxCandidateCount = 1;
            }
        }

        if(maxCandidateCount > 1){
            System.out.println();
            System.out.println("동률입니다! 재투표 해주세요");
        }else{
            System.out.println();
            System.out.printf("[투표결과] 당선인 : %s",electedPerson);
        }
    }
}
