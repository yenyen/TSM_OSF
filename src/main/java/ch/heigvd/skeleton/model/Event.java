/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aurelien
 */
@NamedQueries(
	@NamedQuery(
					name = "findAllEvents",
					query = "SELECT e FROM Event e"
	)
)

@Entity
public class Event extends AbstractModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Application  application;
    private Player player;
    private String type;
    private Timestamp timestamp;

    public Event() {
        this(null, null, null, null);
    }
    
    public Event(Event event){
        this(event.application, event.player, event.type, event.timestamp);
    }
    
    public Event(Application application, Player player, String type, Timestamp timestamp) {
        this.application = application;
        this.player = player;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        return super.equals(object);
    }
}
