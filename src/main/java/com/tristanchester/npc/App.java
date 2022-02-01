package com.tristanchester.npc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.tristanchester.npc")
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
}
/* 
 * TODO: Refactor Request Mappings in entity controllers to remove plurals
 */