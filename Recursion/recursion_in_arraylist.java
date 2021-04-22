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



    //Get KPC(keyboar combination combination)
    //input:78
    //output:[tv, tw, tx, uv, uw, ux]
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx",
    "yz"
    };
    public static ArrayList < String > getKPC(String str) {


    if (str.length() == 0) {
        ArrayList < String > ra = new ArrayList < > ();
        ra.add("");
        return ra;
    }
    char ch = str.charAt(0) ;
    String ros = str.substring(1);
    ArrayList < String > rr = getKPC(ros);
    ArrayList < String > mr = new ArrayList < > ();
    String code = codes[ch - '0'];
    for (int i = 0; i < code.length(); i++) {
        char c = code.charAt(i);
        for (int j = 0; j < rr.size(); j++) {
            mr.add(c + rr.get(j));
        }
    }
    return mr;
}

// //getstairpath 
// Sample Input
// 3
// Sample Output
// [111, 12, 21, 3]
public static ArrayList < String > getStairPaths(int n) {//3recusion calls of step 1 2 and 3
    if(n<0 ){
        ArrayList<String> ans = new ArrayList<>();
    
        return ans;
    }
    
    
    if(n==0 ){
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        return ans;
    }
    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> r1 = getStairPaths(n-1);
    for(int i=0 ; i<r1.size() ; i++){
        a.add(1+r1.get(i));
    }
    
    ArrayList<String> r2 = getStairPaths(n-2);
    for(int i=0 ; i<r2.size() ; i++){
        a.add(2+r2.get(i));
    }
    ArrayList<String> r3 = getStairPaths(n-3);
    for(int i=0 ; i<r3.size() ; i++){
        a.add(3+r3.get(i));
    }
   return a;
    
}




//get-maze-path
// Sample Input
// 3
// 3
// Sample Output
// [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
    if( sr> dr || sc> dc ){
        ArrayList<String> ans = new ArrayList<>();
        
        return ans;
    }
    if(sr == dr  && sc == dc ){
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        return ans;
    }
    ArrayList<String> s = new ArrayList<>();
    ArrayList<String> rr1 = getMazePaths(sr , sc+1 , dr , dc );
    for(int i=0 ; i<rr1.size() ; i++ ){
        s.add("h"+rr1.get(i));
    }
    ArrayList<String>rr2 = getMazePaths(sr+1 , sc , dr , dc );
        for(int i=0 ; i<rr2.size() ; i++ ){
        s.add("v"+rr2.get(i));
    }
    
    return s;
}

//Get Maze Path with jumps
// 2
// 2
// Sample Output
// [h1v1, v1h1, d1] 
public static ArrayList < String > getMazePathswithjumps(int sr, int sc, int dr, int dc) {
    if (sr > dr || sc > dc) {
        ArrayList < String > base = new ArrayList < > ();

        return base;
    }
    if (sr == dr && sc == dc) {
        ArrayList < String > base = new ArrayList < > ();
        base.add("");
        return base;
    }
    //horizontal moves
    ArrayList < String > mr = new ArrayList < > ();
    for (int i = 1; i <= dc - sc ;i++) {
        ArrayList < String > rr1 = getMazePaths(sr, sc + i, dr, dc);
        for (int j = 0; j < rr1.size(); j++) {
            mr.add("h" + (i ) + rr1.get(j));
        }
    }

    //vertical moves
    for (int i = 1; i <= dr - sr; i++) {
        ArrayList < String > rr2 = getMazePaths(sr+i, sc , dr, dc);
        for (int j = 0; j < rr2.size(); j++) {
            mr.add("v" + i + rr2.get(j));
        }
    }

    //diagonal moves
    for (int i = 1; i <= dr-sr && i <= dc - sc; i++) {
        ArrayList < String > rr3 = getMazePaths(sr + i, sc + i, dr, dc);
        for (int j = 0; j < rr3.size(); j++) {
            mr.add("d" + i + rr3.get(j));
        }
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
