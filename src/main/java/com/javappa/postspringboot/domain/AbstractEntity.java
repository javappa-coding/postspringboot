package com.javappa.postspringboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private ID id;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "modification_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	@Override
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {		
		return null == getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (!(o instanceof AbstractEntity)) {
			return false;
		}
		AbstractEntity<?> that = (AbstractEntity<?>) o;

		return Objects.equals(id, that.id);
	}
	
	@PrePersist
	protected void onCreate() {
		
		if (this.creationDate == null) {
			Date currentDate = new Date();
			this.creationDate = currentDate;
			this.modificationDate = currentDate;
		}
	}

	@PreUpdate
	protected void onUpdate() {
		this.modificationDate = new Date();
	}

	@Override
	public String toString() {
		
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}
}