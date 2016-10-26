/**
 * File : BaseManager.java
 *
 * Copyright (C) 2013 - 2014, KonaSL Ltd.
 * All rights reserved.
 *
 * This program is a property of KonaSL. you can not redistribute it and/or modify it
 * without any permission of KonaSL.
 *
 * @author			: Toufiq Mahmud(toufiq.mahmud@konasl.com)
 */
package com.konasl.konaca.model.manager;

/**
 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
 *
 */
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseManager {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private static String PERSISTENCE_UNIT_NAME = "KonaCA";
	static {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	// Init Entity Manager Factory
	/**
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public static Logger log = Logger.getLogger("BaseManager");

	public void initEntityManager(){
		log.info("KonaCADemon >>> initEntityManager() Start");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		log.info("KonaCADemon >>> initEntityManager() End");

	}

	// Close Entity Manager Factory
	/**
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public void closeEntityManager(){
		log.info("KonaCADemon >>> closeEntityManager() Start");
		em.getTransaction().commit();
		em.close();
		log.info("KonaCADemon >>> closeEntityManager() End");

	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em
	 *            the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
