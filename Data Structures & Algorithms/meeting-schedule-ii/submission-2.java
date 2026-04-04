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
      int n=intervals.size();
      Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     pq.offer(intervals.get(0).end);
      for(int i=1;i<n;i++){
        int Currstart=intervals.get(i).start;
        if(Currstart>=pq.peek()){
            pq.poll();
        }
        pq.offer(intervals.get(i).end);
      }
      return pq.size();
    }
}
