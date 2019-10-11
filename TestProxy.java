package day27;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

	public static void main(String[] args) {
		/*
		 * 参数：
		 * 1.ClassLoader
		 * 2.Class[] interface接口数组
		 * 3.InvocationHandler
		 */
		//增强对象target
		ManWaiter mw=new ManWaiter();
		WomanWaiter ww=new WomanWaiter();
		//增强方法——advice()
		BeforeAdvice ba=new BeforeAdvice() {
			@Override
			public void advice() {
				System.out.println("hello!");
			}
		};
		AfterAdvice aa=new AfterAdvice() {
			@Override
			public void advice() {
				System.out.println("Bye-bye!");	
			}
		};
		ProxyFactory pf=new ProxyFactory(mw,ba,aa);
		Waiter amw=(Waiter)pf.createProxy();//这个地方只能cast to Waiter接口 而不能是ManWaiter 接口的实现类
											//逻辑上是这样的：因为proxy代理类是针对指定的接口创建的，所以它只有接口有的方法，对于ManWaiter里的其他方法是没有的，所以不能转成具体实现类
		amw.serve();
		pf.setTarget(ww);
		Waiter aww=(Waiter)pf.createProxy();
		aww.serve();
	}
	public void fun() {
		InvocationHandler h=new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("proxy");
				return null;
			}
		};
		Object o=Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[] {A.class,B.class}, h);
		A a=(A)o;
		B b=(B)o;
		a.a();
		b.b();
		o.toString();

		o.getClass();
	}
}

interface A{
	
	public void a() ;
}
interface B{
	
	public void b() ;
}