package de.neuefische.orderserviceweb.service;

import de.neuefische.orderserviceweb.model.Product;
import de.neuefische.orderserviceweb.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {
    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final ProductService service = new ProductService(productRepository);

    @Test
    void listAllProductsFromRepository() {
        //GIVEN
        when(productRepository.listAllProducts()).thenReturn(List.of(
                 new Product("1", "Goldener Apfel"),
                 new Product("2", "Bio Fairtrade Kakao mit Blutdiamanten")
                ));

        //WHEN
        List<Product> productList = service.listAllProducts();

        //THEN
        assertThat(productList, containsInAnyOrder(
                new Product("1", "Goldener Apfel"),
                new Product("2", "Bio Fairtrade Kakao mit Blutdiamanten")
        ));

    }

    /*@Test
    void getProductById() {
    }

    @Test
    void addProduct() {
    }*/
}


/*
    @Test
    public void listShouldReturnAllStudentsFromRepository() {
        //GIVEN
        when(studentRepository.list()).thenReturn(List.of(
                new Student("1", "Frank"),
                new Student("2", "Jan")
        ));

        //WHEN
        List<Student> list = service.list();

        //THEN
        assertThat(list, containsInAnyOrder(new Student("1", "Frank"),
                new Student("2", "Jan")));
    }
*/