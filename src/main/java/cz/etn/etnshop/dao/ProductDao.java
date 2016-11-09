package cz.etn.etnshop.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {

	@Transactional(readOnly = true)
	List<Product> getProducts();

	@Transactional
	void addProduct(Product product);

	@Transactional
	void updateProduct(Product product);

	@Transactional
	List<Product> findProducts(String textToSearch);

}
