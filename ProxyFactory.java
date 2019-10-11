package day27;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	private Object target;  //目标类：被增强对象
	private BeforeAdvice ba;   //前置通知
	private AfterAdvice aa;   //后置通知
	public ProxyFactory() {
		
	}
	public ProxyFactory(Object target, BeforeAdvice ba, AfterAdvice aa) {
		super();
		this.target = target;
		this.ba = ba;
		this.aa = aa;
	}
	public Object createProxy() {
		ClassLoader cl=target.getClass().getClassLoader();
		Class[] is=target.getClass().getInterfaces();
		InvocationHandler h=new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				ba.advice();
				Object res=method.invoke(target, args);
				aa.advice();
				return res;
			}
			
		};
		Object o=Proxy.newProxyInstance(cl, is, h);
		return o;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public void setBa(BeforeAdvice ba) {
		this.ba = ba;
	}
	public void setAa(AfterAdvice aa) {
		this.aa = aa;
	}
	
	
}
