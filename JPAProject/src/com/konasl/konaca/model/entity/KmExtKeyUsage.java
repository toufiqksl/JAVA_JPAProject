package com.konasl.konaca.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Saqib Rezwan (saqib_rezwan@konasl.com)
 */

@Entity
@Table(name = "KM_EXT_KEY_USAGE")
@XmlRootElement
public class KmExtKeyUsage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "km_ext_key_usage_seq_generator")
	@SequenceGenerator(name = "km_ext_key_usage_seq_generator", sequenceName = "km_ext_key_usage_sequence", initialValue = 1, allocationSize = 1)
	@Column(name = "KM_EXT_KEY_USAGE_ID", nullable = false)
	private int kmExtKeyUsageId;

	@Column(name = "EXT_KEY_USAGE", nullable = false)
	private int extKeyusage;

	@ManyToOne
	@JoinColumn(name = "KEY_MANAGEMENT_POLICY_ID", nullable = false)
	private KeyManagementPolicy keyManagementPolicy;

	public int getKmExtKeyUsageId() {
		return kmExtKeyUsageId;
	}

	public void setKmExtKeyUsageId(int kmExtKeyUsageId) {
		this.kmExtKeyUsageId = kmExtKeyUsageId;
	}

	public int getExtKeyusage() {
		return extKeyusage;
	}

	public void setExtKeyusage(int extKeyusage) {
		this.extKeyusage = extKeyusage;
	}

	public KeyManagementPolicy getKeyManagementPolicy() {
		return keyManagementPolicy;
	}

	public void setKeyManagementPolicy(KeyManagementPolicy keyManagementPolicy) {
		this.keyManagementPolicy = keyManagementPolicy;
	}

}
