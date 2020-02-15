package baseclass;

public class FloatPrecision {
    public static void main(String[] args) {
        fun2();
        KahanSummation();
    }

    //浮点数精度丢失
    private static void fun1() {
        float a = 20000000.0f;
        float b = 1.0f;
        float c = a + b;
        System.out.println("c is " + c);
        float d = c - a;
        System.out.println("d is " + d);
    }

    //浮点数精度丢失
    private static void fun2() {
        float sum = 0.0f;
        for (int i = 0; i < 20000000; i++) {
            float x = 1.0f;
            sum += x;
        }
        System.out.println("sum is " + sum);
    }
    //Kahan Summation的算法解决浮点数精度丢失问题
    //这个算法的原理其实并不复杂，就是在每次的计算过程中，都用一次减法，把当前加法计算中损失的精度记录下来，
    // 然后在后面的循环中，把这个精度损失放在要加的小数上，再做一次运算
    private static void KahanSummation(){
        float sum = 0.0f;
        float c = 0.0f;
        for (int i = 0; i < 20000000; i++) {
            float x = 1.0f;
            float y = x - c;
            float t = sum + y;
            c = (t-sum)-y;
            sum = t;
        }
        System.out.println("sum is " + sum);
    }
}
