/**
 * File: CertPolicyManager.java
 *
 * Copyright (C) 2013 - 2014, KonaSL Ltd.
 * All rights reserved.
 *
 * This program is a property of KonaSL. you can not redistributeit and/or modify it
 * without any permission of KonaSL.
 *
 * @author			: Toufiq Mahmud(toufiq.mahmud@konasl.com)
 */
package com.konasl.konaca.model.manager;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import com.konasl.konaca.model.entity.CertPolicy;
import com.konasl.konaca.model.entity.SignKeyUsage;

/**
 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
 * 
 */

public class CertPolicyManager extends BaseManager {

	/**
	 * @param CertPolicy
	 * @return
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 * 
	 */
	public static Logger log = Logger.getLogger("CertPolicyManager");

	public int register(CertPolicy certPolicy) {
		log.info("KonaCADemon >>> register() Start");
		initEntityManager();
		getEm().persist(certPolicy);
		int policyId = certPolicy.getCertPolicyId();
		closeEntityManager();
		log.info("KonaCADemon >>> register() End");

		return policyId;
	}

	/**
	 * @param CertPolicy
	 * @return
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public void update(CertPolicy certPolicy) {
		log.info("KonaCADemon >>> update() Start");

		initEntityManager();
		getEm().merge(certPolicy);
		closeEntityManager();
		log.info("KonaCADemon >>> update() End");

	}

	/**
	 * @param CertPolicy
	 * @return
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public void delete(CertPolicy certPolicy) {
		log.info("KonaCADemon >>> delete() Start");
		initEntityManager();
		CertPolicy toBeRemoved = getEm().merge(certPolicy);
		getEm().remove(toBeRemoved);
		closeEntityManager();
		log.info("KonaCADemon >>> delete() End");

	}

	/**
	 * @param SignKeyUsage
	 * @return
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public void deleteSignKeyUsage(SignKeyUsage signKeyUsage) {
		log.info("KonaCADemon >>> delete() Start");
		initEntityManager();
		SignKeyUsage toBeRemoved = getEm().merge(signKeyUsage);
		getEm().remove(toBeRemoved);
		closeEntityManager();
		log.info("KonaCADemon >>> delete() End");

	}

	/**
	 * 
	 * @return List<CertPolicy>
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public List<CertPolicy> findAll() {
		log.info("KonaCADemon >>> findAll() Start");
		List<CertPolicy> certPolicies = null;
		initEntityManager();
		Query query = getEm().createQuery("SELECT cp FROM CertPolicy cp");
		certPolicies = query.getResultList();
		closeEntityManager();
		log.info("KonaCADemon >>> findAll() End");
		return certPolicies;
	}

	/**
	 * @param String
	 * @return CertPolicy
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 */
	public CertPolicy findByName(String name) {
		log.info("KonaCADemon >>> findByName() Start");

		CertPolicy certPolicy = null;
		try {
			initEntityManager();
			Object seObject = getEm()
					.createQuery(
							"SELECT cp from CertPolicy cp WHERecp.name= '"
									+ name + "'").getSingleResult();
			certPolicy = (CertPolicy) seObject;
			closeEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("KonaCADemon >>> findByName() End");

		return certPolicy;
	}

	/**
	 * @param int
	 * @return CertPolicy
	 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
	 * @throws Exception
	 */
	public CertPolicy findById(int id) {
		log.info("KonaCADemon >>> findById() End");
		initEntityManager();
		CertPolicy certPolicy = getEm().find(CertPolicy.class, id);
		closeEntityManager();
		log.info("KonaCADemon >>> findById() End");
		return certPolicy;
	}
}
