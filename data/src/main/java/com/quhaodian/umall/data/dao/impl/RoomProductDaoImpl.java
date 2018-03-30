package com.quhaodian.umall.data.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.umall.data.dao.RoomProductDao;
import com.quhaodian.umall.data.entity.RoomProduct;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
@Repository

public class RoomProductDaoImpl extends CriteriaDaoImpl<RoomProduct, Long> implements RoomProductDao {

	@Override
	public RoomProduct findById(Long id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public RoomProduct save(RoomProduct bean) {

        getSession().save(bean);
		
		
		return bean;
	}

    @Override
	public RoomProduct deleteById(Long id) {
		RoomProduct entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<RoomProduct> getEntityClass() {
		return RoomProduct.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}