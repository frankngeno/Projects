package forloops;

public class ForeachLoop {
    public static void main(String[] args) {
        char[] vowels = {'a', 'e','i','o','u'};

        //iterating through an array using a for loop
        for(int i = 0; i < vowels.length; ++ i) {
            System.out.print(vowels[i]);
        }

        for(char item: vowels){
            System.out.println(item);
        }
    }
}
