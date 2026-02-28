package net.jguzmandev.repository;

import net.jguzmandev.model.Manager;
import net.jguzmandev.model.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopRepositoryTest {
    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void createShop(){

        Manager _manager = Manager.builder()
                .firstName("Diego")
                .lastName("Guzman")
                .build();

        Shop _show = Shop.builder()
                .name("Second shop")
                .floor("2th")
                .manager(_manager)
                .build();
        shopRepository.save(_show);
    }

    @Test
    public void findAllShop(){
        List<Shop> shopList = shopRepository.findAll();
        System.out.println("ShopList" + shopList);
    }
}