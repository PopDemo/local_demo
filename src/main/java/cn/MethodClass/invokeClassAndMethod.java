package cn.MethodClass;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.MethodInfo;

import java.lang.reflect.Method;

public class invokeClassAndMethod {
    /**
     * java反射三种方式进行处理
     *  1. Class.forName
     *         Class<?> dogClass = Class.forName("com.example.demo.dto.Dog");
     *         Method method = dogClass.getDeclaredMethod("dogToString",String.class,String.class,String.class,String.class);
     *         method.setAccessible(true);
     *         String outMsg = (String) method.invoke(dogClass.newInstance(),"美乐","1.7","2","borck");
     *         System.out.println(outMsg);
     *  2. object.getClass
     *         public void getMethod(Object object){
     *             Object objectClass = object.class();
     *         }
     *  3. 被反射类.class
     *         public void getMethod(Dog dog){
     *             Object dogClass = dog.class();
     *         }
     */


    Logger log = LoggerFactory.getLogger("Test invoke main");

  class Cat{

      public void sum(){
          System.out.println("i like jingjing");
      }

      public void sumToParamtites(String name,Integer sums){
          System.out.println("method out input SUCCESS");
          System.out.println("i like jingjing and name="+name+"  sums="+sums);
      }


  }


  class Jjing extends Cat{
      @Override
      public void sum() {

          super.sum();
          System.out.println("i name is catAndJjing");
      }
  }

    @Test
    public void main() throws Exception{
        Class<?> catClass = Class.forName("cn.MethodClass.Cat");
        Object catforclass = catClass.newInstance();

        Method mtfromCat = catClass.getDeclaredMethod("sumToParamtites", String.class, Integer.class);
        //如果反射的方法是私有的,则需要 setAccessible 去进行跳过 java安全程序的限制
        mtfromCat.setAccessible(true);
        //通过invoke去进行调用该方法 去进行使用
        mtfromCat.invoke(catClass.newInstance(),"ang",1);



        // getDeclaredMethod去进行获取 Cat 类中的方法
       /* Method carMethod = Cat.class.getDeclaredMethod("sum");
        Method JjingMethod = Jjing.class.getDeclaredMethod("sum");

        Cat cat = new Cat();
        Jjing jjing = new Jjing();

        carMethod.invoke(jjing);
        carMethod.invoke(cat);
q1a``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
        JjingMethod.invoke(jjing);
        JjingMethod.invoke(cat);*/

    }



}
