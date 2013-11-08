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
@NamedQueries({      
    @NamedQuery(
        name = "findAllRules",
        query = "SELECT r FROM Rule r where r.application.id = :applicationId"
    ),
    @NamedQuery(
        name = "findRulesByType",
        query = "SELECT r FROM Rule r where r.application.id = :applicationId and r.onEventType = :onEventType"
    )
})

@Entity
public class Rule extends AbstractLinkApplicationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String  onEventType;
    private int numberOfPoints;
    private Badge badge;

    public Rule() {
    }
    
    public Rule(Rule rule) {
        this(rule.getApplication(), rule.onEventType, rule.numberOfPoints, rule.badge);
    }
    
    public Rule(Application application, String onEventType, int numberOfPoints, Badge badge) {
        this.onEventType = onEventType;
        this.numberOfPoints = numberOfPoints;
        this.badge = badge;
    }

    public String getOnEventType() {
        return onEventType;
    }

    public void setOnEventType(String onEventType) {
        this.onEventType = onEventType;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    @Override
    public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof Rule)) {
                    return false;
            }
            return super.equals(object);
    }
}
