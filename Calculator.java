public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, separated by spaces.
  */
  public static double eval(String s){
    String[] nums = s.split(" ");
    MyDeque<Double> d = new MyDeque<>();
    for(int i = 0; i < nums.length; i++){
      if(nums[i].equals("+")){
        d.addLast(d.removeLast()+d.removeLast());
      }
      else if(nums[i].equals("-")){
        d.addLast((d.removeLast()-d.removeLast())*-1);
      }
      else if(nums[i].equals("*")){
        d.addLast(d.removeLast()*d.removeLast());
      }
      else if(nums[i].equals("/")){
        d.addLast(1/d.removeLast()*d.removeLast());
      }
      else if(nums[i].equals("%")){
        double n = d.removeLast();
        d.addLast(d.removeLast()%n);
      }
      else d.addLast(Double.parseDouble(nums[i]));
    }
    return d.removeLast();
  }

  public static void main(String args[]){
    System.out.println(eval("1 2 /"));
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
  }
}
