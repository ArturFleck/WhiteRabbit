package lesson13;

public class ForLoop {

    int []arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    public void foo(){
        for (int element: arr){ // каждый элемент массива
            if(element%2==0)    // отстаток от деления
            System.out.println(element);
        }
    }
}
