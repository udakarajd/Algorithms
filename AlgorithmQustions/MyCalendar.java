import java.util.HashSet;
import java.util.Set;

public class MyCalendar{
    public static void main(String [] args){

        MyCalendar1 myCalendar1 = new MyCalendar1();

        System.out.println(myCalendar1.book(2,15));
        System.out.println(myCalendar1.book(2,18));
    }
}

class MyCalendar1 {

    Set<Event> bookings;

    public MyCalendar1() {
        bookings = new HashSet<>();
    }

    public boolean book(int start, int end) {

        final Event event = new Event(start, end);

        if(bookings.contains(event))
            return false;
        final boolean[] isHit = new boolean[1];
        bookings.stream().forEach( e->{
            if(e.isHit(event))
                isHit[0]=true;
        });

        if(isHit[0]) {
            return false;

        }
        bookings.add(event);
        return true;

    }

    class Event{
        int start;
        int end;

        public Event(int start, int end){
            this.start = start;
            this.end = end;
        }

        boolean isHit(Event e){
            if(start < e.end &&  e.start<end)
                return false;
        }
        @Override
        public boolean equals(Object ob){
            if(ob==null)
                return false;
            if(!(getClass() == ob.getClass())){
                return false;
            }
            final Event finalOb = (Event) ob;

            if(start == finalOb.start && end == finalOb.end){
                return true;
            }
            return false;
        }
        @Override
        public int hashCode(){
            final int prime = 31;
            return prime * (start + end);
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */