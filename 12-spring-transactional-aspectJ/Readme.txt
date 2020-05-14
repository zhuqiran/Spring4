Spring的事务管理
    事务管理，原本是数据库中的概率，在Dao层，但在一般情况下需要将事务提到Service层
即业务层。这样做是为了能够使用事务的特性来管理具体的业务
在Spring中通常可以通过以下三种方式来实现对事务的管理：
    （1）使用Spring的事务代理工厂管理事务
    （2）使用Spring的事务注解管理事务
    （3）使用AspectJ的AOP配置管理事务

 1. Spring事务管理的API
    Spring的事务管理，主要用到两个事务相关的接口
  1）事务管理器接口
    事务管理器是PlatformTransactionManager接口对象。其主要用于完成事务的提交、回滚，
  及获取事务的状态信息。查看SpringAPI帮助文档：Spring框架解压目录下的docs/javadoc-api/index.html。
    定义的方法：
        void commit(TransactionStatus status);      // 提交给定的事务
        TransactionStatus getTransaction(TransactionDefinition definition);     // 获取当前活动的事务，或创建一个新的
        void rollback(TrasactionStatus status);     // 执行事务的回滚
    A 常用的两个实现类
      PlatformTransactionManager接口有两个常用的实现类：
       DataSourceTransactionManager：使用JDBC或iBatis 进行持久化数据时使用。
       HibernateTransactionManager：使用Hibernate进行持久化数据时使用。
    B Spring的回滚方式
      Spring事务的默认回滚方式是：发生运行时异常时回滚，发生受查异常时提交。不过，对于受查异常，
      程序员也可以手工设置其回滚方式。

  2）事务定义接口
    事务定义接口TransactionDefinition中定义了事务描述相关的三类常量：事务隔离级别、事务传播行为、
  事务默认超时时限，及对它们的操作。
    A 定义了五个事务隔离级别常量
      这些常量均是以ISOLATION_开头。即形如ISOLATION_XXX。
        DEFAULT：采用DB默认的事务隔离级别。MySql的默认为REPEATABLE_READ； Oracle默认为READ_COMMITTED。
        READ_UNCOMMITTED：读未提交。未解决任何并发问题。
        READ_COMMITTED：读已提交。解决脏读，存在不可重复读与幻读。
        REPEATABLE_READ：可重复读。解决脏读、不可重复读，存在幻读
        SERIALIZABLE：串行化。不存在并发问题。

    B 定义了七个事务传播行为常量
      所谓事务传播行为是指，处于不同事务中的方法在相互调用时，执行期间事务的维护情况。如，A事务中的方法doSome()
    调用B事务中的方法doOther()，在调用执行期间事务的维护情况，就称为事务传播行为。事务传播行为是加在方法上的。
      事务传播行为常量都是以PROPAGATION_ 开头，形如PROPAGATION_XXX。
         REQUIRED：指定的方法必须在事务内执行。若当前存在事务，就加入到当前事务中；若当前没有事务，则创建一个新事务。
        这种传播行为是最常见的选择，也是Spring默认的事务传播行为。
            如该传播行为加在doOther()方法上。若doSome()方法在执行时就是在事务内的，则doOther()方法的执行也加入到该事务内执行。
        若doSome()方法没有在事务内执行，则doOther()方法会创建一个事务，并在其中执行。
         SUPPORTS：指定的方法支持当前事务，但若当前没有事务，也可以以非事务方式执行。
         MANDATORY：指定的方法必须在当前事务内执行，若当前没有事务，则直接抛出异常。
         REQUIRES_NEW：总是新建一个事务，若当前存在事务，就将当前事务挂起，直到新事务执行完毕。
         NOT_SUPPORTED：指定的方法不能在事务环境中执行，若当前存在事务，就将当前事务挂起。
         NEVER：指定的方法不能在事务环境下执行，若当前存在事务，就直接抛出异常。
         NESTED：指定的方法必须在事务内执行。若当前存在事务，则在嵌套事务内执行；若当前没有事务，则创建一个新事务。

    C 定义了默认事务超时时限
      常量TIMEOUT_DEFAULT定义了事务底层默认的超时时限，及不支持事务超时时限设置的none值。
      注意，事务的超时时限起作用的条件比较多，且超时的时间计算点较复杂。所以，该值一般就使用默认值即可。



