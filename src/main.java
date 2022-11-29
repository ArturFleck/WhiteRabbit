import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {

        /*Bus bus = new Bus();
        bus.colour="Gray";
        bus.showColour();

        References ref = new References();
        ref.foo();

        Integer a=35;
        Integer b=45;
        double c;
        c=Math.sqrt(a*a + b*b);
        System.out.println("sqrt " + c);

        char ch = 'г';
        System.out.println(ch);
        System.out.println(++ch);

        boolean y = a==b;
        System.out.println(y);

        ForLoop forLoop = new ForLoop();
        forLoop.foo();

        myArrays arr = new myArrays();
        arr.foo();*/

//-------------------------------------------------------------------------
        System.out.println("---LIST---");
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(1,3);
        list.add(9);
        list.add(1,2);
        //list.remove(0);
        System.out.println(list);

        for (int i=15;i>0;i--){
            list.add((int) (Math.random()*i));
        }
        for (int n: list){
            System.out.print(n + "  ");
        }
        System.out.println();
        System.out.println(list);


        System.out.print("\n\n");
//-------------------------------------------------------------------------
        System.out.println("---SET---");

        Random rand = new Random();

        int k=15;   // how many cycles

        Set<Integer> setList = new HashSet();   // Set 1
        Set<Integer> setList2 = new HashSet();   // Set 2

        fillSet(setList,k);     // filling both Set's (Set, cycle)
        fillSet(setList2,k);

        System.out.print("\n");

        System.out.println(setList);        // printing what's inside of Set
        System.out.println(setList2);       // printing what's inside of Set
        System.out.println(setList.equals(setList2));   // comparing both Set's if they are EQUAL

        setList2.clear();                   // clearing Set
        setList2.addAll(setList);           // copying one Set into the other
        System.out.println(setList);        // printing what's inside of Set
        System.out.println(setList2);       // printing what's inside of Set
        System.out.println(setList.equals(setList2));   // comparing both Set's if they are EQUAL
        //System.out.println(setList.contains(5));      // checking element in Set

        /*Iterator<Integer> iterator = setList.iterator();        // printing what's inside of Set,  initially we stand at position 0
        while (iterator.hasNext()){                     // while we've got NEXT element in row we're go into next cycle
            System.out.println(iterator.next());        // printing that NEXT element
        }*/

        int counter=0;
        int index=3;    // number of element that we want to print

        for (Integer i: setList){
            if(counter==index){
            System.out.println(i);}
            counter++;
        }

        System.out.print("\n\n");
//-------------------------------------------------------------------------
        System.out.println("---MAP---");

        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("filling MAP:");
        for (int i=0;i<k;i++){
            int t = rand.nextInt(99);
            map.put(i,t);
            System.out.print(t + "  ");
        }
        System.out.print("\n\n");

        System.out.println(map.get(3));    // printing element with index = 3
        System.out.println("MAP size : " + map.size());     // printing size or MAP

        for (Integer i: map.values()){          // printing MAP element by element using for cycle
            System.out.print(i + "  ");
        }

        System.out.print("\n\n");

        map.values().stream()                   // printing MAP element by element using stream
                .map(i -> i + "  ")
                .forEach(System.out::print);

        System.out.print("\n\n");

        System.out.println(map.keySet());       // printing all keys
        System.out.println(map.values());       // printing all values



        System.out.print("\n\n");
//-------------------------------------------------------------------------

        FileInputStream stream = new FileInputStream("D:/JavaProjects/WhiteRabbit/data.csv");
        int length = stream.available();

        byte []data = new byte[length];
        stream.read(data);

        String text = new String(data);
        text = text.replace("\n\n","\n");
        text = text.replace("\"","");
        String[] lines = text.split("\n");

        ArrayList<String[]> linePieces = new ArrayList<>();

        for (String n: lines) {
            String [] words = n.split(",");
            linePieces.add(words);
        }

        //System.out.println(lines[1]);

        /*for (String [] words : lineWords) {
            if (words[12].equals("новое строительство")) {
                for (String word : words) {
                    System.out.print(word);
                    System.out.print("|");
                }
                System.out.println();
            }
            //System.out.println("-----------------------------------------");
        }*/

        HashMap<String, Integer> mapa = new HashMap<>();
        for (String [] words : linePieces){
            if (mapa.containsKey(words[12])){
                Integer p = mapa.get(words[12]);
                p++;
                mapa.put(words[12], p);
            }else{
                mapa.put(words[12],1);
            }
        }
        System.out.println("новое строительство:\t" + mapa.get("новое строительство"));

        System.out.println("реконструкция:\t"+ mapa.get("реконструкция"));

        System.out.println("в строительстве:\t" + mapa.get("в строительстве"));

        /*for (String key : mapa.keySet()){
            System.out.println("Stage: " + key + " total: " + mapa.get(key));
        }*/
    }

    public static void fillSet(Set<Integer> setList, int k){
        for (int i =0; i<k;i++){
            Random rand = new Random();
            int temp=rand.nextInt(10);
            setList.add(temp);
            System.out.print(temp + "  ");
        }
        System.out.println();
    }
}
