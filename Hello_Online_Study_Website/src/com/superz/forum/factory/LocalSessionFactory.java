package com.superz.forum.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.FactoryBean;

public class LocalSessionFactory implements FactoryBean<SessionFactory> {
	private SessionFactory sessionFactory;

	@Override
	public SessionFactory getObject() throws Exception {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cfg.getProperties());

			ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
			sessionFactory =  cfg.buildSessionFactory(serviceRegistry);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return SessionFactory.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
