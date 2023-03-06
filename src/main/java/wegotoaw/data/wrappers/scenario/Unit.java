
package wegotoaw.data.wrappers.scenario;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Unit complex unitType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Unit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" unitType="{ares}UnitType"/>
 *         &lt;element name="IconId" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Color" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Size" unitType="{ares}Echelon"/>
 *         &lt;element name="Experience" unitType="{ares}Experience"/>
 *         &lt;element name="Proficiency" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Readiness" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Supply" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="X" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Y" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Emphasis" unitType="{ares}Emphasis"/>
 *         &lt;element name="Availability" unitType="{ares}Availability"/>
 *         &lt;element name="OpState" unitType="{ares}OpState"/>
 *         &lt;element name="ReplacementPriority" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Entry" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Parent" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Equipment" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Number" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Max" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Unit", namespace = "wegotoaw", propOrder = {
        "name",
        "type",
        "iconId",
        "color",
        "size",
        "experience",
        "proficiency",
        "readiness",
        "supply",
        "x",
        "y",
        "emphasis",
        "availability",
        "opState",
        "replacementPriority",
        "entry",
        "parent",
        "equipment"
})
public class Unit {

    @XmlElement(name = "Name", namespace = "wegotoaw", required = true)
    protected String name;
    @XmlElement(name = "Type", namespace = "wegotoaw", required = true)
    protected UnitType type;
    @XmlElement(name = "IconId", namespace = "wegotoaw")
    protected int iconId;
    @XmlElement(name = "Color", namespace = "wegotoaw")
    protected int color;
    @XmlElement(name = "Size", namespace = "wegotoaw", required = true)
    protected Echelon size;
    @XmlElement(name = "Experience", namespace = "wegotoaw", required = true)
    protected Experience experience;
    @XmlElement(name = "Proficiency", namespace = "wegotoaw", defaultValue = "33")
    protected int proficiency;
    @XmlElement(name = "Readiness", namespace = "wegotoaw", defaultValue = "100")
    protected int readiness;
    @XmlElement(name = "Supply", namespace = "wegotoaw", defaultValue = "100")
    protected int supply;
    @XmlElement(name = "X", namespace = "wegotoaw")
    protected int x;
    @XmlElement(name = "Y", namespace = "wegotoaw")
    protected int y;
    @XmlElement(name = "Emphasis", namespace = "wegotoaw", required = true)
    protected Emphasis emphasis;
    @XmlElement(name = "Availability", namespace = "wegotoaw", required = true)
    protected Availability availability;
    @XmlElement(name = "OpState", namespace = "wegotoaw", required = true)
    protected OpState opState;
    @XmlElement(name = "ReplacementPriority", namespace = "wegotoaw")
    protected int replacementPriority;
    @XmlElement(name = "Entry", namespace = "wegotoaw")
    protected Integer entry;
    @XmlElement(name = "Parent", namespace = "wegotoaw")
    protected Integer parent;
    @XmlElement(name = "Equipment", namespace = "wegotoaw", required = true)
    protected List<Equipment> equipment;
    @XmlAttribute(name = "id", required = true)
    protected int id;

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
     * Gets the value of the unitType property.
     *
     * @return possible object is
     *         {@link UnitType }
     */
    public UnitType getType() {
        return type;
    }

    /**
     * Sets the value of the unitType property.
     *
     * @param value allowed object is
     *              {@link UnitType }
     */
    public void setType(UnitType value) {
        this.type = value;
    }

    /**
     * Gets the value of the iconId property.
     */
    public int getIconId() {
        return iconId;
    }

    /**
     * Sets the value of the iconId property.
     */
    public void setIconId(int value) {
        this.iconId = value;
    }

    /**
     * Gets the value of the color property.
     */
    public int getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     */
    public void setColor(int value) {
        this.color = value;
    }

