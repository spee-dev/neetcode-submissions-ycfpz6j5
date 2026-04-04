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
    public boolean canAttendMeetings(List<Interval> intervals) {
       Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        for(int i=1;i<intervals.size();i++){
            Interval current=intervals.get(i);
            Interval prev=intervals.get(i-1);
            if(current.start<prev.end)return false;
        } 
        return true;
    }
}
