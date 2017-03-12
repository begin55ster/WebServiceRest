package br.com.jefferson.dao;

import java.io.Serializable;

import org.hibernate.proxy.HibernateProxyHelper;

public abstract class BaseEntity<T extends Serializable> {
	
	public abstract T getId();
	public abstract void setId(T id);

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		if (getId() == null || ((BaseEntity<?>) obj).getId() == null) {
			return false;
		}
		if (!getId().equals(((BaseEntity<?>) obj).getId())) {
			return false;
		}
		if (!HibernateProxyHelper.getClassWithoutInitializingProxy(obj)
				.isAssignableFrom(this.getClass())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return getId() == null ? super.hashCode() : getId().hashCode();
}


}
