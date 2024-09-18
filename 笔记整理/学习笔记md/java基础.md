# Java基础

## 1.概念

### 特点

平台无关：字节码文件一次编译，可以在各个有Java虚拟机的系统多处运行

面向对象：封装、继承、多态

内存管理：JVM垃圾回收

### 编译过程

字节码好处->编译与解释共存

见绘图 

### JVM、JDK、JRE

JDK 包含 JRE 包含 JVM

JDK 开发工具包 工具集合。除包含外，javac，工具类

JRE 运行环境，提供环境

JVM 虚拟机，包含JIT，java程序运行环境，把字节码文件映射到CPU指令集和OS系统调用

### 编译、解释型语言

编译：把源文件编译成机械码或字节码，生成可执行文件。开发慢、效率高。C、CPP、Go、Rust

解释：直接把源文件逐行解释。开发快，效率低。Python、JS、PHP

### JavaSE、JavaEE区别

EE实现分布式，web程序开发

### python java cpp区别

python解释型，逐行解释

java 编译解释型，过程

单继承、指针不暴露、只允许方法重载、JVM内存管理垃圾回收

cpp 编译型



## 2.语法

### 注释

单行、多行、文档

### 标识符和关键字

关键字是特殊的标识符

#### 权限修饰符

public 共有

protected 可以同父类

确省 可以同包

private 只能当前class

#### 修饰类、接口、方法、变量

final native static

## 3.Java数据类型

### 形参和实参

​	调用方法接收的是形参，传入的是实参

### 基本数据类型

#### 基本类型 

​	八大基本类型

#### 引用类型

 	1. 类（包括String、包装类、枚举、注解）
 	2. 接口
 	3. 数组

### 值对象和引用对象

​	就是按值类型和引用类型答

 	1.  举例包括哪些
 	2.  用途: 前者多用于常量和局部变量，其余都用后者传参、类的属性
 	3.  存储方式：值对象是直接存储在栈上，引用对象中引用也分配在栈上分配内存，具体信息是存储在堆中。
 	4.  比较方式上： 前者用==比较值，后者比较一般用equals方法比较
 	5.  占用空间
 	6.  默认值

### 值传递和引用传递

java只有值传递，形参对实参值拷贝和引用拷贝，安全

### 数据转化

#### 方式

隐式（小转大）、显式（强制大转小）、字符串、字符和整形。

#### 出现的问题

丢失数据精度、溢出、安全

### 包装类型

#### 区别

引用对象和值对象区别

#### 装拆箱

装箱 转化成引用对象 valueOf()

拆箱 转化成值对象 intValue()

#### 缓存

除了浮点都有

Character 0~127

Boolean

其他-128 ~ 127（ValueOf()）

### 变量

#### 成员变量和局部变量

修饰符和static不能修饰局部变量（脱离了类的限制）

#### 静态变量

类共享

#### 字符型常量和字符串常量

值对象和引用对象

### 方法

#### 类型

参数 和 返回值确定

#### 静态方法和实例方法

类调用和实例调用，访问类成员限制

#### 重写重载

重写：@Override 子类对父类方法

重载：同名 允许不同返回类型、修饰符、参数

#### 可变参数

String  ...args

## 4.面向对象

### 面向对象和面向过程

抽象成对象，用对象执行方法

抽象过程，按一个个方法解决

### 对象实体和对象引用

一对多，栈堆

### 构造方法

不自写也行。有默认。

类名相同，无返回值，自动执行

### 三大特征

#### 封装

被封装与外界隔绝，通过类对象的接口访问。

#### 继承

子类对父类属性、方法继承，对父类功能扩展

#### 多态

父类引用实例化子类。增强延展性。

注：不能执行子类有父类没有的方法。

### 接口和抽象类

#### 共性

不能实例化

都可以有抽象方法

#### 区别

##### 用途

接口是行为定义，抽象类是简化复用流程

##### 继承实现

单继承，多实现

##### 变量

接口默认public static final

##### 方法

jdk1.8之前 public abstract

jdk1.8 default 和 static

jdk1.6 private

### 引用拷贝 浅拷贝 深拷贝

引用拷贝：只是引用不同，指向相同堆内存对象

浅拷贝：在堆中new了新对象，但是指向相同对象实例

深拷贝：不同对象实例

### Object类

#### 常见方法

getClass,equals,hashCode,toString,clone,wait,notify

#### ==和equals

equals重写：比较对象相等

== ： 比较值或者地址相同

#### hashcode

获取哈希码，影响哈希表中索引位置。和equals配套比较

### final修饰符

修饰的变量，方法，类，类不能继承，方法不能重写，变量不可改变

### String类

#### String,StringBuilder,StringBuffer

String 不可变

可变，没有被private final修饰

StringBuilder线程不安全，效率相对高

StringBuffer线程安全，效率相对低

append方法连接字符串

#### String不可变

final修饰了String类和用于存储的字符数组

#### String、Object的 equals
前者重写，后者未重写

####  字符串常量池

JVM里面池化，减少字符串存储和运算开销

##### String s = new String("abc")创建了多少个字符串对象？

