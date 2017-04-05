package designpattern.templatemethod;

/// <summary>
/// 抽象类
/// </summary>
public abstract class AbstractClass {
	// 一些抽象行为，放到子类去实现
	public void PrimitiveOperation1() {
		System.out.println("father 1");
	};

	public abstract void PrimitiveOperation2();

	/// <summary>
	/// 模板方法，给出了逻辑的骨架，而逻辑的组成是一些相应的抽象操作，它们推迟到子类去实现。
	/// </summary>
	public void TemplateMethod() {
		System.out.println(this.getClass().getName());
		this.PrimitiveOperation1();
		this.PrimitiveOperation2();
		System.out.println("Done the method.");
	}
}
