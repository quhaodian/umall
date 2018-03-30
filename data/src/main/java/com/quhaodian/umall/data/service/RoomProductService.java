package com.quhaodian.umall.data.service;

import com.quhaodian.umall.data.entity.RoomProduct;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
public interface RoomProductService {

	RoomProduct findById(Long id);

	RoomProduct save(RoomProduct bean);

	RoomProduct update(RoomProduct bean);

	RoomProduct deleteById(Long id);
	
	RoomProduct[] deleteByIds(Long[] ids);
	
	Page<RoomProduct> page(Pageable pageable);
	
	Page<RoomProduct> page(Pageable pageable, Object search);


	List<RoomProduct> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}