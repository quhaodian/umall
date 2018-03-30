package com.quhaodian.umall.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import  com.quhaodian.umall.data.entity.PhoneProduct;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
public interface PhoneProductDao extends BaseDao<PhoneProduct,Long>{

	 PhoneProduct findById(Long id);

	 PhoneProduct save(PhoneProduct bean);

	 PhoneProduct updateByUpdater(Updater<PhoneProduct> updater);

	 PhoneProduct deleteById(Long id);
}