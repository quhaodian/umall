package com.quhaodian.umall.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import  com.quhaodian.umall.data.entity.Member;

/**
* Created by imake on 2017年09月25日09:43:18.
*/
public interface MemberDao extends BaseDao<Member,Long>{

	 Member findById(Long id);

	 Member save(Member bean);

	 Member updateByUpdater(Updater<Member> updater);

	 Member deleteById(Long id);
}