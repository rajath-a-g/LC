package FebLC2021;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println("Simplified path is " + simplifyPath("/home/"));
        System.out.println("Simplified path is " + simplifyPath("/../"));
    }
    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) stack.poll();
            else if(!s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) return "/";
        while(stack.size() != 0) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }
}
