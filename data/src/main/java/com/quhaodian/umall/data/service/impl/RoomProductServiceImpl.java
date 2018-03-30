package com.quhaodian.umall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.quhaodian.umall.data.dao.RoomProductDao;
import com.quhaodian.umall.data.entity.RoomProduct;
import com.quhaodian.umall.data.service.RoomProductService;

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
public class RoomProductServiceImpl implements RoomProductService {

	private RoomProductDao dao;


	@Override
	@Transactional(readOnly = true)
	public RoomProduct findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public RoomProduct save(RoomProduct bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public RoomProduct update(RoomProduct bean) {
		Updater<RoomProduct> updater = new Updater<RoomProduct>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public RoomProduct deleteById(Long id) {
		RoomProduct bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public RoomProduct[] deleteByIds(Long[] ids) {
		RoomProduct[] beans = new RoomProduct[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(RoomProductDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<RoomProduct> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<RoomProduct> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<RoomProduct> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}