package ch.heigvd.skeleton.to;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is an example for a Transfer Object, which will be used to send data to
 * the client. Instances of this class will be created from JPA entities, but
 * will not expose all attributes. In this example, we do not want to send
 * salary information to everyone, so we have stripped this information. In some
 * cases, a transfer object may also be used to aggregate properties from
 * several JPA entities.
 *
 * The class must have an empty constructor, as well as getters and setters for
 * properties (this is required for the JAXB marshalling to work properly). That
 * is also why we have the @XmlRootElement annotation at the class level.
 *
 * @author Olivier Liechti
 */
@XmlRootElement
public class PublicApplicationTO extends AbstractPublicTO{
    private String name;
    private String description;
    private String apiKey;
    private String apiSecret;

    public PublicApplicationTO() {
    }

    public PublicApplicationTO(long id, String name, String description, String apiKey, String apiSecret) {
            super(id);
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
}
