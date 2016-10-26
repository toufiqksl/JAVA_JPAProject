package com.konasl.konaca.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * @author Saqib Rezwan (saqib_rezwan@konasl.com)
 */

@Entity
@Table(name = "SIGN_POLICY")
@XmlRootElement
public class SignPolicy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sign_policy_seq_generator")
	@SequenceGenerator(name = "sign_policy_seq_generator", sequenceName = "sign_policy_sequence", initialValue = 1, allocationSize = 1)
	@Column(name = "SIGN_POLICY_ID", nullable = false)
	private int signPolicyId;

	@Column(name = "OID", nullable = false)
	private String oid;

	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@OneToOne
	@JoinColumn(name = "CERT_POLICY_ID")
	private CertPolicy certPolicy;

	@OneToMany(mappedBy = "signPolicy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@CascadeOnDelete
	private List<SignKeyUsage> signKeyUsages;

	@OneToMany(mappedBy = "signPolicy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@CascadeOnDelete
	private List<SignExtKeyUsage> signExtKeyUsages;

	public int getSignPolicyId() {
		return signPolicyId;
	}

	public void setSignPolicyId(int signPolicyId) {
		this.signPolicyId = signPolicyId;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CertPolicy getCertPolicy() {
		return certPolicy;
	}

	public void setCertPolicy(CertPolicy certPolicy) {
		this.certPolicy = certPolicy;
	}

	public List<SignKeyUsage> getSignKeyUsages() {
		return signKeyUsages;
	}

	public void setSignKeyUsages(List<SignKeyUsage> signKeyUsages) {
		this.signKeyUsages = signKeyUsages;
	}

	public List<SignExtKeyUsage> getSignExtKeyUsages() {
		return signExtKeyUsages;
	}

	public void setSignExtKeyUsages(List<SignExtKeyUsage> signExtKeyUsages) {
		this.signExtKeyUsages = signExtKeyUsages;
	}

}
