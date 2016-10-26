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

/**
 * @author Saqib Rezwan (saqib_rezwan@konasl.com)
 */

@Entity
@Table(name = "KEY_MANAGEMENT_POLICY")
@XmlRootElement
public class KeyManagementPolicy implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "km_policy_seq_generator")
	@SequenceGenerator(name = "km_policy_seq_generator", sequenceName = "km_policy_sequence", initialValue = 1, allocationSize=1)
	@Column(name = "KEY_MANAGEMENT_POLICY_ID", nullable = false)
	private int keyManagementPolicyId;
	
	@Column(name = "OID", nullable = false)
	private String oid;
	
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;
	
	@OneToOne
	@JoinColumn(name="CERT_POLICY_ID")
	private CertPolicy certPolicy;
	
	@OneToMany(mappedBy = "keyManagementPolicy", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@CascadeOnDelete
	private List<KmKeyUsage> kmKeyUsages;
	
	@OneToMany(mappedBy = "keyManagementPolicy", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@CascadeOnDelete
	private List<KmExtKeyUsage> kmExtKeyUsages;

	
	public int getKeyManagementPolicyId() 
	{
		return keyManagementPolicyId;
	}

	public void setKeyManagementPolicyId(int keyManagementPolicyId) 
	{
		this.keyManagementPolicyId = keyManagementPolicyId;
	}

	public String getOid() 
	{
		return oid;
	}

	public void setOid(String oid) 
	{
		this.oid = oid;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public CertPolicy getCertPolicy() 
	{
		return certPolicy;
	}

	public void setCertPolicy(CertPolicy certPolicy) 
	{
		this.certPolicy = certPolicy;
	}

	public List<KmKeyUsage> getKmKeyUsages() 
	{
		return kmKeyUsages;
	}

	public void setKmKeyUsages(List<KmKeyUsage> kmKeyUsages) 
	{
		this.kmKeyUsages = kmKeyUsages;
	}

	public List<KmExtKeyUsage> getKmExtKeyUsages() 
	{
		return kmExtKeyUsages;
	}

	public void setKmExtKeyUsages(List<KmExtKeyUsage> kmExtKeyUsages) 
	{
		this.kmExtKeyUsages = kmExtKeyUsages;
	}

}
