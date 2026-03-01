package net.jguzmandev.repository;

import net.jguzmandev.model.Manager;
import net.jguzmandev.model.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void findAllManager(){
        List<Manager> managers = managerRepository.findAll();
        System.out.println("Managers" + managers);
    }

    @Test
    public void getManagerWithShopById(){
        Manager _manager = managerRepository.getManagerWithShopById(202L);
        System.out.println("Manager: " + _manager);
        System.out.println("Shop: " + _manager.getShop());
    }
}