class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        HashSet<Character> rows[] = new HashSet[n], cols[] =  new HashSet[n], box[] =new HashSet[n];
        for(int i = 0; i < n; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                char val = board[r][c];
                if(val == '.') {
                    continue;
                }
                if(rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                if(cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);
                int bI = (r/3) * 3 + (c/3);
                if(box[bI].contains(val)) {
                    return false;
                }
                box[bI].add(val);
            }
        }
        return true;
    }
}
