package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@PropertySources({
        @PropertySource("classpath:/example.properties"),
        @PropertySource("classpath:/another.properties")
})
@Configuration
public class UsingProperty {
    @Autowired
    Environment env;

    @Value("${Laptopof}")
    String LaptopName;

    @Value("${Processor:Intel}")
    String ProcessorName;

    @Value("${Harddriveof}")
    String HardDriveName;

    @Value("${Windowsversion}")
    int WindowsVersion;

    @Value("${Displayof}")
    String DisplayName;

    public void readProp(){
        System.out.println(LaptopName);
        System.out.println(HardDriveName);
        System.out.println(WindowsVersion);
        System.out.println(DisplayName);
        System.out.println(ProcessorName);
    }

    public void readProperty(){
        String str1 = env.getProperty("Laptopof");
        String str2 = env.getProperty("Displayof");
        String str3 = env.getProperty("Windowsversion");
        String str4 = env.getProperty("Harddriveof");

        System.out.println(str1 + "\n" + str2 + "\n" +str3 + "\n" + str4);
    }
}