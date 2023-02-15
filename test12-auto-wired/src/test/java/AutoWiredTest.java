import cn.cuiper.aware.UseAware;
import cn.cuiper.config.MySpringConfig;
import cn.cuiper.service.CarService;
import cn.cuiper.service.ColorService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySpringConfig.class)
public class AutoWiredTest {

    @Autowired
    @Qualifier(value = "audiServiceImpl")
    private CarService carService;

    @Autowired(required = false)
    private ColorService colorService;

    @Autowired
    private UseAware useAware;

    /* @Autowired
    * 自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
    * 如果IoC容器中没有任何bean的类型和要注入的变量的类型匹配，启动则报错。@Autowired有一个属性required，默认为true。如果设置为false，则该对象可以在获取不到bean时默认为null。
    * 如果IoC容器中该类型的bean存在多个，则将要注入的变量的变量名作为bean的id进行二次匹配：
    *   如果根据变量名可以找到唯一的bean，则进行注入。
    *   如果根据变量名匹配不到，则报错。
    * 出现位置：可以使属性上，也可以是方法、参数上。
    *
    * 细节：在使用注解进行注入时，变量的setter方法就不是必须的。
    * 使用构造函数进行注入时，需要标注final来表示这个注入的变量不能被改变。
     * */

    /*@Qualifier
    * 在按照类型匹配的基础上，再按照名称匹配注入。
    * 它在给类的成员变量注入时，不能单独使用，要和@Autowired配合使用。
    * 它在给方法参数进行注入时，可以单独使用。
    * value：用于指定要注入的bean的id。
    * */

    /*@Primary
    * 让Spring自动装配时默认使用首选的Bean。
    * 优先级 @Qualifier > @Primary > @Autowired
    * */

    /*
    * @Resource JSR250规范。直接按照bean的id进行注入。再根据类型
    * 直接按照bean的id进行注入。
    * @Inject JSR330规范。 需要导入依赖;和@Autowired功能类似，但是没有required属性。
    * */

    @org.junit.Test
    public void test() {
        carService.back();
    }
}
