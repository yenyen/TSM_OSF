package ch.heigvd.skeleton.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * This class is an example for a simple JPA entity. Notice that there is a
 * 'salary' property, which is sensitive and which we do not want to expose to
 * everyone. That is one reason why we do not want to use this class directly
 * from the REST tier (and instead use specific Transfer Objects).
 *
 * @author Olivier Liechti
 */
@NamedQueries({
        @NamedQuery(
                                        name = "findAllPlayers",
                                        query = "SELECT e FROM Player e where e.application.id = :applicationId"
        ),
        @NamedQuery(
                                        name = "findAllPlayersOrderByPoints",
                                        query = "SELECT e FROM Player e where e.application.id = :applicationId ORDER BY  e.numberOfPoints"
        )
})

@Entity
public class Player extends AbstractLinkApplicationModel {
	
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private int numberOfPoints;
	@ManyToMany()
	@JoinTable(name = "Player_Badge")
	private Set<Badge> badges;

	public Player() {
            this(null, null, null, null, 0);
	}
	public Player(Player player) {
            this(player.getApplication(), player.firstName, player.lastName, player.email, player.numberOfPoints);
	}

	public Player(Application application, String firstName, String lastName, String email, int numberOfPoints) {
            super(application);
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.numberOfPoints = numberOfPoints;
	}

	public String getFirstName() {
            return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}

	public Set<Badge> getBadges() {
		return badges;
	}

	public void setBadges(Set<Badge> badges) {
		this.badges = badges;
	}
	
	public void add(Badge argv){
		badges.add(argv);
	}


	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Player)) {
			return false;
		}
		return super.equals(object);
	}
}
