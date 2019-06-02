package com.ashish.springboottestdemo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LEGAL_ENTITY", schema = "PCC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class LegalEntity {

	@Id
	@Column(name = "LEGAL_ENTITY_ID")
	@EqualsAndHashCode.Include
	private Integer legalEntityId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Product product;

	@Column(name = "LEGAL_ENTITY_NAME")
	private String legalEntityName;

	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	
	public LegalEntity(Integer legalEntityId) {
		this.legalEntityId = legalEntityId;
	}
}
