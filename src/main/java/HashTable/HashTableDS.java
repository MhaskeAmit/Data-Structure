package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashTableDS {

    private int size = 7;
    private Node[] dataMap;

    public HashTableDS(){
        dataMap = new Node[size];
    }

    private int hash(String key){
        int hash = 0;
        char keyChars[] = key.toCharArray();

        for(int i=0;i<keyChars.length;i++){
            int asciiValue = keyChars[i];
            System.out.println("ASCII value ::"+asciiValue);
            hash = (hash + asciiValue * 3) % dataMap.length;
        }
        return hash;
    }

    public boolean ItemInCommon(int[] array1,int[] array2){
        HashMap<Integer,Boolean> common = new HashMap<>();

        for(int i=0;i<array1.length;i++){
            if(!common.containsKey(array1[i])){
                common.put(array1[i],true);
            }
        }
        for(int j : array2){
            if(common.get(j)!=null){
                return true;
            }
        }
        return false;
    }


    public void set(String key,int value){
        int index = hash(key);
        System.out.println("Hash value :"+index);
        Node newNode = new Node(key,value);

        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else if(dataMap[index] != null){
            Node temp = dataMap[index];
            if(temp.key == key){
                temp.value = value;
                return;
            }
            while(temp.next!=null){
                temp = temp.next;
                if(temp.key == key){
                    temp.value+=value;
                    return;
                }
                temp.next = newNode;
            }
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];

        while(temp!=null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }
    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(int i=0;i< dataMap.length;i++){
            Node temp = dataMap[i];
            while(temp!=null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
    public void printList(){
        for(int i=0;i<dataMap.length;i++){
            Node temp = dataMap[i];
            while(temp!=null){
                System.out.println("Keys :"+temp.key+" Value :"+temp.value);
                temp = temp.next;

            }
        }
    }

    public List<Integer> findDuplicates(int[] nums){

        HashMap<Integer,Integer> numCounts = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();
        for(int num : nums){
            if(!numCounts.containsKey(num)){
                numCounts.put(num,numCounts.get(num));
            }else{
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    public Character firstNonRepeatingChar(String str){
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(hm.get(ch)==1){
                return ch;
            }
        }
        return 0;
    }
    public List<List<String>> groupAnagrams(String[] str){
        HashMap<String,List<String>> anagrams = new HashMap<>();
        for(String string : str ){
            char[] ch = string.toCharArray();
            Arrays.sort(ch);
            String canonical = new String(ch);
            if(anagrams.containsKey(canonical)){
                anagrams.get(canonical).add(string);
            }else{
                List<String> group = new ArrayList<>();
                group.add(string);
                anagrams.put(canonical,group);
            }
        }
        return new ArrayList<>(anagrams.values());
    }

    public int[] twoSum(int[] array,int target){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<array.length;i++){
            int num = array[i];
            int complement = target - num;

            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement),i};
            }
            hm.put(num,i);
        }
        return new int[]{};
    }

}
