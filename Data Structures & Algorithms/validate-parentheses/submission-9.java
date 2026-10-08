class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char b = s.charAt(i);
            if(b == '('){
                stack.push(')');
            } else if(b == '{'){
                 stack.push('}');
            } else if (b == '['){
                stack.push(']');
            } else {
                if(stack.isEmpty()) return false;
                if(b == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
