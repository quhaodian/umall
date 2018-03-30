package com.quhaodian.umall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.quhaodian.umall.data.dao.ProductDao;
import com.quhaodian.umall.data.entity.Product;
import com.quhaodian.umall.data.service.ProductService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import com.quhaodian.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年11月28日14:04:57.
*/


@Scope("prototype")
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao dao;


	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Product save(Product bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Product update(Product bean) {
		Updater<Product> updater = new Updater<Product>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Product deleteById(Long id) {
		Product bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Product[] deleteByIds(Long[] ids) {
		Product[] beans = new Product[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Product> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Product> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Product> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}