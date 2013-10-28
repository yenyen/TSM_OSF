/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aurelien
 */
@Entity
public class Rule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  onEventType;
    private int numberOfPoints;
    private Badge badge;

    public Rule() {
    }
    
    public Rule(Rule rule) {
        badge = rule.badge;
        onEventType = rule.onEventType;
        numberOfPoints = rule.numberOfPoints;
    }
    
    public Rule(String onEventType, int numberOfPoints, Badge badge) {
        this.onEventType = onEventType;
        this.numberOfPoints = numberOfPoints;
        this.badge = badge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rule)) {
            return false;
        }
        Rule other = (Rule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.heigvd.skeleton.model.Rule[ id=" + id + " ]";
    }
    
}
