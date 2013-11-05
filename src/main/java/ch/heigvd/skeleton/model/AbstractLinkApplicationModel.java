/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author aurelien
 */
@javax.persistence.MappedSuperclass
public abstract class AbstractLinkApplicationModel extends AbstractModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Application application;
    
    public AbstractLinkApplicationModel() {
    }
    
    public AbstractLinkApplicationModel(Application application) {
        this.application = application;
    }
    
    public Application getApplication() {
        return application;
    }
    
    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Application)) {
            return false;
        }
        return super.equals(object);
    }

}
