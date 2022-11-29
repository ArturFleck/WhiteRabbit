package enums;

public enum Series {

    Breaking_Bad(85, 9.5d),
    Friends(60, 7.3d),
    Sherlock(70, 5.2d);

    final int level;
    final double imdb;

    Series(int level, double imdb){
        this.level = level;
        this.imdb = imdb;
    }
}
