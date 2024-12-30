import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * 이중 우선순위 큐 구현 클래스
 * TreeMap을 활용하여 최대값과 최소값을 O(logN) 시간에 찾을 수 있도록 구현
 */
public class Main {
    // 입력을 효율적으로 처리하기 위한 BufferedReader
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 결과를 저장할 StringBuilder
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCases = readInt(); 

        while (testCases-- > 0) {
            processTestCase();
        }

        // 최종 결과 출력
        System.out.println(sb);
    }

    /**
     * 각 테스트 케이스를 처리하는 메소드
     */
    private static void processTestCase() throws IOException {
        int operations = readInt();  // 연산의 개수
        TreeMap<Integer, Integer> queue = new TreeMap<>();  // 정렬된 맵으로 우선순위 큐 구현

        while (operations-- > 0) {
            // 명령어 라인을 문자 배열로 읽어 처리
            char[] cmd = br.readLine().toCharArray();
            // 명령어와 값을 분리
            int value = parseIntFromCharArray(cmd, 2);  // 공백 이후의 숫자를 파싱

            if (cmd[0] == 'I') {
                // 삽입 연산: 현재 값의 개수를 1 증가
                insertValue(queue, value);
            } else {
                // 삭제 연산: 최대값(1) 또는 최소값(-1) 삭제
                if (!queue.isEmpty()) {
                    deleteValue(queue, value == 1);
                }
            }
        }

        // 결과 기록
        appendResult(queue);
    }

    /**
     * TreeMap에 값을 삽입하는 메소드
     * @param queue 대상 TreeMap
     * @param value 삽입할 값
     */
    private static void insertValue(TreeMap<Integer, Integer> queue, int value) {
        queue.merge(value, 1, Integer::sum);
    }

    /**
     * TreeMap에서 값을 삭제하는 메소드
     * @param queue 대상 TreeMap
     * @param isMax true면 최대값, false면 최소값 삭제
     */
    private static void deleteValue(TreeMap<Integer, Integer> queue, boolean isMax) {
        int key = isMax ? queue.lastKey() : queue.firstKey();
        int count = queue.get(key);
        
        if (count == 1) {
            queue.remove(key);
        } else {
            queue.put(key, count - 1);
        }
    }

    /**
     * 결과를 StringBuilder에 추가하는 메소드
     * @param queue 결과를 추출할 TreeMap
     */
    private static void appendResult(TreeMap<Integer, Integer> queue) {
        if (queue.isEmpty()) {
            sb.append("EMPTY\n");
        } else {
            sb.append(queue.lastKey()).append(' ').append(queue.firstKey()).append('\n');
        }
    }

    /**
     * 문자 배열에서 정수를 파싱하는 메소드
     * @param arr 대상 문자 배열
     * @param startIdx 시작 인덱스
     * @return 파싱된 정수값
     */
    private static int parseIntFromCharArray(char[] arr, int startIdx) {
        int result = 0;
        boolean isNegative = false;
        
        if (arr[startIdx] == '-') {
            isNegative = true;
            startIdx++;
        }
        
        for (int i = startIdx; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                result = result * 10 + (arr[i] - '0');
            }
        }
        
        return isNegative ? -result : result;
    }

    /**
     * BufferedReader에서 정수를 읽는 메소드
     */
    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}