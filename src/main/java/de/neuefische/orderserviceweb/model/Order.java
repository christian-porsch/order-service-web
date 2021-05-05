package de.neuefische.orderserviceweb.model;

import java.util.Objects;

    public class Order {

        private String id;
        private String product;

        public Order(String id, String product) {
            this.id = id;
            this.product = product;
        }

        public String getId() {
            return id;
        }

        public String getProduct() {
            return product;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return Objects.equals(id, order.id) && Objects.equals(product, order.product);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, product);
        }

        @Override
        public String toString() {
            return "Order{" +
                    "id='" + id + '\'' +
                    ", product=" + product +
                    '}';
        }
    }

