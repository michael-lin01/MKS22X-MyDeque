import java.util.*;

public class MyDeque<E>{
  private E[] data;
  public int size, start, end;

  public MyDeque(){
    this(10);
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
  }

  public int size(){
    return size;
  }

  public void addFirst(E element){
    if(element == null) throw new NullPointerException();
    if(size!=0){
      if(size==data.length) resize();
      start = Math.floorMod(start-1,data.length);
    }
    else{
      start = 0;
      end = 0;
    }

    data[start]=element;
    size++;
  }

  public void addLast(E element){
    if(element == null) throw new NullPointerException();
    if(size!=0){
      if(size==data.length) resize();
      end = Math.floorMod(end+1,data.length);
    }
    else{
      start = 0;
      end = 0;
    }

    data[end]=element;
    size++;
  }

  public E removeFirst(){
    if(size==0) throw new NoSuchElementException();

    E first = data[start];
    data[start] = null;
    start = Math.floorMod(start+1,data.length);
    size--;

    return first;
  }

  public E removeLast(){
    if(size==0) throw new NoSuchElementException();

    E last = data[end];
    data[end] = null;
    end = Math.floorMod(end-1,data.length);
    size--;

    return last;
  }

  public E getFirst(){
    if(size==0) throw new NoSuchElementException();

    return data[start];
  }

  public E getLast(){
    if(size==0) throw new NoSuchElementException();

    return data[end];
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size*2+1];

    for(int i = start, n = 0; i < start+size; i++, n++){
      d[n]=data[i%data.length];
    }

    data = d;
    start = 0;
    end = size-1;

  }

  public String toString(){
    if(size==0) return "{}";
    String ans = "{";
    for(int i = start; i < start+size; i++){
      ans+=data[i%data.length]+" ";
    }
    return ans.substring(0,ans.length()-1)+"}";
  }

  public String toStringDebug(){
    return Arrays.toString(data);
  }

  public static void main(String args[]){
    MyDeque<Integer> d = new MyDeque<>(40);
    //d.addFirst(null);
    d.addLast(1);
    System.out.println("start "+d.start);
    System.out.println("end "+d.end);
    d.removeFirst();
    System.out.println("start "+d.start);
    System.out.println("end "+d.end);

    d.addLast(1);
    System.out.println(d);
    d.addFirst(2);
    System.out.println(d);
    System.out.println(d.toStringDebug());
    for(int i = 0; i < 20; i++){
      if(i%2==1) d.addFirst(i);
      else d.addLast(i);
      System.out.println(d);
      //System.out.println(d.toStringDebug());
    }
    System.out.println(d);
    System.out.println(d.toStringDebug());
    for(int i = 0; i < 20; i+=2){
      if(i%4==2) d.removeFirst();
      else d.removeLast();
      System.out.println(d);
      //System.out.println(d.toStringDebug());
    }
    System.out.println(d.getFirst());
    System.out.println(d.getLast());
    System.out.println(d.size());
    System.out.println(d.toStringDebug());
  }
}
