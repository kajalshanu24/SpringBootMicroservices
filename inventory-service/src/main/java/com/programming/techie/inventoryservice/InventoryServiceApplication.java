package com.programming.techie.inventoryservice;

import com.programming.techie.inventoryservice.model.Inventory;
import com.programming.techie.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    //This is added as inventory service is querying DB to fetch data but initially there will be no record, so in order to
    //set some required in DB, below lines of code are written.
    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone-13-green");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone-13-blue");
            inventory1.setQuantity(10);

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }

    /*@Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean(Environment env) throws UnknownHostException {
        EurekaInstanceConfigBean bean = new EurekaInstanceConfigBean(env);
        bean.setInstanceId(instanceId(env));
        return bean;
    }

    private String instanceId(Environment env) throws UnknownHostException {
        String appName = env.getProperty("spring.application.name");
        String hostname = InetAddress.getLocalHost().getHostName();
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        int port = env.getProperty("server.port", Integer.class, 0);
        return appName + ":" + hostname + ":" + ipAddress + ":" + port;
    }*/
}
