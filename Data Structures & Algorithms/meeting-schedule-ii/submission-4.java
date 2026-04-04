/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
         if(intervals.size()==0)return 0;
         Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
         PriorityQueue<Integer>pq=new PriorityQueue<>();
         int end=intervals.get(0).end;
         pq.offer(end);
         for(int i=1;i<intervals.size();i++){
            int start=intervals.get(i).start;
            if(start>=pq.peek()){
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
         }
         return pq.size();
    }
}
