package rjxy.henu.annotation;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;
@Pro(className = "rjxy.henu.annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法

        //1. 解析注解
        //1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2. 获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        /*
            public class  ProImpl implements  Pro{
                @Override
                public String className() {
                    return "rjxy.henu.annotation.Demo1";
                }

                @Override
                public String methodName() {
                    return "show";
                }
                @Override
                public Class<? extends Annotation> annotationType() {
                  return Pro.class;
                }
            }
         */
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //3. 调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }

}
