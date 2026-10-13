class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer[]> stack = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        // Next smaller element (right)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek()[1];

            stack.push(new Integer[]{heights[i], i});
        }

        stack.clear();

        // Previous smaller element (left)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek()[1];

            stack.push(new Integer[]{heights[i], i});
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
