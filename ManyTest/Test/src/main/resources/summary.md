1.获取类对象
//常用类的路径获取
Class clazz = Class.forName("test.reflection.Student")

2.获取类构造器
//从参数类型获取
Constructor con = clazz.getDeclaredConstructor(int.class);
去除权限修饰符
con.setAccessible(true);
调用构造方法
Object obj = con.newInstance(21);

3.获取成员变量
//从引用对象获取,还可以getFiles()
Field filed = clazz.getDeclaredFiled("phoneNum");
filed.setAccessible(true);
//设置值
//权限来new
obj = clazz.getConstructor().newInstance();
filed.set(obj, "110")

4.获取成员方法
//从引用对象和方法类型获取
Method method = clazz.getDeclaredMethod("show4", int.class);
method.setAccessible(true);
//调用成员方法
Object res = method.invoke(obj, 21);

5.配置文件获取反射

6.文件读写
new file
createNewFile()
new FileWriter(file)
writer.write("").flush().close()
new FileReader(file)
fr.read(a);//读到字符数组中去
