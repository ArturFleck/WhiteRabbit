package kata_s;

public class StringEnder {
    public static void main(String[] args) {
        System.out.println(solution("samurai", "ai"));
        System.out.println(solution2("samuri", "ai"));
    }

    public static boolean solution(String str, String ending) {
        if (str.length()>=ending.length()) {
            String temp = "";
            for (int i = 0; i < ending.length(); i++) {
                temp = temp + str.charAt(str.length() - ending.length() + i);
            }

            if (ending.equals(temp))
                return true;
            else
                return false;
        }
        return false;
    }

    public static boolean solution2(String str, String ending) {
        return str.endsWith(ending);
    }
}
