import java.util.*;
import java.util.stream.Collectors;


public class Main {
    private static class Node {
        private int data;
        private Node left;
        private Node right;
    }

    private static class BinarySearchTree {
        public boolean isBST(Node head) {
            if (head == null) {
                return true;
            }
            if ((head.right == null || head.data < head.right.data) && (head.left == null || head.data > head.left.data)) {
                return isBST(head.right) && isBST(head.left);
            } else {
                return false;
            }
        }

    }

    private static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap();
        for (char c : a.toCharArray()) {
            int value = map.get(c) == null? 1 : map.get(c) + 1;
            map.put(c, value);
        }

        for (char c : b.toCharArray()) {
            int value = map.get(c) == null? -1 : map.get(c) -1;
            map.put(c, value);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            count += Math.abs(entry.getValue());
        }
        return count;
    }

    

    public static void main(String[] args) {
//        System.out.println(permute(new int[]{1, 2, 3}));

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = List.of(1, 2, 3);
        List<Integer> list3 = new ArrayList<>(){{
            list3.add(1)
        }};

        Map<Integer, Integer> map = new HashMap<>(){{
            map.put(1, 3);
        }};
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = null;
        for (int num : nums) {
            result = combine(result, nums);
        }
        return result;
    }

    private static List<List<Integer>> combine(List<List<Integer>> result, int[] nums) {
        if (result == null) {
            result = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i != j) {
                        System.out.println(Arrays.asList(nums[j]));
                        result.add(Arrays.asList(nums[j]));
                    }
                }
            }
        } else {
            for (List<Integer> list : result) {
                for (int num : nums) {
                    if (!list.contains(Integer.valueOf(num))) {
                        list.add(Integer.valueOf(num));
                    }
                }
            }
        }
        return result;

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String s : tokens) {
            if (isOperator(s)) {
                stack.push(cal(stack.pop(), s, stack.pop()));
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String o) {
        if ("+-*/".contains(o)) {
            return true;
        }
        return false;
    }

    private static int cal(int num1, String operator, int num2) {
        switch(operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
        }
        return 0;
    }
    public static String longestPalindrome(String s) {
        int max = 1, start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean flag = true;
                for (int k = 0; k < (j - i + 1)/2; k++) {
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        flag = false;
                    }
                }
                if (flag && j - i + 1 > max) {
                    start = i;
                    max = j - i + 1;
                }
            }
        }

        return s.substring(start, max - start );
    }

    public static void merge(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap();
        label:
        for (int[] interval : intervals) {
            if (map.isEmpty()) {
                map.put(interval[0], interval[1]);
            } else {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (interval[0] >= entry.getKey() && interval[0] <= entry.getValue()) {

                        int min = Math.min(entry.getKey(), interval[0]);
                        int max = Math.max(entry.getValue(), interval[1]);
                        map.remove(entry.getKey());
                        map.replace(min, max);

                        continue label;
                    }
                }
                map.put(interval[0], interval[1]);
            }
        }
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }


    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList();
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<Integer, Long> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<Integer, Long> entry : sortedMap.entrySet()) {
            result.add(entry.getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> oldSets = new ArrayList();
        oldSets.add(new ArrayList());
        for (int num : nums) {
            List<List<Integer>> sets = oldSets;
            Iterator<List<Integer>> iterator = sets.iterator();
            while (iterator.hasNext()) {
                List<Integer> set = iterator.next();
                List<Integer> list = new ArrayList();
                list.add(num);
                for (int s : set) {
                    list.add(s);
                }
                oldSets.add(list);
            }
        }
        return oldSets;
    }

        public static int trailingZeroes(int n) {
            String value = String.valueOf(factorial(n));
            System.out.println(value);
            int count = 0;
            for (int i = value.length()-1; i >= 0; i--) {

                if (value.charAt(i) == '0') {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

    private static long factorial(int n) {
        if (n <= 2) {
            return 2;
        }

        return n * factorial(n - 1);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int result = 0;
        
        for (int i = coins.length - 1; i >= 0; i--) {
            result += amount / coins[i];
            amount %= coins[i];
        }
        return amount == 0? result : -1;
    }

    private static List<Integer> insertElements(List<Integer> list, int element) {
        int low = 0;
        int high = list.size();
        while(low < high) {
            int mid = (low + high) / 2;
            if(list.get(mid) < element) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        list.add(low, element);
        return list;
    }

    private static void printResult(List<Integer> list){
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static boolean stoneGame(int[] piles) {
        int alexTotalStones = 0;
        int leeTotalStones = 0;
        Deque<Integer> deque = new LinkedList();
        for(int pile : piles) {
            deque.push(pile);
        }

        boolean alexTurn = true;
        while(deque.size() > 0) {
            int nextPile = deque.peekFirst().intValue() > deque.peekLast().intValue()? deque.pollFirst().intValue() : deque.pollLast().intValue();
            if(alexTurn) {
                alexTotalStones += nextPile;
                alexTurn = false;
            } else {
                leeTotalStones += nextPile;
                alexTurn = true;
            }
        }

        if(alexTotalStones > leeTotalStones) {
            return true;
        } else {
            return false;
        }
    }


    public static int countConsistentStrings(String allowed, String[] words) {
        return (int) Arrays.asList(words)
                .stream()
                .filter(word -> isConsistentStrings(allowed, word))
                .count();
    }

    private static boolean isConsistentStrings(String allowed, String word) {
        for (char c : allowed.toCharArray()) {
            word.replaceAll("a", "");
        }
        return word.trim().length() == 0;
    }

        /* Node
        public static Node insert(Node root, int data) {
            if(root == null) {
                return new Node(data);
            } else {
                Node cur;
                if(data <= root.data) {
                    cur = insert(root.left, data);
                    root.left = cur;
                } else {
                    cur = insert(root.right, data);
                    root.right = cur;
                }
                return root;
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            Node root = null;
            while(t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            levelOrder(root);
        } */

    private static final Scanner scanner = new Scanner(System.in);


    private static boolean isPalindrome(int x) {
        int reverseX = 0;
        int number = x;
        while (number != 0) {
            reverseX = (reverseX * 10) + number % 10; // 4
            number /= 10; // 123
        }
        if (reverseX == x) {
            return true;
        }
        return false;
    }

    public static void intersectTwoList() {
        List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
        List<String> otherList = Arrays.asList("red", "green", "green", "yellow");
//        And now we'll determine the intersection of the lists with the help of stream methods:

        int coutIntersection = list.stream()
                .filter(otherList::contains)
                .collect(Collectors.toList())
                .size();
        System.out.println(coutIntersection);
    }

    public static int solution10(int[] H) {
        // write your code in Java SE 8
        int maxHeight = 0;
        int length = H.length;

        for (int height : H) {
            maxHeight = Math.max(maxHeight, height);
        }

        int maxBanner = maxHeight * length;
        int banner1 = 0;
        int banner2 = maxBanner;
        int minBanner = maxBanner;
        int max = 0;

        for (int i = 0; i < length; i++) {
            max = Math.max(max, H[i]);
            banner1 += max * (i + 1);
            banner2 -= maxHeight;
            minBanner = Math.min(minBanner, banner1 + banner2);
        }

        return minBanner;
    }

    public static int solution7(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == '1') {
                result += s.length() - i;
            } else {
                result++;
            }
        }

        return result;
    }

    public static int solution1(int[] A, int Y) {
        // write your code in Java
        Map<Integer, Integer[]> map = new HashMap();
        int maxNailLength = 1;
        int remainNailsCount = A.length;
        for (int nail : A) {
            remainNailsCount--;
            if (map.get(nail) == null) {
                map.put(nail, new Integer[]{1, remainNailsCount});
            } else {
                int nailLength = map.get(nail)[0] + 1;
                map.replace(nail, new Integer[]{nailLength, remainNailsCount});
                if (remainNailsCount >= Y) {
                    maxNailLength = maxNailLength > nailLength ? maxNailLength : nailLength;
                }

            }
        }
        if (Y == 0) {
            return maxNailLength;
        } else {
            return maxNailLength + Y >= A.length ? A.length : maxNailLength + Y;
        }
    }

    public static String[] solution(int N, int K) {
        if (N == 0) {
            return new String[]{""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K)) {
            for (char l : new char[]{'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static int balancedStringSplit(String s) {
        char max = '0';
        if (s.length() == 0) {
            return max;
        }

        Map<Character, Integer> map = new HashMap();
        map.put('L', 0);
        map.put('R', 0);
        for (char c : s.toCharArray()) {
            map.replace(c, map.get(c) + 1);
            if (map.get('L') == map.get('R')) {
                max++;
                map.replace('L', 0);
                map.replace('R', 0);
            }

        }
        return max;
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int smallestPositive = 1;
        Set<Integer> set = new HashSet();
        for (int num : A) {
            set.add(num);
        }

        for (int num : set) {
            System.out.println(num);
        }

        return smallestPositive;
    }

    public static int solution(int N) {
        // write your code in Java SE 8
        String binaryN = Integer.toString(N, 2);
        int maxBinaryGap = 0, binaryGap = -1;
        for (char bit : binaryN.toCharArray()) {
            if (bit == '1') {
                maxBinaryGap = binaryGap > maxBinaryGap ? binaryGap : maxBinaryGap;
                binaryGap = 0;
            } else {
                if (binaryGap != -1)
                    binaryGap++;
            }
        }
        return maxBinaryGap;
    }

    public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for (int i = 0; i < c.length; ) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
                jumps++;
            } else {
                i++;
                jumps++;
            }
        }
        return jumps;
    }

    public static boolean checkValidString(String s) {
        char[] sArr = s.toCharArray();
        Stack<Integer> leftBraceStack = new Stack();
        Stack<Integer> asteriskStack = new Stack();
        for (int i = 0; i < sArr.length; i++) {
            switch (sArr[i]) {
                case '(':
                    leftBraceStack.push(i);
                    break;
                case ')':
                    if (leftBraceStack.size() > 0) {
                        leftBraceStack.pop();
                    } else if (asteriskStack.size() > 0) {
                        asteriskStack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '*':
                    asteriskStack.push(i);
                    break;
            }
        }
        if (leftBraceStack.empty()) {
            return true;
        } else {
            while (!leftBraceStack.empty() && !asteriskStack.empty() && asteriskStack.pop() > leftBraceStack.pop()) {
                if (leftBraceStack.empty()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static int lastStoneWeight(int[] stones) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        Arrays.sort(stones);
        int lastIndex = stones.length - 1;
        while (lastIndex > 0 && stones[lastIndex - 1] != -1) {
            if (stones[lastIndex] == stones[lastIndex - 1]) {
                list.remove(Integer.valueOf(stones[lastIndex]));
                list.remove(Integer.valueOf(stones[lastIndex - 1]));
                stones[lastIndex] = -1;
                stones[lastIndex - 1] = -1;
            } else {
                int indexOfBiggestStone = list.indexOf(stones[lastIndex]);
                int indexOfSecondBiggestStone = list.indexOf(stones[lastIndex - 1]);
                int replacementElement = list.get(indexOfBiggestStone) - list.get(indexOfSecondBiggestStone);
                list.set(indexOfBiggestStone, replacementElement);
                list.remove(indexOfSecondBiggestStone);
                stones[lastIndex] = replacementElement;
                stones[lastIndex - 1] = -1;
            }
            Arrays.sort(stones);
        }

        if (list.size() > 0) {
            return list.getFirst();
        } else {
            return 0;
        }
    }

    public static boolean backspaceCompare(String S, String T) {
        Queue<Character> queueS = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                queueS.add(c);
            } else {
                queueS.poll();
            }
        }

        Queue<Character> queueT = new LinkedList<>();
        for (char c : T.toCharArray()) {
            if (c != '#') {
                queueT.add(c);
            } else {
                queueT.poll();
            }
        }

        while (queueS.peek() != null || queueT.peek() != null) {
            if (queueS.poll() != queueT.poll()) {
                return false;
            }
        }
        return true;

    }

    public static String getSortedStr(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sortedStr = new StringBuilder();
        for (char c : charArr) {
            sortedStr.append(c);
        }
        return sortedStr.toString();
    }

    public static int getASCII(String str) {
        int asciiSum = 0;
        for (char c : str.toCharArray()) {
            int asciiValue = c;
            asciiSum += asciiValue;
        }
        return asciiSum;
    }

    public static long getHugeNumber(String str) {
        return Long.parseLong(str.length() == 0 ? "0" : str);
    }

    public static void lovelyPalindromes() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

    }

    public static void easterEggs() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[] arr = "ROYGBIV".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            int i = 0;
            stringBuilder.append(arr[i]);
            n--;
        }
        System.out.println(stringBuilder.toString());
    }

    public static void sortTheArray() {
        Scanner scan = new Scanner(System.in);
        int arrSize = scan.nextInt();
        int[] arr = new int[arrSize];
        int[] sortedArr = new int[arrSize];
        int[] resultArr = new int[2];
        int resultIndex = 0;
        for (int i = 0; i < arrSize; i++) {
            int element = scan.nextInt();
            ;
            arr[i] = element;
            sortedArr[i] = element;
        }
        Arrays.sort(sortedArr);
        for (int i = 0; i < arrSize; i++) {
            if (arr[i] != sortedArr[i]) {
                if (resultIndex == 2) {
                    resultIndex++;
                    break;
                }
                resultArr[resultIndex++] = arr[i];
            }

        }
        if (resultIndex > 2) {
            System.out.println("no");
        } else {
            System.out.println("yes");
            Arrays.sort(resultArr);
            for (int i : resultArr) {
                System.out.print(i + " ");
            }
        }
    }

    public static void coins() {
        Scanner scan = new Scanner(System.in);
        char[] coinsArr = new char[3];
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('B', 0);
        map.put('C', 0);
        for (int i = 0; i < 3; i++) {
            String str = scan.next();
            if (str.charAt(1) == '>') {
                char c = str.charAt(0);
                map.put(c, map.get(c) + 1);
            } else {
                char c = str.charAt(2);
                map.put(c, map.get(c) + 1);
            }
        }
        if (map.get('A') == map.get('C') || map.get('B') == map.get('C') || map.get('A') == map.get('B')) {
            System.out.println("Impossible");
        } else {
            char[] coins = new char[3];
            coins[map.get('A')] = 'A';
            coins[map.get('B')] = 'B';
            coins[map.get('C')] = 'C';
            for (char c : coins) {
                System.out.print(c);
            }
        }

    }

    public static void sumOfDigits() {
        Scanner scan = new Scanner(System.in);
        String strN = scan.next();
        int result = 0;
        while (strN.length() > 1) {
            int sum = 0;
            for (char num : strN.toCharArray()) {
                sum += Character.getNumericValue(num);
            }
            strN = String.valueOf(sum);
            result++;
        }

        System.out.println(result);
    }

    public static void burglarAndMatches() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] matchBoxes = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int noOfMatchBoxes = scan.nextInt();
            int noOfMatches = scan.nextInt();
            matchBoxes[i] = noOfMatches;
            map.put(noOfMatches, noOfMatchBoxes);
        }
        int result = 0;

        Arrays.sort(matchBoxes);
        for (int i = matchBoxes.length - 1; i >= 0 && n > 0; i--) {
            if ((int) map.get(matchBoxes[i]) > n) {
                result += n * (int) matchBoxes[i];
                break;
            } else {
                result += map.get(matchBoxes[i]) * (int) matchBoxes[i];
                n -= map.get(matchBoxes[i]);
            }
        }

        System.out.println(result);
    }

    public static void petyaAndCountryside() {
        Scanner scan = new Scanner(System.in);
        int noOfSections = scan.nextInt();
        int[] sectionsLenghts = new int[noOfSections];
        int max = 1;
        for (int i = 0; i < noOfSections; i++) {
            sectionsLenghts[i] = scan.nextInt();
        }

        for (int i = 0; i < noOfSections; i++) {
            max = Math.max(getMaxRight(sectionsLenghts, i) + getMaxLeft(sectionsLenghts, i) + 1, max);
        }

        System.out.println(max);
    }

    public static int getMaxRight(int[] sectionsLenghts, int section) {
        int result = 0;
        for (int i = section; i < sectionsLenghts.length - 1; i++) {
            if (sectionsLenghts[i] >= sectionsLenghts[i + 1]) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static int getMaxLeft(int[] sectionsLenghts, int section) {
        int result = 0;
        for (int i = section; i > 0; i--) {
            if (sectionsLenghts[i - 1] <= sectionsLenghts[i]) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void bearAndFindingCriminal() {
        Scanner scan = new Scanner(System.in);
        int noOfCities = scan.nextInt();
        int LimakCityIndex = scan.nextInt();
        Set<Integer> citiesWhoHaveCrimes = new HashSet<>();

        for (int i = 1; i <= noOfCities; i++) {
            if (scan.nextInt() == 1) {
                citiesWhoHaveCrimes.add(i);
            }
        }

        int result = 0;

        for (int i = 0; i <= noOfCities; i++) {
            if (citiesWhoHaveCrimes.contains(LimakCityIndex + i) && citiesWhoHaveCrimes.contains(LimakCityIndex - i)) {
                result++;
                if (LimakCityIndex + i != LimakCityIndex - i) {
                    result++;
                }
            }

            if (citiesWhoHaveCrimes.contains(LimakCityIndex + i) && LimakCityIndex - i < 1) {
                result++;
            }

            if (citiesWhoHaveCrimes.contains(LimakCityIndex - i) && LimakCityIndex + i > noOfCities) {
                result++;
            }
        }

        System.out.println(result);
    }
}
