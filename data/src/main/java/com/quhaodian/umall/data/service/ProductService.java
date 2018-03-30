package com.quhaodian.umall.data.service;

import com.quhaodian.umall.data.entity.Product;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
public interface ProductService {

	Product findById(Long id);

	Product save(Product bean);

	Product update(Product bean);

	Product deleteById(Long id);
	
	Product[] deleteByIds(Long[] ids);
	
	Page<Product> page(Pageable pageable);
	
	Page<Product> page(Pageable pageable, Object search);


	List<Product> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}