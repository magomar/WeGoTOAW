
package wegotoaw.data.wrappers.scenario;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Place complex unitType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Place">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="X" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Y" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Place", namespace = "wegotoaw", propOrder = {
        "x",
        "y",
        "name"
})
public class Place {

    @XmlElement(name = "X", namespace = "wegotoaw")
    protected int x;
    @XmlElement(name = "Y", namespace = "wegotoaw")
    protected int y;
    @XmlElement(name = "Name", namespace = "wegotoaw", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    /**
     * Gets the value of the x property.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the id property.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(int value) {
        this.id = value;
    }

}