    /**
     * Gets the value of the size property.
     *
     * @return possible object is
     *         {@link Echelon }
     */
    public Echelon getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value allowed object is
     *              {@link Echelon }
     */
    public void setSize(Echelon value) {
        this.size = value;
    }

    /**
     * Gets the value of the experience property.
     *
     * @return possible object is
     *         {@link Experience }
     */
    public Experience getExperience() {
        return experience;
    }

    /**
     * Sets the value of the experience property.
     *
     * @param value allowed object is
     *              {@link Experience }
     */
    public void setExperience(Experience value) {
        this.experience = value;
    }

    /**
     * Gets the value of the proficiency property.
     */
    public int getProficiency() {
        return proficiency;
    }

    /**
     * Sets the value of the proficiency property.
     */
    public void setProficiency(int value) {
        this.proficiency = value;
    }

    /**
     * Gets the value of the readiness property.
     */
    public int getReadiness() {
        return readiness;
    }

    /**
     * Sets the value of the readiness property.
     */
    public void setReadiness(int value) {
        this.readiness = value;
    }

    /**
     * Gets the value of the supply property.
     */
    public int getSupply() {
        return supply;
    }

    /**
     * Sets the value of the supply property.
     */
    public void setSupply(int value) {
        this.supply = value;
    }

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
     * Gets the value of the emphasis property.
     *
     * @return possible object is
     *         {@link Emphasis }
     */
    public Emphasis getEmphasis() {
        return emphasis;
    }

    /**
     * Sets the value of the emphasis property.
     *
     * @param value allowed object is
     *              {@link Emphasis }
     */
    public void setEmphasis(Emphasis value) {
        this.emphasis = value;
    }

    /**
     * Gets the value of the availability property.
     *
     * @return possible object is
     *         {@link Availability }
     */
    public Availability getAvailability() {
        return availability;
    }

    /**
     * Sets the value of the availability property.
     *
     * @param value allowed object is
     *              {@link Availability }
     */
    public void setAvailability(Availability value) {
        this.availability = value;
    }

    /**
     * Gets the value of the opState property.
     *
     * @return possible object is
     *         {@link OpState }
     */
    public OpState getOpState() {
        return opState;
    }

    /**
     * Sets the value of the opState property.
     *
     * @param value allowed object is
     *              {@link OpState }
     */
    public void setOpState(OpState value) {
        this.opState = value;
    }

    /**
     * Gets the value of the replacementPriority property.
     */
    public int getReplacementPriority() {
        return replacementPriority;
    }

    /**
     * Sets the value of the replacementPriority property.
     */
    public void setReplacementPriority(int value) {
        this.replacementPriority = value;
    }

    /**
     * Gets the value of the entry property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getEntry() {
        return entry;
    }

    /**
     * Sets the value of the entry property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setEntry(Integer value) {
        this.entry = value;
    }

    /**
     * Gets the value of the parent property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setParent(Integer value) {
        this.parent = value;
    }

    /**
     * Gets the value of the equipment property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipment property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipment().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following unitType(s) are allowed in the list
     * {@link Equipment }
     */
    public List<Equipment> getEquipment() {
        if (equipment == null) {
            equipment = new ArrayList<Equipment>();
        }
        return this.equipment;
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


    /**
     * <p>Java class for anonymous complex unitType.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Number" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Max" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "name",
            "number",
            "max"
    })
    public static class Equipment {

        @XmlElement(name = "Name", namespace = "wegotoaw", required = true)
        protected String name;
        @XmlElement(name = "Number", namespace = "wegotoaw")
        protected int number;
        @XmlElement(name = "Max", namespace = "wegotoaw")
        protected int max;
        @XmlAttribute(name = "id", required = true)
        protected int id;

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
         * Gets the value of the number property.
         */
        public int getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         */
        public void setNumber(int value) {
            this.number = value;
        }

        /**
         * Gets the value of the max property.
         */
        public int getMax() {
            return max;
        }

        /**
         * Sets the value of the max property.
         */
        public void setMax(int value) {
            this.max = value;
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

}
