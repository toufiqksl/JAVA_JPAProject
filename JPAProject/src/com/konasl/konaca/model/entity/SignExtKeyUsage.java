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
@Table(name = "SIGN_EXT_KEY_USAGE")
@XmlRootElement
public class SignExtKeyUsage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sign_ext_key_usage_seq_generator")
	@SequenceGenerator(name = "sign_ext_key_usage_seq_generator", sequenceName = "sign_ext_key_usage_sequence", initialValue = 1, allocationSize = 1)
	@Column(name = "SIGN_EXT_KEY_USAGE_ID", nullable = false)
	private int signExtKeyUsageId;

	@Column(name = "EXT_KEY_USAGE", nullable = false)
	private int extKeyUsage;

	@ManyToOne
	@JoinColumn(name = "SIGN_POLICY_ID", nullable = false)
	private SignPolicy signPolicy;

	public int getSignExtKeyUsageId() {
		return signExtKeyUsageId;
	}

	public void setSignExtKeyUsageId(int signExtKeyUsageId) {
		this.signExtKeyUsageId = signExtKeyUsageId;
	}

	public int getExtKeyUsage() {
		return extKeyUsage;
	}

	public void setExtKeyUsage(int extKeyUsage) {
		this.extKeyUsage = extKeyUsage;
	}

	public SignPolicy getSignPolicy() {
		return signPolicy;
	}

	public void setSignPolicy(SignPolicy signPolicy) {
		this.signPolicy = signPolicy;
	}

}
