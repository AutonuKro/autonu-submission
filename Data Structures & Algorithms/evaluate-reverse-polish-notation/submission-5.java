class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if("+".equals(token)) {
                int b = s.pop();
                int a = s.pop();
                s.push(a + b);
            } else if("-".equals(token)) {
                int b = s.pop();
                int a = s.pop();
                s.push(a - b);
            } else if("*".equals(token)) {
                int b = s.pop();
                int a = s.pop();
                s.push(a * b);
            } else if("/".equals(token)) {
                int b = s.pop();
                int a = s.pop();
                if(b == 0) {
                    s.push(0);
                } else{
                    s.push(a/b);
                }
            } else {
                s.push(Integer.valueOf(token));
            }
        }
        return s.pop();
    }
}
