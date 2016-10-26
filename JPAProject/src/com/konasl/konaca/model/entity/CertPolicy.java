package com.konasl.konaca.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * @author Saqib Rezwan (saqib_rezwan@konasl.com)
 */

@Entity
@Table(name = "CERT_POLICY")
@XmlRootElement
public class CertPolicy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cert_policy_seq_generator")
	@SequenceGenerator(name = "cert_policy_seq_generator", sequenceName = "cert_policy_sequence", initialValue = 1, allocationSize = 1)
	@Column(name = "CERT_POLICY_ID", nullable = false)
	private int certPolicyId;

	@Column(name = "TYPE", nullable = false)
	private char type;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "ISSUE_DATE", nullable = false)
	private Date issueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "EXPIRE_DATE", nullable = false)
	private Date expireDate;

	@Column(name = "KEYSIZE", nullable = false)
	private int keySize;

	@Column(name = "KEY_ALGORITHM", nullable = false)
	private char keyAlgorithm;

	@Column(name = "CPS_URL", nullable = true)
	private String cpsUrl;

	@Column(name = "OCSP_URL", nullable = true)
	private String ocspUrl;

	@Column(name = "SIGN_ALG", nullable = false)
	private char signAlg;

	@Column(name = "RA_TEMPLATE", nullable = false)
	private char raTemplate;

	@Column(name = "AUTO_CONFIRMATION", nullable = false)
	private char autoConfirmation;

	@Column(name = "OLD_KEY", nullable = false)
	private char oldKey;

	@Column(name = "MAX_RENEW", nullable = false)
	private int maxRenew;

	@Column(name = "KEY_ISSUE_NOTIFY", nullable = false)
	private char keyIssueNotify;

	@Column(name = "AUTHORITY_IDENTIFIER", nullable = false)
	private char authorityIdentifier;

	@Column(name = "SUBJECT_IDENTIFIER", nullable = false)
	private char subjectIdentifier;

	@Column(name = "ISSUER_ALT_NAME", nullable = false)
	private char issuerAltName;

	@Column(name = "PATH_LENGTH", nullable = false)
	private int pathLength;

	@Column(name = "REQUIRE_EXPLICIT_POLICY", nullable = false)
	private char requireExplicitPolicy;

	@Column(name = "INHIBIT_POLICY_MAPPING", nullable = false)
	private char inhibitPolicy;

	@Column(name = "STATUS", nullable = false)
	private char status;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "certPolicy", fetch = FetchType.EAGER)
	@CascadeOnDelete
	private KeyManagementPolicy keyManagementPolicy;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "certPolicy", fetch = FetchType.EAGER)
	@CascadeOnDelete
	private SignPolicy signPolicy;

	public int getCertPolicyId() {
		return certPolicyId;
	}

	public void setCertPolicyId(int certPolicyId) {
		this.certPolicyId = certPolicyId;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getKeySize() {
		return keySize;
	}

	public void setKeySize(int keySize) {
		this.keySize = keySize;
	}

	public char getKeyAlgorithm() {
		return keyAlgorithm;
	}

	public void setKeyAlgorithm(char keyAlgorithm) {
		this.keyAlgorithm = keyAlgorithm;
	}

	public String getCpsUrl() {
		return cpsUrl;
	}

	public void setCpsUrl(String cpsUrl) {
		this.cpsUrl = cpsUrl;
	}

	public String getOcspUrl() {
		return ocspUrl;
	}

	public void setOcspUrl(String ocspUrl) {
		this.ocspUrl = ocspUrl;
	}

	public char getSignAlg() {
		return signAlg;
	}

	public void setSignAlg(char signAlg) {
		this.signAlg = signAlg;
	}

	public char getRaTemplate() {
		return raTemplate;
	}

	public void setRaTemplate(char raTemplate) {
		this.raTemplate = raTemplate;
	}

	public char getAutoConfirmation() {
		return autoConfirmation;
	}

	public void setAutoConfirmation(char autoConfirmation) {
		this.autoConfirmation = autoConfirmation;
	}

	public char getOldKey() {
		return oldKey;
	}

	public void setOldKey(char oldKey) {
		this.oldKey = oldKey;
	}

	public int getMaxRenew() {
		return maxRenew;
	}

	public void setMaxRenew(int maxRenew) {
		this.maxRenew = maxRenew;
	}

	public char getKeyIssueNotify() {
		return keyIssueNotify;
	}

	public void setKeyIssueNotify(char keyIssueNotify) {
		this.keyIssueNotify = keyIssueNotify;
	}

	public char getAuthorityIdentifier() {
		return authorityIdentifier;
	}

	public void setAuthorityIdentifier(char authorityIdentifier) {
		this.authorityIdentifier = authorityIdentifier;
	}

	public char getSubjectIdentifier() {
		return subjectIdentifier;
	}

	public void setSubjectIdentifier(char subjectIdentifier) {
		this.subjectIdentifier = subjectIdentifier;
	}

	public char getIssuerAltName() {
		return issuerAltName;
	}

	public void setIssuerAltName(char issuerAltName) {
		this.issuerAltName = issuerAltName;
	}

	public int getPathLength() {
		return pathLength;
	}

	public void setPathLength(int pathLength) {
		this.pathLength = pathLength;
	}

	public char getRequireExplicitPolicy() {
		return requireExplicitPolicy;
	}

	public void setRequireExplicitPolicy(char requireExplicitPolicy) {
		this.requireExplicitPolicy = requireExplicitPolicy;
	}

	public char getInhibitPolicy() {
		return inhibitPolicy;
	}

	public void setInhibitPolicy(char inhibitPolicy) {
		this.inhibitPolicy = inhibitPolicy;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * @return the keyManagementPolicy
	 */
	public KeyManagementPolicy getKeyManagementPolicy() {
		return keyManagementPolicy;
	}

	/**
	 * @param keyManagementPolicy
	 *            the keyManagementPolicy to set
	 */
	public void setKeyManagementPolicy(KeyManagementPolicy keyManagementPolicy) {
		this.keyManagementPolicy = keyManagementPolicy;
	}

	/**
	 * @return the signPolicy
	 */
	public SignPolicy getSignPolicy() {
		return signPolicy;
	}

	/**
	 * @param signPolicy
	 *            the signPolicy to set
	 */
	public void setSignPolicy(SignPolicy signPolicy) {
		this.signPolicy = signPolicy;
	}

}
