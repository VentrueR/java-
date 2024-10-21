# SSM框架相关

## Spring

### 1.特性

#### IOC

##### 介绍

控制反转，控制是创建初始化销毁对象，反转是控制权交由SpringIOC容器

###### 反射

加载类，实例，调用对象

###### 设计模式

通过工厂模式来管理bean对象创建和生命周期

###### 依赖注入(DI)

SpringIOC容器通过构造方法，属性和方法注入bean

###### 容器实现

通过BeanFactory和ApplicationContext实现容器，前者基础实现，后者是拓展实现

##### 依赖倒置、依赖注入、控制反转

后者如上述，前者是一种设计原则，高层不依赖低层，共同依赖同一个抽象，抽象不依赖细节，具体实现细节依赖抽象



具体依赖抽象

##### 自己设计IOC

反射、设计模式、依赖注入、bean对象管理和作用域、异常处理和配置文件、AOP功能

#### AOP

##### 介绍

面向切面编程。与业务无关，但为业务模块共同调用

##### 功能

注册，登录，增删改查

日志管理//事务、

##### 实现机制

动态代理技术。

有实现接口 -> JDK动态代理，Proxy类和InvocationHandler接口实现

没有~ -> cglib第三方库实现（代理子类实现）

##### 执行过程和实战

**AspectJ切面**：包括切点和通知

Point Cut切点：确认连接点

**Join Point连接点**：程序方法执行，方法调用/异常处理

**Advice通知**：around,before,after拦截器，处理连接点

Introduction引介：代理对象配置目标对象

**Waving织入**：配合连接点、通知等**执行目标方法**

AOP proxy：实现代理协议的对象。

Target object目标对象：被代理的对象。

通知定义拦截器，切点确定连接点，连接点确认方法，引介和织入

实战：

1. 设计代理对象

2. 创建类加载器，接口信息，处理器对象（前两者可反射的到后者new InvocationHandler重写invoke方法）

3. 实例化并返回代理对象（反射上述参数实例化代理对象）

##### 动态代理

###### 介绍

运行时，**动态创建**代理对象。

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

事务方法调用另一个事务方法！！



会回滚：

Required默认，有则加入

Requires_new 有则新建

Nested 有则嵌入事务（共享，但不影响原来事务）

Mandtory 有则加入，无则异常

不会回滚：非事务方式运行/挂起/异常

##### 事务隔离级别

默认，mysql重读

读未提交，

读已提交，同时解决脏读

可重复读，同时解决不可重复读

可串行化，同时解决幻读（查询时好像看到了。）

##### @Transactional(rollbackFor=‘’）

默认运行时异常和error会回滚，指定其他非运行时异常哪些回滚和不会滚

##### 事务失效

**未捕获异常或运行时异常！！！**

传播事务设置不当

多数据源配置不当

跨方法和非公开方法

（调用this会失效，**事务通过动态代理控制**，没有走代理）

#### MVC架构

### 2.设计模式

工厂、代理、单例、模板

### 3.常用注解

@Autowired：按类型type从spring ioc容器取bean对象，注入到属性，可以@Qualifaier指定name来匹配bean

（Spring提供）

//@Resource：按命名name~（jdk提供）

@Component修饰类，注入bean对象

​	@Controller控制层

​	@Service服务层

​	@Repository仓储层(启动类@MapperScan或配置文件配置MapperScannerConfiguer那么可以省略)



@Configuration： 修饰配置类，定义和配置bean

@Bean: 修饰方法，方法返回值创建bean对象

### 4.Bean对象

#### 生命周期

**实例化**：创建bean 扫描xml或注解创建（ioc）反射拿到bean对象

**属性赋值**：（依赖注入）注解注入赋值

**初始化**：

实现了某些接口，可以去set



实现BeanNameAware接口 **setBeanName**（）

**setBeanClassLoaders()**

~BeanFactoryAware~ **setBeanFactory**（）

~ApplicationContextAware~ **setApplicationContext**（）



~**BeanPostProcessor**~初始化前 

**InitializingBean**属性赋值后，初始化前（），初始化bean 各种接口和方法

同上两个初始化后



**销毁bean** 先记录销毁方法再销毁destroy()

实现接口/注解/配置属性

#### 作用域

singleton单例

prototype原型（每次获取一个新的bean）

http

session

web

websocket

#### bean加载、销毁方法

！xml配置init-method 和 destroy-method

！@Bean initMethod destroyMethod

！@PostConstruct @PreDestroy

！实现initializingBean DisposableBean接口

### 5.Spring循环依赖

**单例模式**下注入，A类注入B对象，B注入A

都是Map缓存

一级缓存 实例且初始化的bean对象。

二级缓存 实例化但未完全初始化的bean对象//，未注入

三级缓存 objectFactory对象



都没有缓存，检查有依赖，则bean工厂加入三级缓存，

B注入A，通过三级缓存getObject()，存二级缓存，注入的A就读这个二级缓存。（存二级的意义在于AOP代理不希望getObject（）得到多个代理类）

//实例化bean -> 赋值，循环依赖 -> 三级缓存得引用存二级缓存 -> 一级缓存

### beanFactory 和 factoryBean

前者是核心容器，管理bean生命周期，配置元数据，依赖注入

