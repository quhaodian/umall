package com.quhaodian.umall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.quhaodian.umall.data.dao.PhoneProductDao;
import com.quhaodian.umall.data.entity.PhoneProduct;
import com.quhaodian.umall.data.service.PhoneProductService;

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
public class PhoneProductServiceImpl implements PhoneProductService {

	private PhoneProductDao dao;


	@Override
	@Transactional(readOnly = true)
	public PhoneProduct findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public PhoneProduct save(PhoneProduct bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public PhoneProduct update(PhoneProduct bean) {
		Updater<PhoneProduct> updater = new Updater<PhoneProduct>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public PhoneProduct deleteById(Long id) {
		PhoneProduct bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public PhoneProduct[] deleteByIds(Long[] ids) {
		PhoneProduct[] beans = new PhoneProduct[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(PhoneProductDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<PhoneProduct> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<PhoneProduct> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<PhoneProduct> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}