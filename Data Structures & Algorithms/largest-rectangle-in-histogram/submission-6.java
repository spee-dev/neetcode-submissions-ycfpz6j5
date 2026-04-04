class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        int area=0;
        for(int i=0;i<=n;i++){
            int h=i==n?0:heights[i];
            while(st.peek()!=-1 && h<=heights[st.peek()]){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                area=Math.max(area,height*width);
            }
            st.push(i);
        }
        return area;
    }
}