#### intern方法

native方法，一般直接返回字符串常量池地址

#### String 的+

jdk9之前 会创建个很多个StringBuilder

常量折叠

在编译时确认的常量。基本类型，字符串、final修饰，String+ 基本类型加减乘除移位运算

比如String 被 final修饰后会直接常量折叠得到结果，走常量池

String a = str1+str2

### 非静态内部类和静态内部类

后者可以定义静态变量、只能访问外部类静态变量，外部类实例才能访问外部私有变量和方法，可以独立实例不依赖外部类

## 5.异常

### 介绍

Throwable类的Exception和Error类

Exception又分

非运行时异常（checked）classNotFoundException

运行时（unchecked）RuntimeException

### 处理

try-catch-finally捕获异常

其中finally 通常用于释放资源

throw 手动抛出异常

throws 传递给调用者处理

 ### 什么时候不用throws

内部已经捕获 或者 unchecked

### try-catch-finally 中finally不一定会执行

	1. 虚拟机终止运行
	1. 程序所在线程死亡
	1. 关闭cpu

## 6.泛型	

是一种特性。

类、接口、方法定义时使用一个或多个参数。

## 7.反射

### 是什么

特性。能在程序运行时，动态获取类信息，创建对象实例，修改字段，调用方法

### 创建对象的方式

new、Class类或Constructor类来newInstance()、clone、反序列化

### 实战

#### 获取class对象

类名获取、实例对象获取、类名路径获取（java包开始）

#### 构造器、方法、属性

## 8.注解

一种特殊的注释，修饰类、方法、变量。

场景：编译时直接扫描，运行时反射

## 9.IO

### 字节流

#### 组成

InputStream、OutputStream父类

#### 常用字节流

FileInputStream、FileOutputSream常用配套使用，指定路径 

read()可单个读，可读char[]

DataInputStream 读取具体类型数据

ObjectInoutStream 反序列化

#### 场景

读取原实字节（字节是文件读写和网络发送的最小信息单元）

一般是音视频、图片

### 字符流

#### 组成

Reader、Writer

InputStreamReader 字节流转字符流桥梁

FileReader 操作字符

#### 区别

字符是jvm转化字节得来。

字节流编码乱码问题。

#### 场景

文本操作

#### 编码格式

实例化桥梁，构造方法自定义编码格式（第一参指定字节流）

unicode默认 2字节

utf-8 中文3字节

gbk 中文2字节

### 字节、字符缓冲流

缓冲区byte，相对普通流减少io

### 三大常见IO模型

#### BIO

同步阻塞

#### NIO

同步非阻塞



selector：核心，实现IO多路复用，替代线程轮询IO、避免线程阻塞

channel、buffer：实现非阻塞，IO写入缓冲区，不再阻塞等待。数据从通道读缓冲区(或缓冲区写通道)



线程通过selector处理channel注册事件



NIO网络框架netty

#### AIO

异步

基于事件和回调函数实现

## 10.序列化和反序列化

### 场景

字节流便于传输

boot项目把类转换成JSON格式字符串，字符串实现序列化，默认序列化ID-..

### 序列化ID

一般显示设置，增删改会改变隐式ID

### 实战细节

Object字节流操作，直接对class对象操作（实现Serializable(标记)）

transient修饰的属性不被序列化(密码)

static 不序列化，从jvm中获取（反序列化之前修改 有无static修饰的属性得来）

static transient 同时用 不序列化

final 序列化，final transient 不序列化

## 11.工具类

### Random

r = new random -> nextInt(b-a) + a或nextDouble*(b-a) + a -> (a,b)

### 时间类

Date

Calender

## 12.Java新特性

jdk8 

### 时间API

LocalDateTime相关：LocalDateTime、LocalDate、LocalTime

.of方法设置时间

Zone 时区相关：ZoneId、ZoneDateTime

Instant：时间戳

DateTimeFormatter：时间格式化、线程安全

.ofPattern()

间隔 Duration、Period



### lambda表达式

参数 ->方法体（单复句）

### 方法和构造器引用

#### 方法

对象 ：：实例方法 参数和返回值相同或一致（装拆箱、多态），返回方法来替代

类 ：：静态方法 ~~~

前两者都是方法b覆盖抽象方法a



类 ：： 实例方法

抽象方法a参数为n,方法b为n-1，a分第一个参数调用者，后n-1参数和返回值相同或一致

#### 构造器

类 ：： new

#### 数组

数组名 ：： new

### stream流

#### 实例化

集合生成 list.stream() 或list.prallelStream

数组生成 Arrays.stream(方法名)

of默认方法生成 Stream.of(...)

#### 操作

filter(条件过滤) distinct(去重 equals 和 hashcode) skip(跳过前面的x项) limit（只要前面的x项）

map(映射对象) sorted(排序器)

#### 终止

匹配与查找

allMatch、anyMatch、noneMatch

findfirst、findAny

count、max、min、forEach

归约

reduce(初始值，lambda)

collect(Collectors.toList())

## 补充：持久化

### 文件

### 序列化和反序列化

### 数据库

关系和非关系型
