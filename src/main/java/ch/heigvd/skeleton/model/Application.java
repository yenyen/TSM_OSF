/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aurelien
 */
@NamedQueries({
	@NamedQuery(
            name = "findAllApplications",
            query = "SELECT e FROM Application e"
	),
        @NamedQuery(
            name = "findApplicaitonByKeyAndSecret",
            query = "SELECT a FROM Application a where a.apiKey = :apiKey and a.apiSecret = :apiSecret"
        )
})
@Entity
public class Application extends AbstractModel {
    private static final long serialVersionUID = 1L;
        
    private String name;
    private String description;
    private String apiKey;
    private String apiSecret;

    public Application(){
        this(null, null, null, null);
    }
    
    public Application(Application application){
        this(application.name, application.description, application.apiKey, application.apiSecret);
    }
    
    public Application(String name, String description, String apiKey, String apiSecret) {
        this.name = name;
        this.description = description;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
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

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
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
