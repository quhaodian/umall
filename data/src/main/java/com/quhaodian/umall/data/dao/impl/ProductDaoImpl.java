package com.quhaodian.umall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.umall.data.dao.ProductDao;
import com.quhaodian.umall.data.entity.Product;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
@Repository

public class ProductDaoImpl extends CriteriaDaoImpl<Product, Long> implements ProductDao {

	@Override
	public Product findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public Product save(Product bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public Product deleteById(Long id) {
		Product entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}