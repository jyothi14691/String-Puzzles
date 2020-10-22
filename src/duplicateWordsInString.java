import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class duplicateWordsInString {

    public String[] removeDuplicates(int maxDupAllowed, String[] input) {
        Integer[] count = new Integer[input.length];

        Arrays.sort(input);

//        String[] disInput = Arrays.stream(input).distinct().toArray(String[]::new);
//        return disInput;
        int sum = 0;
        int j = 0; int totalSum = 0;
        for(int i = 0 ; i <input.length;i++){
            sum = findSum(maxDupAllowed, input[i],input);
            if(sum > maxDupAllowed){
                totalSum = totalSum + 1;
            }
        }
        String[]result = new String[input.length - totalSum];
        for(int i = 0 ; i <input.length;i++){
            sum = findSum(maxDupAllowed, input[i],input);
            if(sum < maxDupAllowed){
               result[j] = input[i];
               j++;
            }
        }
        return result;
    }

    private int findSum(int maxDupAllowed, String toCheck,String[] input) {
        int sum = 0;
        int count = 0;
           count =  countDuplicates(toCheck,input);
           if(count > maxDupAllowed){
               sum = sum + count;
           }

        return sum;
    }


    public Integer countDuplicates(String toCheck,String[] input){
        int count = 0;
        for(int i = 0 ; i < input.length -1;i++){
            if(toCheck.equals(input[i])){
                count = count+1;
            }
        }
        return count;
    }

    static String superReducedString(String s) {

          Stream<Character> ch =   s.chars().mapToObj( i -> (char) i).distinct();

          String result = ch.map(c->c.toString()).collect(Collectors.joining());

          return result;
    }

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        char[] str = password.toCharArray();
        int count = 0;

        if(!password.matches(".*[a-z].*")) {
            count++;
        }

        if(!password.matches(".*[A-Z].*")) {
            count++;
        }

        if(!password.matches(".*[0-9].*")) {
            count++;
        }

        if( !password.matches( ".*[-!@#$%^&*()+]+.*" )){
            count++;
        }

        if(password.matches("[a-zA-Z0-9]*")) {
            count++;
        }

        int diff = 6 - password.length();

        if(diff > 0 && count <= diff) {
            return diff;
        }
        return count;
    }

    static boolean isAnagram(String A, String B) {
        A = A.toLowerCase();
        B = B.toLowerCase();
        boolean f = false;
        char[] c = A.toCharArray();
        Arrays.sort(c);
        char[] d = B.toCharArray();
        Arrays.sort(d);
        String a = new String(c);
        String b = new String(d);
        if (a.equals(b)) {
            f = true;
        }
        return f;
    }

    public static void main(String[] args){
        duplicateWordsInString ds = new duplicateWordsInString();
        String[] inputStr = {"aaa","bbb","ccc","aaa","aaa","bbb","bbb","ccc"};
        String[] strings = ds.removeDuplicates(0, inputStr);
        System.out.println(Arrays.toString(strings));
        String result = ds.superReducedString("bbbdddaaaccc");
        System.out.println(result.toString());
        Boolean b = isAnagram("madam","adammm");
        System.out.println(b);
    }
}
