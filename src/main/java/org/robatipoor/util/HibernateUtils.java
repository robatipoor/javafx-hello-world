package org.robatipoor.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HibernateUtils
 */

public class HibernateUtils {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private static final Logger LOG = LoggerFactory.getLogger(HibernateUtils.class);

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();

				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
				LOG.info("Create SessionFactory Successful");

			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
				LOG.error("Create SessionFactory Faild {}", e.getMessage());
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
			LOG.info("StandardServiceRegistryBuilder Destroy");
		}
	}
}