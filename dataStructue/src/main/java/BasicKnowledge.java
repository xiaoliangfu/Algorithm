import java.util.Stack;

public class BasicKnowledge {
    /**
     * 选择排序
     * 输入：任意一个数组
     * 输出：排序后的数组
     */
    public int[] sortSelect(int[] data){
        for (int i=0;i<data.length-1;i++){
            int min=i;
            for (int j=i+1;j<data.length;j++){
                if (data[j]<data[min]){
                    min=j;
                }
            }
            if (min!=i){
                int tmp=data[min];
                data[min]=data[i];
                data[i]=tmp;
            }
        }
        return data;
    }

    /**
     * 将两个非降序数组合并成一个非降序数组
     * 时间复杂度O（m+n）  m/n表示两个数组大小
     * 输入：将两个非降序数组
     * 输出合并后的一个非降序数组
     */

    public int[] unionArray(int[] a1,int[] a2){
        int index1=0;
        int index2=0;
        int[] result =new int[a1.length+a2.length];
        int indexResult=0;
        while(index1<a1.length && index2<a2.length){
            if (a1[index1]<a2[index2]){
                result[indexResult]=a1[index1];
                index1++;
                indexResult++;
            }
            else{
                result[indexResult]=a2[index2];
                index2++;
                indexResult++;
            }
        }
        if (index1<a1.length){
            while (index1<a1.length){
                result[indexResult]=a1[index1];
                indexResult++;
                index1++;
            }
        }
        else{
            while(index2<a2.length){
                result[indexResult]=a2[index2];
                indexResult++;
                index2++;
            }
        }
        return result;
    }

    /**
     * 进制转换
     * 栈实现
     * 输入：num:要转换的数字  base：多少进制
     * 输出：进制结果，栈顶是高位
     */
    public Stack baseConversion(int num,int base){
        Stack<Integer> r=new Stack();
        while(num>0){
            r.push(num%base);
            num = num/base;
        }
        return r;
    }

    /**
     * 括号匹配
     * 输入：括号字符串{}[]()等
     * 输出：Boolean
     */

    public boolean bracketMatch(String str){
        Stack<Character> stack=new Stack<Character>();
        for (int i =0; i<str.length();i++){
            char c=str.charAt(i);
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop()=='{'){
                        break;
                    }else{
                        return false;
                    }
                case ']':
                    if (!stack.isEmpty() && stack.pop()=='['){
                        break;
                    }else{
                        return false;
                    }
                case ')':
                    if (!stack.isEmpty() && stack.pop()=='('){
                        break;
                    }else{
                        return false;
                    }
            }
        }
        if (stack.isEmpty())return true;
        else return  false;
    }
}