后者特殊的Bean 用于 **自定义Bean**

## MVC

### 分层

Model 模型 实体对象，业务对象service和dao

View 视图 展现给用户

Controller 控制器 请求和响应view 和 model

### 工作流程

前端控制器/**处理器**映射器/处理器适配器/handler处理器

见图

### HandlerMapping 和 handlerAdapter

前者负责将请求映射到处理器

后者负责调用处理器处理请求

## SpringBoot

### 比较Spring

基于约定大于配置原则，实现自动配置

引入不同starter快速集成框架和库

内嵌tomcat等服务器

### 约定大于配置

自动配置

默认配置

默认约定，项目结构和bean命名

### 自动装配

简单来说 注解 + 配置（starter）

@SpringBootApplication   



-> @EnableAutoConfig/ 扫描配置类和component//componetscan和/csonfiguration

配置类和componet扫描/自动注入注解



@EnableAutoConfig

@AutoConfigurationPackage**配置包范围**

@Import({AutoConfigurationImportSelector.class})

获取所有类名加入ioc

**获取所有符合条件的类的全限定类名，这些类需要被加载到 IoC 容器中**。

获取符合条件的 类的全限定类名（包括包）

//加载自动装配类，IOC容器



SpringBoot程序启动时，会扫描外部引用jar包的META-INF/spring.factories文件，将文件的配置信息记载到spring容器从而操作其中的类

@SpringBootApplication包含

@EnableAutoConfiguration 实现自动装配

@Configuration 上下文注册bean或其他配置类

@ComponentScan 扫描、注册@Component修饰的类





### 使用starter

创建maven工程

配置META/INF/spring.factories

创建配置属性类

创建服务和处理器

（发布到maven仓库）

pom添加依赖

## Mybatis

### #{}和${}

后者是直接拼接文本替换，容易出现sql注入（攻击数据库）

前者参数占位符，会进行预编译？来代替，sql执行前set赋值

## 微服务

把一个复杂单体架构项目，拆分成多个模块应用，实现通信

-》微服务的组件：注册/配置/通信/容灾/网关/链路追踪/分布式事务/服务监控



### 优缺点

拓展性/风险（高可用性）/开发难度/团队合作/



### 微服务通信原理/场景/优劣势

http/rpc

应对跨域场景/微服务对外平台

微服务内部调用



前者http头部更臃肿/后者基于Tcp通信（报文头更轻量）

后者二进制协议更快

### 组件

注册中心/配置中心：Nacos

负载均衡：Nacos

服务通信：OpenFeign Http -> 和Dubbo -> rpc/tcp/socket(通信的约定/解决网络通信)

//配置中心：Nacos

服务保护：Sentinel

#### Nacos

配置：导入数据库表，docker部署

服务注册：添加依赖aliababa-discovery，注册中心地址

//服务发现：discoveryclien 获取服务实例 getInstance()，（负载均衡、restemplate发http）

#### OpenFein

/通用api模块包写多个服务的调用接口



服务发现：添加依赖（openfein，loadbalancer负载均衡），

实现服务发现接口，使用@FeinClient("name/url")修饰

配置okhttp连接池，添加依赖，参数开关true



使用@EnableFeinClient修饰启动类

@Feinclient(name(请求),url)

@Resource注入接口

#### Dubbo

注册中心，消费者动态代理类（不改变已有逻辑（代理类）/负载均衡）消费

rpc/tcp/socket

@EnableDubbo修饰启动类

@Dubboservice修饰接口实现类

传输对象要序列化



@DubboReference修饰注入接口对象

实现通信

#### GateWay

/通用网关模块

主要路由转发

引入依赖



请求路径走哪个微服务



配置:

id：路由规则id

uri：负载均衡和目标微服务

predict断言：请求路径

### 负载均衡

轮询

加权轮询

随机

加权随机

一致性哈希

最小活跃数

### 服务降级、限流、熔断

降级（关掉不重要业务功能，提升服务性能）  由 超时、限流、熔断（不可用）实现

## mybatiyPlus

### 常用注解

@TableName 指定表名

@TableId 指定主键，和IdType类型（AUTO\INPUT\雪花算法）

@TableField 指定属性（关键字‘’,isbool,数据库不存在）

### 常用配置

mapper包下可以定义新包

## 注解

### lombook

@Data、@NoArgsConstructor、@AllArgsConstructor、@Getter、@Setter、@EqualsAndHashCode(true)父类不影响equals..

### @Componet

@Controller @Service  @Repositroy @Mapper

组件服务声明，SpringBoot自动装配

### Request

@RequestMapping

映射处理器请求地址



@RestController = @Controller + @ResponsBody

@RequestBody

前者可修饰类和方法是将java对象转换为JSON，并写回HTTP响应体，后者修饰方法将JSON转换为java对象

### 请求参数

前者有路径参数名，后者无（拿到路径参数值）



@RequestParam ?key=123 -》 路径不写，参数指定

（path/{orderid}）@PathVariable 路径写占位符取url的参数

### 注入

构造函数注入 最推荐，保证不可变性，启动确保不为null



@Autowired 默认指定类型，配合requierd（允许忽略）,Qualifier()

@Resource 默认指定bean名，也可以指定类型



前者是spring后者jdk提供

前者可以为null，后者不可以

