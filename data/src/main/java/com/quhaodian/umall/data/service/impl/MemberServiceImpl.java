package com.quhaodian.umall.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.quhaodian.umall.data.dao.MemberDao;
import com.quhaodian.umall.data.entity.Member;
import com.quhaodian.umall.data.service.MemberService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.quhaodian.data.utils.FilterUtils;
import org.springframework.context.annotation.Scope;


/**
* Created by imake on 2017年09月25日09:43:18.
*/


@Scope("prototype")
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	private MemberDao dao;


	@Override
	@Transactional(readOnly = true)
	public Member findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Member save(Member bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Member update(Member bean) {
		Updater<Member> updater = new Updater<Member>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Member deleteById(Long id) {
		Member bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Member[] deleteByIds(Long[] ids) {
		Member[] beans = new Member[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	@Override
    public Page<Member> page(Pageable pageable){
         return dao.page(pageable);
    }


    @Override
	public Page<Member> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}

    @Override
    public List<Member> list(int first, Integer size, List<Filter> filters, List<Order> orders) {
        return dao.list(first,size,filters,orders);}
}