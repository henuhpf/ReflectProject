package rjxy.henu.annotation;

import java.lang.annotation.*;

/**
 元注解 : 用于描述注解的注解
    @Target 注解能够作用的位置
        * ElementType 取值:
            * TYPE : 可以作用于类上
            * METHOD : 可以作用于方法上
            * FIELD : 可以作用于成员变量上

    @Retention 注解被保留的阶段
        @Retention(RetentionPolicy.RUNTIME) : 当前被描述的注解，会被保留到 class 字节码文件中，并被 JVM 读取到

    @Documented 注解是否被抽取到 api 文档中

    @Inherited 注解是否被子类继承
 */

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD}) // 表示 @MyAnno3 注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno3 {
}
