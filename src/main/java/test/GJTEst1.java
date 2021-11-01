package test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 共济科技
 * 1. 毕达哥拉斯三元组是一个整数集合｛A，B，C｝，使得A2+B2=C2，
 * 请用任意开发语言书写代码输出一个列表（以换行分割），包含所有满足A2+B2=C2，且A+B+C<=30的整数集合，并写出时间复杂度
 * @author 苞谷洁子
 * @ClassName GJTEst1
 * @date 2021/10/22 14:22
 */
public class GJTEst1 {
    public static List<int[]> solution(int n){
        List<int[]> resList = new ArrayList<>();
        for(int i = 1;i<=n/3;i++){
            boolean flag = true;
            for(int j = i+1;flag;j++){
                int temp = i*i + j*j;
                int sqrt = (int)Math.sqrt(temp);
                int sum = i + j + sqrt;
                //和大于n时，j不再后移
                if(sum > n){
                    flag = false;
                }
                if(Math.sqrt(temp) - sqrt < 10e-6){
                    int[] res = new int[]{i,j,sqrt};
                    resList.add(res);
                }
            }
        }
        return resList;
    }
    public static void main(String[] args) {
        List<int[]> solution = solution(30);
        for(int[] nums:solution){
            for(int i = 0;i<nums.length;i++){
                System.out.print(nums[i] + "\t");
            }
            System.out.println();
        }
    }
}
