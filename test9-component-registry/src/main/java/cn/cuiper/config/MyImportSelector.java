package cn.cuiper.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 根据类全路径，注册bean
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"cn.cuiper.pojo.Person", "cn.cuiper.pojo.User",
                "com.alibaba.druid.util.Base64", "com.alibaba.druid.util.MySqlUtils"};
    }
}
