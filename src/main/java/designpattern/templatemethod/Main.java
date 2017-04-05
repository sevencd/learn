package designpattern.templatemethod;

public class Main {
	public static void main(String[] args) {
		 // 声明抽象类
        AbstractClass c;

        // 用ConcreteClassA实例化c
        c = new ConcreteClassA();
        c.TemplateMethod();

        // 用ConcreteClassB实例化c
        c = new ConcreteClassB();
        c.TemplateMethod();
        
	}
}
