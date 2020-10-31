import java.util.HashSet;
public class task {

    //1
    public static int solution(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        if (D == 0)
            return 1;
        if (D > 0)
            return 2;
        return 0;
    }

    //2
    public static int findZip(String str) {
        String tmp = "";
        int index = str.indexOf("zip");

        if (index != -1) {
            tmp = str.substring(index + 4, str.length());
            index = tmp.indexOf("zip");
            if (index != -1) {
                return index + str.length() - tmp.length();
            }
        }
        return -1;
    }

    //3
    public static boolean checkPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                sum += i;
        }
        return sum == n;
    }

    //4
    public static String flipEndChars(String str) {
        if (str.length() < 2)
            return "Incompatible.";
        if (str.charAt(0) == str.charAt(str.length() - 1))
            return "Two's a pair.";

        return str.charAt(str.length() - 1) + str.substring(1, str.length() - 2) + str.charAt(0);
    }

    //5
    public static boolean isValidHexCode(String str) {
        boolean isValid = false;
        str = str.toLowerCase();

        if (str.length() == 7 && str.charAt(0) == '#') {
            for (int i = 0; i < 5; i++) {
                char ch = str.charAt(i);

                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f'))) {
                    isValid = false;
                    break;
                }
            }
            isValid = true;
        }
        return isValid;
    }

    //6
    public static boolean same(int[] a, int[] b) {
        HashSet<Integer> set_a = new HashSet<Integer>();
        HashSet<Integer> set_b = new HashSet<Integer>();

        for (int i = 0; i < a.length; i++) {
            set_a.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            set_b.add(b[i]);
        }

        return set_a.size() == set_b.size();
    }

    //8
    public static String longestZero(String str) {
        int max_seq = 0;
        int idx = -1;

        for (int i = 0, cur_seq = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '0') {
                cur_seq++;
            }
            if (i == str.length() - 1 || str.charAt(i) != '0') {
                if (cur_seq >= max_seq) {
                    max_seq = cur_seq;
                    idx = i;
                    cur_seq = 0;
                }

                if (i == str.length() - 1 && str.charAt(i) == '0') {
                    idx++;
                }
            }
        }
        return str.substring(idx - max_seq, idx);
    }

    //10
    public static boolean rightTriangle(int a, int b, int c) {
        if (a * a + b * b == c * c)
            return true;
        if (b * b + c * c == a * a)
            return true;
        if (a * a + c * c == b * b)
            return true;
        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("solution(1, 0, -1) -> " + solution(1, 0, -1));
        System.out.println("solution(1, 0, 0) -> " + solution(1, 0, 0));
        System.out.println("solution(1, 0, 1) -> " + solution(1, 0, 1));

        System.out.println("findZip(\"all zip files are zipped\") -> " + findZip("all zip files are zipped"));
        System.out.println("findZip(\"all zip files are compressed\") -> " + findZip("all zip files are compressed"));

        System.out.println("checkPerfect(28) -> " + checkPerfect(28));
        System.out.println("checkPerfect(12) -> " + checkPerfect(12));

        System.out.println("flipEndChars(\"Cat, dog, and mouse.\") -> " + flipEndChars("Cat, dog, and mouse."));
        System.out.println("flipEndChars(\"ada\") -> " + flipEndChars("ada"));
        System.out.println("flipEndChars(\"z\") -> " + flipEndChars("z"));

        System.out.println("isValidHexCode(\"#CD5C5C\") -> " + isValidHexCode("#CD5C5C"));
        System.out.println("isValidHexCode(\"#CD5C58C\") -> " + isValidHexCode("#CD5C58C"));

        System.out.println("same([1, 3, 4, 4, 4], [2, 5, 7]) -> " + same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
        System.out.println("same([9, 8, 7, 6], [4, 4, 3, 1]) -> " + same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));

        System.out.println("longestZero(\"100110001\") -> " + longestZero("100110001"));
        System.out.println("longestZero(\"100100100\") -> " + longestZero("100100100"));

        System.out.println("rightTriangle(3, 4, 5) -> " + rightTriangle(3, 4, 5));
        System.out.println("rightTriangle(145, 105, 100) -> " + rightTriangle(145, 105, 100));
        System.out.println("rightTriangle(70, 130, 110) -> " + rightTriangle(70, 130, 110));
    }
}


