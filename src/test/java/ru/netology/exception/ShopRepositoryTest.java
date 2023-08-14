package ru.netology.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void removeWhenExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "Хлеб", 50);
        Product product2 = new Product(20, "Молоко", 100);
        Product product3 = new Product(30, "Сыр", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(30);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "Хлеб", 50);
        Product product2 = new Product(20, "Молоко", 100);
        Product product3 = new Product(30, "Сыр", 500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(40);
        });
    }
}
