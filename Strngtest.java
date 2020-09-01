public class Strngtest {
    public static void main(String[] args){
        String s="(9,3700)";
        if(!s.contains(",")){
            System.out.println("dosnthasit");
        }else{
            System.out.println(s.contains(","));
        }
    }
}
