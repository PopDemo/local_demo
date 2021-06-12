import java.lang.reflect.Field;

public class MethodTest{

    /**
     * 面试题01
     * fix: demo而此时
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        A a = new A();
        Field[] fields = A.class.getDeclaredFields();
        for(Field field : fields){
//            // 屏蔽私有化开关
//            field.setAccessible(true);
            System.out.println(field.get(a));
        }
    }

}

class A{
    private String name = "1";
    public int age = 1;
}