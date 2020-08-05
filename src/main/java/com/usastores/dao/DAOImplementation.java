package com.usastores.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usastores.bean.StoreBean;
import com.usastores.cfg.WebServletConfiguration;

@Repository
public class DAOImplementation implements DAO
{
	private Logger LOGGER=Logger.getLogger(DAOImplementation.class);
	
	@Autowired
	SessionFactory sessionFactory;

	public int insert(StoreBean storeBean) 
	{
		Session session=sessionFactory.openSession();
		Integer res= (Integer) session.save(storeBean);
		
		return res.intValue();
	}

	public int delete(int storeId) {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("delete from StoreBean where storeId=:storeId");
		query.setParameter("storeId", storeId);
		LOGGER.info("delete query "+query);
		int result=query.executeUpdate();
		
		
		return result;
	}

	public List<StoreBean> search(int storeId) {
		
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from StoreBean s where s.storeId="+storeId);
		LOGGER.info("Search query "+query);
		List<StoreBean> listRes=query.list();
		return listRes;
	}

	public int update(StoreBean storeBean) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update StoreBean set storeName=:storeName,storeArea=:storeArea where storeId=:storeId");
		query.setParameter("storeName", storeBean.getStoreName());
		query.setParameter("storeArea", storeBean.getStoreArea());
		query.setParameter("storeId", storeBean.getStoreId());
		LOGGER.info("Update query "+query);
		int result=query.executeUpdate();
		
		return result;
	}

}
