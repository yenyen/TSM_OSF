/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aurelien
 */
@NamedQueries(
	@NamedQuery(
					name = "findAllBadges",
					query = "SELECT e FROM Badge e"
	)
)

@Entity
public class Badge extends AbstractModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String icon;
    
    public Badge(){
        this(null, null, null);
    }
    
    public Badge(Badge badge){
        this(badge.name, badge.description, badge.icon);
    }

    public Badge(String name, String description, String icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Badge)) {
            return false;
        }
        return super.equals(object);
    }
}
