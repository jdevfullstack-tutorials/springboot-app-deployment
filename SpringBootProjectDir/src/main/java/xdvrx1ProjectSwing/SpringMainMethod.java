package xdvrx1ProjectSwing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import xdvrx1ProjectSwing.MainMethod;

@SpringBootApplication
class SpringMainMethod {
    
    public static void main(String[] args) {
        
        SpringApplicationBuilder builder = 
            new SpringApplicationBuilder(SpringMainMethod.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
        
    }
    
}