import java.util.*;
public class recursion_in_arraylist {

//getsubsequenceofstring
    public static ArrayList < String > gss(String str) {
        if(str.length() == 0){
            ArrayList<String> ss = new ArrayList<>();
            ss.add("");
            return ss;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rr = gss(ros);
        ArrayList<String> mr = new ArrayList<>();
        for(int i = 0 ; i< rr.size();i++){
            mr.add(rr.get(i));
        }
        for(int i = 0 ; i< rr.size();i++){
            mr.add(ch+rr.get(i));
        }
        return mr;
    }

    









    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> al = gss(s);
        System.out.println(al);
    }
}
