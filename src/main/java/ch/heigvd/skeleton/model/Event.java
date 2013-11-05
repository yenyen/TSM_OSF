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
                query = "SELECT e FROM Event e where e.application.id = :applicationId"
	)
)

@Entity
public class Event extends AbstractLinkApplicationModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Player player;
    private String type;
    private Timestamp timestamp;

    public Event() {
        this(null, null, null, null);
    }
    
    public Event(Event event){
        this(event.getApplication(), event.player, event.type, event.timestamp);
    }
    
    public Event(Application application, Player player, String type, Timestamp timestamp) {
        super(application);
        this.player = player;
        this.type = type;
        this.timestamp = timestamp;
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
