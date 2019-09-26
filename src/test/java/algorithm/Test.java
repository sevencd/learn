package algorithm;

import java.util.Map;

public class Test{
    public static void main(String[] args){
        testPut();
        testGet();
    }
    static  void testPut(){
           LRULinkedMap<String,Integer> map = new LRULinkedMap(3) ;
            map.put("1",1);
            map.put("2",2);
            map.put("3",3);
            for (Map.Entry<String, Integer> e : map.getAll()) {

                System.out.print(e.getKey() + " : " + e.getValue() + "\t");
            }
            System.out.println("");
            map.put("4",4);
            for (Map.Entry<String, Integer> e : map.getAll()){
                System.out.print(e.getKey() + " : " + e.getValue() + "\t");
            }
        }

    static void testGet(){
        LRULinkedMap<String,Integer> map = new LRULinkedMap(4) ;
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
        System.out.println("");
        map.get("1") ;
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }

    }
}
