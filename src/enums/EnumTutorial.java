package enums;

public class EnumTutorial {
    public static void main(String[] args) {

        DaysOfTheWeek day = DaysOfTheWeek.WEDNESDAY;
        int series = Series.Sherlock.level;

        if (day == DaysOfTheWeek.WEDNESDAY){
            System.out.println("its " + day);
        }

        for (DaysOfTheWeek myDay : DaysOfTheWeek.values()){
            System.out.println(myDay);
        }

        for (Series series1: Series.values()){
            System.out.println(series1);
        }
        System.out.println(series);

    }
}
