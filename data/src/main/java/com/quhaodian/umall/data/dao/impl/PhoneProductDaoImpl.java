package com.quhaodian.umall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.umall.data.dao.PhoneProductDao;
import com.quhaodian.umall.data.entity.PhoneProduct;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
@Repository

public class PhoneProductDaoImpl extends CriteriaDaoImpl<PhoneProduct, Long> implements PhoneProductDao {

	@Override
	public PhoneProduct findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public PhoneProduct save(PhoneProduct bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public PhoneProduct deleteById(Long id) {
		PhoneProduct entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PhoneProduct> getEntityClass() {
		return PhoneProduct.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}