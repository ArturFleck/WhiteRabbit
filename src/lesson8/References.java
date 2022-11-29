package lesson8;

public class References {

    Byte a=123;
    Short b;
    Integer c;
    Long d;
    Character e;
    Float f;
    Double g;
    Boolean h;

    public void foo(){
        int gg=a.hashCode();
        System.out.println(gg);
    }
}
