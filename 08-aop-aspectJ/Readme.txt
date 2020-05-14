1. AspectJ对AOP的实现
    对于AOP这种编程思想，很多框架都进行了实现。Spring就是其中之一，可以完成面向切面编程。然而，AspectJ也实现了AOP的功能，
且其实现方式更为简捷，使用更为方便，而且还支持注解式开发。所以，Spring又将AspectJ的对于AOP的实现也引入到了自己的框架中。
在Spring中使用AOP开发时，一般使用AspectJ的实现方式。

2. AspectJ的通知类型
    AspectJ中常用的通知有五种类型：
    （1）前置通知
    （2）后置通知
    （3）环绕通知
    （4）异常通知
    （5）最终通知
    其中最终通知是指，无论程序执行是否正常，该通知都会执行。类似于try..catch中的finally代码块。

3. AspectJ的切入点表达式execution()
    AspectJ除了提供了六种通知外，还定义了专门的表达式用于指定切入点。表达式的原型是：
        execution ( [modifiers-pattern] 访问权限类型
        ret-type-pattern 返回值类型
        [declaring-type-pattern] 全限定性类名
        name-pattern(param-pattern) 方法名(参数名)
        [throws-pattern] 抛出异常类型
        )
    切入点表达式要匹配的对象就是目标方法的方法名。所以，execution表达式中明显就是方法的签名。注意，表达式中加[ ]的部分表示可省略部分，
    各部分间用空格分开。在其中可以使用以下符号：
        * 0个至多个任意字符
        .. 用在方法参数中，表示任意多个参数。用在包名后，表示当前包及子包路径
        +  用在类名后，表示当前类及其子类。用在接口后，表示当前接口及其实现类

4. AspectJ的开发环境

1)导入两个Jar包
    AspectJ是专门针对AOP问题的，所以其运行是需要AOP环境的，即需要之前的AOP的两个Jar包。
另外，还需要AspectJ自身的Jar包：在Spring支持库解压目录中的子目录org.aspectj下有两个子包：
    com.springsource.org.aspectj.tools
    com.springsource.org.aspectj.weaver

    一般情况下，使用weaver包中的Jar即可。tools中的Jar除了包含weaver中类库外，还包含了其它
工具，但一般不用。所以，使用weaver包中的Jar即可。

    当然，在Spring中使用AspectJ，还需要将它们联系一起的整合Jar包。在Spring框架解压目录的libs中。
    spring-aspectj
2)引入AOP约束
    在配置文件头部，要引入关于aop的约束。在Spring框架的解压目录中，\docs\spring-framework-reference\html下的
xsd-configuration.html文件中。
    the aop schema
    xmlns:aop="http://www.springframework.org/schema/aop" xsi:schemaLocation="
            http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd"

    在前面Spring实现AOP时，并未引入AOP的约束，而在AspectJ实现AOP时，才提出要引入AOP的约束。说明，配置文件
中使用的AOP约束中的标签，均是AspectJ框架使用的，而非Spring框架本身在实现AOP时使用的。

    AspectJ对于AOP的实现有两种方式：
     （1）注解方式
     （2）XML方式

5. AspectJ基于注解的AOP实现






































