# Spring框架相关

## Spring

### 1.特性

#### IOC

##### 介绍

控制反转，控制是创建初始化销毁对象，反转是控制权交由SpringIOC容器

##### 实现机制

###### 反射

java特性

###### 设计模式

通过工厂模式来管理bean对象创建和生命周期

###### 依赖注入(DI)

SpringIOC容器通过构造方法，属性和方法注入bean

###### 容器实现

通过BeanFactory和ApplicationContext实现容器，前者基础实现，后者是拓展实现

##### 依赖倒置、依赖注入、控制反转

后者如上述，前者是一种设计原则，高层不依赖低层，共同依赖同一个抽象，抽象不依赖细节，具体实现细节依赖抽象

##### 自己设计IOC

反射、设计模式、依赖注入、bean对象管理和作用域、异常处理和配置文件、AOP功能

#### AOP

##### 介绍

面向切面编程。可以把业务无关的代码，需要调用的共同模块封装，解耦。

##### 功能

注册，登录，增删改查

事务、日志管理

##### 实现机制

动态代理技术。

有实现接口 -> JDK动态代理，Proxy类和InvocationHandler接口实现

没有~ -> cglib第三方库实现

##### 执行过程和实战

AspectJ切面：包括切点和通知

Point Cut切点：确认连接点

Join Point连接点：程序方法执行，方法调用、异常处理

Advice通知：around,before,after拦截器，处理连接点

Introduction引介：代理对象配置目标对象

Waving织入：配合连接点、通知等执行目标方法

AOP proxy：实现代理协议的对象。

Target object目标对象：被代理的对象。

通知定义拦截器，切点确定连接点，连接点确认方法，引介和织入

实战：

1. 设计代理对象

2. 创建类加载器，接口信息，处理器对象（前两者可反射的到后者new InvocationHandler重写invoke方法）

3. 实例化并返回代理对象（反射上述参数实例化代理对象）

##### 动态代理

###### 介绍

运行时，动态创建代理对象。

###### 功能

不修改原始类，对方法增强和拦截

###### 静态代理

取决于能否在编译时确认代理对象。

##### 常用注解

@Aspect修饰类

@PointCut修饰方法

@Around方法执行前后

@Before方法执行前

@After方法执行后

@AfterReturning且返回

@AfterThrowing且抛出异常

@Advice（替代before和after）

#### 事务管理

##### 方式

手动硬编码，创建TransactionTemplate

注解@Transtactional

##### 事务传播行为

会回滚：

Required默认，有则加入

Requires_new 有则新建

Nested 有则嵌入事务

Mandtory 有则加入，无则异常

不会回滚：

##### 事务隔离级别

默认，mysql重读

读未提交，

读已提交，同时解决脏读

可重复读，同时解决不可重复读

可串行化，同时解决幻读（查询时好像看到了。）

##### @Transactional(rollbackFor=‘’）

默认运行时异常和error会回滚，指定其他非运行时异常哪些回滚和不会滚

##### 事务失效

未捕获异常或运行时异常

传播事务设置不当

多数据源配置不当

跨方法和非公开方法

（调用this会失效，事务通过动态代理控制，没有走代理）

#### MVC架构

### 2.设计模式

工厂、代理、单例、模板

### 3.常用注解

@Autowired：按类型type从spring ioc容器取bean对象，注入到属性，可以@Qualifaier指定name来匹配bean

（Spring提供）

@Resource：按命名name~

（jdk提供）

@Component修饰类，注入bean对象

​	@Controller控制层

​	@Service服务层

​	@Repository仓储层(启动类@MapperScan或配置文件配置MapperScannerConfiguer那么可以省略)

@Bean: 修饰方法，方法返回值创建bean对象

@Configuration： 修饰配置类，定义和配置bean

### 4.Bean对象

#### 生命周期

创建bean 扫描xml或注解创建

bean赋值 注解注入赋值

初始化bean 各种接口和方法

销毁bean 先记录销毁方法再销毁

#### 作用域

singleton单例

prototype原型

每次获取一个新的bean

http

session

web

websocket

#### bean加载、销毁方法

xml配置init-method 和 destroy-method

@Bean initMethod destroyMethod

@PostConstruct @PreDestroy

实现initializingBean DisposableBean接口

### 5.Spring循环依赖

单例模式下setter方法注入，A类有B属性，B有A

都是Map缓存

一级缓存 实例且初始化的bean对象。

二级缓存 实例未初始化的bean对象 即引用

三级缓存 objectFactory对象

实例化bean -> 赋值，循环依赖 -> 三级缓存得引用存二级缓存 -> 一级缓存

## MVC

### 分层

Model 模型 实体对象，业务对象service和dao

View 视图 展现给用户

Controller 控制器 请求和响应view 和 model

### 工作流程

见图



