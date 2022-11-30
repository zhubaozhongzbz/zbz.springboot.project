package java8.java8.final_test;

//在参数列表中，将参数声明为 final 意味着在方法中不能改变参数指向的对象或基本变量：
//方法 f() 和 g() 展示了 final 基本类型参数的使用情况。你只能读取而不能修改参数。这个特性主要用于传递数据给匿名内部类。
class Gizmo {
    public void spin() {

    }
}

public class FinalArguments {
    void with(final Gizmo g) {
        //-g = new Gizmo(); // Illegal -- g is final
    }

    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g is not final
        g.spin();
    }

    //void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive
    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}