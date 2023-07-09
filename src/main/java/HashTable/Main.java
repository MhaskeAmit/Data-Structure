package HashTable;

public class Main {
    public static void main(String args[]){
        HashTableDS ht = new HashTableDS();

        ht.set("A",1);
        ht.set("B",2);
        ht.set("C",3);
        ht.printList();
        System.out.println(ht.findDuplicates(new int[]{1,2,3,4,3,2,1,6,7}));
        System.out.println(ht.firstNonRepeatingChar("HelloH"));
        System.out.println(ht.groupAnagrams(new String[]{"a","b","c","d"}));
        System.out.println(ht.twoSum(new int[]{1,2,3,4,3,2,1,6,7},4));
    }
}
