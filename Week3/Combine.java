package demo.leecode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 23:29
 * @Description: https://leetcode-cn.com/problems/combinations/ 77. 组合
 */
public class Combine {


    /*List<List<Integer>> result = new ArrayList<>();
    int k;

    public List<List<Integer>> combine(int n, int k) {
        LinkedBlockingDeque<Integer> lbd = new LinkedBlockingDeque(k);
        this.k = k;
        combine(lbd, n, 1);
        return result;
    }

    private void combine(LinkedBlockingDeque<Integer> lbd, int n, int lastNum) {
        if (lbd.size() == k) {
            result.add(new ArrayList<>(lbd));
            return;
        }
        if (n - lastNum +1 >= k - lbd.size()) {
            for (int i = lastNum; i <= n; i++) {
                lbd.offer(i);
                combine(lbd, n, lbd.getLast() + 1);
                lbd.removeLast();
            }
        }
    }*/

    private List<List<Integer>> res;
    private int k,n;
    public List<List<Integer>> combine(int n, int k) {
        res=new ArrayList<>();
        this.k=k;
        this.n=n;
        if(k>n) return res;
        trace(new ArrayList<>(),1,0);
        return res;
    }

    private void trace(List<Integer> list,int index,int count){
        if(count==k){
            res.add(new ArrayList<>(list));
            return;
        }
        if((n-index+1)<k-count) return;
        for (int i=index;i<=n;i++){
            list.add(i);
            trace(list,i+1,count+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("start...");
        List<List<Integer>> result = new Combine().combine(4, 2);
        for (List<Integer> list : result) {
            list.forEach(System.out::print);
            System.out.println("");
        }
        System.out.println("end...");
    }
}
