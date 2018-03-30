package com.quhaodian.umall.data.service;

import com.quhaodian.umall.data.entity.PhoneProduct;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
public interface PhoneProductService {

	PhoneProduct findById(Long id);

	PhoneProduct save(PhoneProduct bean);

	PhoneProduct update(PhoneProduct bean);

	PhoneProduct deleteById(Long id);
	
	PhoneProduct[] deleteByIds(Long[] ids);
	
	Page<PhoneProduct> page(Pageable pageable);
	
	Page<PhoneProduct> page(Pageable pageable, Object search);


	List<PhoneProduct> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}