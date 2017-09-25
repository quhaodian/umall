package com.quhaodian.umall.data.service;

import com.quhaodian.umall.data.entity.Member;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年09月25日09:43:18.
*/
public interface MemberService {

	Member findById(Long id);

	Member save(Member bean);

	Member update(Member bean);

	Member deleteById(Long id);
	
	Member[] deleteByIds(Long[] ids);
	
	Page<Member> page(Pageable pageable);
	
	Page<Member> page(Pageable pageable, Object search);


	List<Member> list(int first, Integer size, List<Filter> filters, List<Order> orders);

}