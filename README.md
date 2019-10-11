#Proxy动态代理的一个例子
## 文件说明
ProxyFactory————根据所给的目标类（待增强类）和增强方法（Advice）来创建一个代理类。<br/>
BeforeAdvice和AfterAdvice接口————增强方法<br/>
Waiter————待增强类的接口<br/>
ManWaiter、WomanWaiter————Waiter的具体实现类<br/>

## 补充
## 类增强的三种方式：
1.继承<br/>
    * 被增强对象不能变<br/>
    * 增强内容不能变<br/>
2.装饰者模式<br/>
    * 被增强对象可以变<br/>
    * 增强内容不能变<br/>
3.动态代理<br/>
    * 被增强对象可以变<br/>
    * 增强内容可以变<br/>
