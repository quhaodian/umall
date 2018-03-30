package com.quhaodian.umall.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import  com.quhaodian.umall.data.entity.Product;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
public interface ProductDao extends BaseDao<Product,Long>{

	 Product findById(Long id);

	 Product save(Product bean);

	 Product updateByUpdater(Updater<Product> updater);

	 Product deleteById(Long id);
}