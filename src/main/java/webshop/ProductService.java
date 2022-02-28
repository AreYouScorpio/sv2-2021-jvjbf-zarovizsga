package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository pr) {
        productRepository = pr;
    }

    public void saleProduct(long id, int amount) {
        Product p = productRepository.findProductById(id);
        if (p.getStock() < amount)
            throw new IllegalArgumentException("Out of stock!");
        productRepository.updateProductStock(id, amount);
    }


}
