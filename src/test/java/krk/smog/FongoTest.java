package krk.smog;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import krk.smog.config.FongoApplicationConfig;

/**
 * Meta annotation comprising @SpringBootTest and @ActiveProfiles("test").
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringBootTest
@ActiveProfiles
@ContextConfiguration
public @interface FongoTest {

    @AliasFor(annotation = ActiveProfiles.class, attribute = "profiles")
    String[] activeProfiles() default {"test"};

    @AliasFor(annotation = ContextConfiguration.class, attribute = "classes")
    Class<?>[] contextConfiguration() default {FongoApplicationConfig.class};
}
