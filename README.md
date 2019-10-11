#Proxy动态代理的一个例子
ProxyFactory————根据所给的目标类（待增强类）和增强方法（Advice）来创建一个代理类。
BeforeAdvice和AfterAdvice接口————增强方法
Waiter————待增强类的接口
ManWaiter、WomanWaiter————Waiter的具体实现类

补充
类增强的三种方式：
1.继承
    * 被增强对象不能变
    * 增强内容不能变
2.装饰者模式
    * 被增强对象可以变
    * 增强内容不能变
3.动态代理
    * 被增强对象可以变
    * 增强内容可以变
