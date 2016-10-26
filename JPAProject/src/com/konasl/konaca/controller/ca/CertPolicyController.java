/**
 * File : CertPolicyController.java
 *
 * Copyright (C) 2013 - 2014, KonaSL Ltd.
 * All rights reserved.
 *
 * This program is a property of KonaSL. you can not redistribute it and/or modify it
 * without any permission of KonaSL.
 *
 * @author			: Toufiq Mahmud(toufiq.mahmud@konasl.com)
 */
package com.konasl.konaca.controller.ca;

/**
 * @author Toufiq Mahmud(toufiq.mahmud@konasl.com)
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.konasl.konaca.model.entity.CertPolicy;
import com.konasl.konaca.model.entity.SignExtKeyUsage;
import com.konasl.konaca.model.entity.SignKeyUsage;
import com.konasl.konaca.model.entity.SignPolicy;
import com.konasl.konaca.model.manager.CertPolicyManager;

public class CertPolicyController {

	public static Logger log = Logger.getLogger("CertPolicyController");

	public static void main(String args[]) {

		CertPolicyManager cpm = new CertPolicyManager();

		CertPolicy cp = new CertPolicy();
		SignPolicy sp = new SignPolicy();
		SignKeyUsage sku = new SignKeyUsage();
		SignExtKeyUsage seku = new SignExtKeyUsage();

		// Register Policy

		// cp.setAuthorityIdentifier('1');
		// cp.setAutoConfirmation('1');
		// cp.setCpsUrl("abc");
		// cp.setExpireDate(new Date());
		// cp.setInhibitPolicy('1');
		// cp.setIssueDate(new Date());
		// cp.setIssuerAltName('1');
		// cp.setKeyAlgorithm('1');
		// cp.setKeyIssueNotify('1');
		// cp.setKeySize(1);
		// cp.setMaxRenew(1);
		// cp.setName("Test");
		// cp.setOcspUrl("abc");
		// cp.setOldKey('1');
		// cp.setPathLength(1);
		// cp.setRaTemplate('1');
		// cp.setRequireExplicitPolicy('1');
		// cp.setSignAlg('1');
		// cp.setStatus('1');
		// cp.setSubjectIdentifier('1');
		// cp.setType('1');
		//
		// SignKeyUsage sku2 = new SignKeyUsage();
		// SignExtKeyUsage seku2 = new SignExtKeyUsage();
		//
		// List<SignKeyUsage> signKeyUsages = new ArrayList<>();
		// signKeyUsages.add(sku);
		// signKeyUsages.add(sku2);
		//
		// List<SignExtKeyUsage> signExtKeyUsages = new ArrayList<>();
		// signExtKeyUsages.add(seku);
		// signExtKeyUsages.add(seku2);
		//
		// sp.setOid("1.2.3.4");
		// sp.setDescription("Test");
		// sp.setCertPolicy(cp);
		// sp.setSignKeyUsages(signKeyUsages);
		// sp.setSignExtKeyUsages(signExtKeyUsages);
		//
		// sku.setKeyUsage(1);
		// sku.setSignPolicy(sp);
		//
		// sku2.setKeyUsage(2);
		// sku2.setSignPolicy(sp);
		//
		// seku.setExtKeyUsage(1);
		// seku.setSignPolicy(sp);
		//
		// seku2.setExtKeyUsage(2);
		// seku2.setSignPolicy(sp);
		//
		// cp.setSignPolicy(sp);
		//
		// cpm.register(cp);

		// List of all policy

		// List<CertPolicy> certPolicies = cpm.findAll();
		// for (CertPolicy certPolicy : certPolicies) {
		// log.info("Profile Name : " + certPolicy.getName());
		// log.info("Sign policy OID : " + certPolicy.getSignPolicy().getOid());
		// for (SignKeyUsage signKeyUsage : certPolicy.getSignPolicy()
		// .getSignKeyUsages()) {
		// log.info("Sign Key Usage : " + signKeyUsage.getKeyUsage());
		// }
		// }

		// Delete Policy by ID

		// CertPolicy certPolicy = cpm.findById(1);
		// cpm.delete(certPolicy);
		
		
		

		// Edit Policy
		CertPolicy certPolicy = cpm.findById(1);
		certPolicy.getSignPolicy().getSignKeyUsages().clear();
		//romove from existing signKeyUsage
//		for (SignKeyUsage signKeyUsage : certPolicy.getSignPolicy().getSignKeyUsages()) {
//			cpm.deleteSignKeyUsage(signKeyUsage);
//		}
		List<SignKeyUsage> signKeyUsages = new ArrayList<>();
		signKeyUsages.add(sku);
		sku.setKeyUsage(3);
		sku.setSignPolicy(certPolicy.getSignPolicy());
		certPolicy.getSignPolicy().getSignKeyUsages().add(sku);
		cpm.update(certPolicy);
	}

}
