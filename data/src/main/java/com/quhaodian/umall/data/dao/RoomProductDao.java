package com.quhaodian.umall.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import  com.quhaodian.umall.data.entity.RoomProduct;

/**
* Created by imake on 2017年11月28日14:04:57.
*/
public interface RoomProductDao extends BaseDao<RoomProduct,Long>{

	 RoomProduct findById(Long id);

	 RoomProduct save(RoomProduct bean);

	 RoomProduct updateByUpdater(Updater<RoomProduct> updater);

	 RoomProduct deleteById(Long id);
}