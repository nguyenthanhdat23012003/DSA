package problem.medium.Simplify_Path;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stored = new Stack<>();
        String[] dirs = path.split("/");

        for(String dir : dirs){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            } else if (dir.equals("..")){
                if(!stored.isEmpty()){
                    stored.pop();
                }
            } else {
                stored.push(dir);
            }
        }

        StringBuilder result = new StringBuilder();
        for(String dir : stored){
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}