package angular.with.spring.domain.utils;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class BaseObject implements Serializable {

    private static final long serialVersionUID = -9208215308257385331L;

    public abstract Long getId();
}
