import java.util.Stack;

public class TestMain {
    public static void main (String [] args){
        BasicKnowledge bk=new BasicKnowledge();
//        int[] test1={1,3,5,7,7,9};
//        int[] test2={0,2,2,4,6,8};
//        int [] r=bk.unionArray(test1,test2);
//
// Stack<Integer> r=bk.baseConversion(2007,8);
        boolean b= bk.bracketMatch("{{[({[(]}[]())]}}[][()]");


        System.out.print("over");
    }
}
