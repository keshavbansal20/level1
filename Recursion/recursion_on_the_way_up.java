public class recursion_on_the_way_up{

    
    // print Subsequences
    public static void printSS(String str , String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ssf = str.substring(1);
        printSS(ssf , asf+ch);
        printSS(ssf ,asf );
    }

    //print Key Pad Combination
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str , String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String ssf = str.substring(1);
        String code = codes[ch-'0'];
        for(int i=0;i<code.length();i++){
            printKPC(ssf , asf+ code.charAt(i));
        }
        
    }

    //print staitPath
    public static void printStairPaths(int n, String path) {
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(path);
            return;
        }
    
        printStairPaths(n-1 , path +"1");
    
        printStairPaths(n-2 , path +"2");
    
        printStairPaths(n-3 , path +"3");
    }

    //print getmazePaths
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr>dr || sc > dc){
            return;
        }
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        printMazePaths(sr , sc+1 , dr , dc , psf + "h");
        printMazePaths(sr+1 , sc , dr , dc , psf + "v");
    }

    //print getmazepath with jumps
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        if(sr==dr && sc == dc){
            System.out.println(psf);
            return ;
        }
        
        for(int i =1 ; i<= dc - sc ; i++){
            printMazePaths( sr , sc+i , dr , dc , psf+"h"+i );
        }
        for(int i =1 ; i<= dr - sr ; i++){
            printMazePaths( sr+i , sc , dr , dc , psf+"v"+i );
        }
        for(int i =1 ; i<= dr - sr && i <= dc - sc; i++){
            printMazePaths( sr+i , sc +i, dr , dc , psf+"d"+i );
        }

    }

    //print Permutation  abc --> abc , acb , bac, bca  , cab , cba
    public static void printPermutations(String str,String psf) {
        if(str.length()==0){
            System.out.println(psf);
            return;
        }
        
        for(int i = 0 ; i< str.length() ; i++){
            char c = str.charAt(i);
            String ros = str.substring(0,i)+str.substring(i+1);
            printPermutations(ros , psf+c);
        }
    }

    //  print encodings  only 1 to 26 is limit
    // 123 -> abc, aw, lc
    // 993 -> iic
    // 013 -> Invalid input. A string starting with 0 will not be passed.
    // 103 -> jc
    // 303 -> No output possible. But such a string maybe passed. In this case print nothing.

    public static void printEncodings(String str , String asf) {
        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        if(str.charAt(0)=='0'){
            return;
        }
        String ch0 = str.substring(0,1);
        String ros1 = str.substring(1);
        printEncodings(ros1 , asf + (char)(Integer.parseInt(ch0) - 1 + 'a'));

    if(str.length() >=2){
        String ch01 = str.substring(0,2);
        String ros2 = str.substring(2);
        if( Integer.parseInt(ch01)<= 26 ){
            printEncodings(ros2 , asf +(char)(Integer.parseInt(ch01) - 1 + 'a' ));
        }
    }

    }
    


    






}