package com.superz.study.utils;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static{
		try{
			Configuration cfg = new Configuration();
			cfg.configure();

			ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
			srb.applySettings(cfg.getProperties());

			ServiceRegistry serviceRegistry = srb.buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
