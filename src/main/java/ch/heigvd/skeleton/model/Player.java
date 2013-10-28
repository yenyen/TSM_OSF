package ch.heigvd.skeleton.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class is an example for a simple JPA entity. Notice that there is a
 * 'salary' property, which is sensitive and which we do not want to expose to
 * everyone. That is one reason why we do not want to use this class directly
 * from the REST tier (and instead use specific Transfer Objects).
 *
 * @author Olivier Liechti
 */
@NamedQueries(
				@NamedQuery(
								name = "findAllEmployees",
								query = "SELECT e FROM Player e"
				)
)

@Entity
public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private int numberOfPoints;

	public Player() {
		this(null, null, null, 0);
	}
	public Player(Player player) {
		this(player.firstName, player.lastName, player.email, player.numberOfPoints);
	}

	public Player(String firstName, String lastName, String email, int numberOfPoints) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numberOfPoints = numberOfPoints;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Player)) {
			return false;
		}
		Player other = (Player) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ch.heigvd.skeleton.model.Player[ id=" + id + " ]";
	}

}
