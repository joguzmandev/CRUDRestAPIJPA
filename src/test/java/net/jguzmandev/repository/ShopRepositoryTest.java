package net.jguzmandev.repository;

import net.jguzmandev.model.Manager;
import net.jguzmandev.model.Order;
import net.jguzmandev.model.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ManagerRepository managerRepository;

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
    //@Transactional
    //@Rollback(true)
    public void createShopWithOrders(){

        Manager _manager = Manager.builder()
                .firstName("Carolina")
                .lastName("Vasquez")
                .build();


        Order _or1 = Order.builder()
                .description("Order 3")
                .price(10.0)
                .build();

        Order _or2 = Order.builder()
                .description("Order 4")
                .price(8.5)
                .build();

        Shop _shop = Shop.builder()
                .name("Supermercado 2")
                .floor("2th")
                .manager(_manager)
                .orders(List.of(_or1, _or2))
                .build();
        _or1.setShop(_shop);
        _or2.setShop(_shop);
        shopRepository.save(_shop);
    }

    @Test
    public void findAllShop(){
        List<Shop> shopList = shopRepository.findAll();
        System.out.println("ShopList" + shopList);
    }
}