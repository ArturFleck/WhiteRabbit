package kata_s;

public class HumanReadableTime {
    public static void main(String[] args) {
        System.out.println(makeReadable(327070));
    }

    public static String makeReadable(int seconds) {
        int sec = 0;
        int min = 0;
        int hour = 0;

        while (seconds > 0) {
            sec++;
            seconds--;
            if (sec == 60) {
                min++;
                sec = 0;
                if (min == 60) {
                    hour++;
                    min = 0;
                }
            }
        }
        String hr = hour > 9 ? String.valueOf(hour) : "0" + hour;
        String mr = min > 9 ? String.valueOf(min) : "0" + min;
        String sr = sec > 9 ? String.valueOf(sec) : "0" + sec;
        return hr + ":" + mr + ":" + sr;
    }

    public static String makeReadable2(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

    public static String makeReadable3(int seconds) {
        int h = seconds/60/60;
        int min = seconds/60%60;
        int sec = seconds%60;
        return String.format("%02d:%02d:%02d",h,min,sec);
    }
}
