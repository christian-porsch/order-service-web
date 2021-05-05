package de.neuefische.orderserviceweb.service;

import de.neuefische.orderserviceweb.model.Product;
import de.neuefische.orderserviceweb.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final ProductService service = new ProductService(productRepository);

    @Test
    @DisplayName("'listAllProducts()' Should return all products from repository")
    void testListAllProducts() {
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
        verify(productRepository).listAllProducts();
    }

    @Test
    @DisplayName("'GetProductByID()' Should Return Matching Product")
    void testGetProductById() {
        //Given
        when(productRepository.getProductById("4")).thenReturn(Optional.of(
                new Product("4", "(Sehr) teurer Kaffee")));
        String idToFind = "4";

        //When
        Optional<Product> actualProduct = service.getProductById(idToFind);

        //Then
        assertThat(actualProduct.isPresent(), is(true));
        assertThat(actualProduct.get(), is(new Product("4", "(Sehr) teurer Kaffee")));
    }

    @Test
    @DisplayName("'addProduct()' Should Add A Product")
    void addProduct() {
        // Given
        Product newProduct = new Product("5", "Goldene Henne");
        when(productRepository.addProduct(new Product("5", "Goldene Henne"))).thenReturn(newProduct);

        // When
        Optional<Product> actualProduct = service.addProduct(newProduct);

        // Then
        Product productExpected = new Product("5", "Goldene Henne");
        assertThat(actualProduct.get(), is(productExpected));
        verify(productRepository).addProduct(new Product("5", "Goldene Henne"));
    }
}