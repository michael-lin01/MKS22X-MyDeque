public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
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
    if(size==data.length) resize();
    if(start==0) start = data.length-1;
    else start--;

    data[start]=element;
    size++;
  }

  public void addLast(E element){
    if(size==data.length) resize();
    if(end==data.length-1) end=0;
    else end++;

    data[end]=element;
    size++;
  }

  public E removeFirst(){
    E first = data[start];
    data[start] = null;
    if(start==data.length-1) start = 0;
    else start++;

    size--;
    return first;
  }

  public E removeLast(){
    E last = data[end];
    data[end] = null;
    if(end==0) end=data.length-1;
    else end--;

    size--;
    return last;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

  private void resize(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size*2+1];
    for(int i = start, n = 0; i < start+size; i++, n++){
      d[n]=data[i%size];
    }
    data = d;
  }

  public String toString(){
    String ans = "{";
    for(int i = start; i < start+size; i++){
      ans+=data[i%size]+" ";
    }
    return ans.substring(0,ans.length()-1)+"}";
  }
}
