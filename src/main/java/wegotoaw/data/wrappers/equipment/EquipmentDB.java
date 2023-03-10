
package wegotoaw.data.wrappers.equipment;

import wegotoaw.data.wrappers.scenario.Trait;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="EquipmentCategory" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Country" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Item" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Country" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Icon" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="AT" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="AP" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="AA" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="DF" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Personnel" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Crew" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="ArtyRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="EarlyRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="SAMRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Nuke" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Volume" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Weight" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="ShellWeight" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Armor" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="Trait" unitType="{ares}Trait" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "equipmentCategory"
})
@XmlRootElement(name = "EquipmentDB", namespace = "wegotoaw")
public class EquipmentDB {

    @XmlElement(name = "EquipmentCategory", namespace = "wegotoaw", required = true)
    protected List<EquipmentCategory> equipmentCategory;

    /**
     * Gets the value of the equipmentCategory property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the equipmentCategory property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEquipmentCategory().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following unitType(s) are allowed in the list
     * {@link EquipmentCategory }
     */
    public List<EquipmentCategory> getEquipmentCategory() {
        if (equipmentCategory == null) {
            equipmentCategory = new ArrayList<EquipmentCategory>();
        }
        return this.equipmentCategory;
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
     *         &lt;element name="Country" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Item" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Name" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Country" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Icon" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="AT" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="AP" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="AA" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="DF" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Personnel" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Crew" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="ArtyRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="EarlyRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="SAMRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Nuke" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Volume" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Weight" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="ShellWeight" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Armor" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="Trait" unitType="{ares}Trait" maxOccurs="unbounded"/>
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
    @XmlType(name = "", propOrder = {
            "name",
            "country",
            "item"
    })
    public static class EquipmentCategory {

        @XmlElement(name = "Name", namespace = "wegotoaw", required = true)
        protected String name;
        @XmlElement(name = "Country", namespace = "wegotoaw", required = true)
        protected String country;
        @XmlElement(name = "Item", namespace = "wegotoaw", required = true)
        protected List<Item> item;
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
         * Gets the value of the country property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCountry(String value) {
            this.country = value;
        }

        /**
         * Gets the value of the item property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following unitType(s) are allowed in the list
         * {@link Item }
         */
        public List<Item> getItem() {
            if (item == null) {
                item = new ArrayList<Item>();
            }
            return this.item;
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
         *         &lt;element name="Country" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Icon" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="AT" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="AP" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="AA" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="DF" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Personnel" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Crew" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="ArtyRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="EarlyRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="SAMRange" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Nuke" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Volume" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Weight" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="ShellWeight" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Armor" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="Trait" unitType="{ares}Trait" maxOccurs="unbounded"/>
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
                "country",
                "icon",
                "at",
                "ap",
                "aa",
                "df",
                "personnel",
                "crew",
                "artyRange",
                "earlyRange",
                "samRange",
                "nuke",
                "volume",
                "weight",
                "shellWeight",
                "armor",
                "trait"
        })
        public static class Item {

            @XmlElement(name = "Name", namespace = "wegotoaw", required = true)
            protected String name;
            @XmlElement(name = "Country", namespace = "wegotoaw", required = true)
            protected String country;
            @XmlElement(name = "Icon", namespace = "wegotoaw")
            protected int icon;
            @XmlElement(name = "AT", namespace = "wegotoaw")
            protected int at;
            @XmlElement(name = "AP", namespace = "wegotoaw")
            protected int ap;
            @XmlElement(name = "AA", namespace = "wegotoaw")
            protected int aa;
            @XmlElement(name = "DF", namespace = "wegotoaw")
            protected int df;
            @XmlElement(name = "Personnel", namespace = "wegotoaw")
            protected int personnel;
            @XmlElement(name = "Crew", namespace = "wegotoaw")
            protected int crew;
            @XmlElement(name = "ArtyRange", namespace = "wegotoaw")
            protected int artyRange;
            @XmlElement(name = "EarlyRange", namespace = "wegotoaw")
            protected int earlyRange;
            @XmlElement(name = "SAMRange", namespace = "wegotoaw")
            protected int samRange;
            @XmlElement(name = "Nuke", namespace = "wegotoaw")
            protected int nuke;
            @XmlElement(name = "Volume", namespace = "wegotoaw")
            protected int volume;
            @XmlElement(name = "Weight", namespace = "wegotoaw")
            protected int weight;
            @XmlElement(name = "ShellWeight", namespace = "wegotoaw")
            protected int shellWeight;
            @XmlElement(name = "Armor", namespace = "wegotoaw")
            protected int armor;
            @XmlElement(name = "Trait", namespace = "wegotoaw", required = true)
            protected List<Trait> trait;
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
             * Gets the value of the country property.
             *
             * @return possible object is
             *         {@link String }
             */
            public String getCountry() {
                return country;
            }

            /**
             * Sets the value of the country property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Gets the value of the icon property.
             */
            public int getIcon() {
                return icon;
            }

            /**
             * Sets the value of the icon property.
             */
            public void setIcon(int value) {
                this.icon = value;
            }

            /**
             * Gets the value of the at property.
             */
            public int getAT() {
                return at;
            }

            /**
             * Sets the value of the at property.
             */
            public void setAT(int value) {
                this.at = value;
            }

            /**
             * Gets the value of the ap property.
             */
            public int getAP() {
                return ap;
            }

            /**
             * Sets the value of the ap property.
             */
            public void setAP(int value) {
                this.ap = value;
            }

            /**
             * Gets the value of the aa property.
             */
            public int getAA() {
                return aa;
            }

            /**
             * Sets the value of the aa property.
             */
            public void setAA(int value) {
                this.aa = value;
            }

            /**
             * Gets the value of the df property.
             */
            public int getDF() {
                return df;
            }

            /**
             * Sets the value of the df property.
             */
            public void setDF(int value) {
                this.df = value;
            }

            /**
             * Gets the value of the personnel property.
             */
            public int getPersonnel() {
                return personnel;
            }

            /**
             * Sets the value of the personnel property.
             */
            public void setPersonnel(int value) {
                this.personnel = value;
            }

            /**
             * Gets the value of the crew property.
             */
            public int getCrew() {
                return crew;
            }

            /**
             * Sets the value of the crew property.
             */
            public void setCrew(int value) {
                this.crew = value;
            }

            /**
             * Gets the value of the artyRange property.
             */
            public int getArtyRange() {
                return artyRange;
            }

            /**
             * Sets the value of the artyRange property.
             */
            public void setArtyRange(int value) {
                this.artyRange = value;
            }

            /**
             * Gets the value of the earlyRange property.
             */
            public int getEarlyRange() {
                return earlyRange;
            }

            /**
             * Sets the value of the earlyRange property.
             */
            public void setEarlyRange(int value) {
                this.earlyRange = value;
            }

            /**
             * Gets the value of the samRange property.
             */
            public int getSAMRange() {
                return samRange;
            }

            /**
             * Sets the value of the samRange property.
             */
            public void setSAMRange(int value) {
                this.samRange = value;
            }

            /**
             * Gets the value of the nuke property.
             */
            public int getNuke() {
                return nuke;
            }

            /**
             * Sets the value of the nuke property.
             */
            public void setNuke(int value) {
                this.nuke = value;
            }

            /**
             * Gets the value of the volume property.
             */
            public int getVolume() {
                return volume;
            }

            /**
             * Sets the value of the volume property.
             */
            public void setVolume(int value) {
                this.volume = value;
            }

            /**
             * Gets the value of the weight property.
             */
            public int getWeight() {
                return weight;
            }

            /**
             * Sets the value of the weight property.
             */
            public void setWeight(int value) {
                this.weight = value;
            }

            /**
             * Gets the value of the shellWeight property.
             */
            public int getShellWeight() {
                return shellWeight;
            }

            /**
             * Sets the value of the shellWeight property.
             */
            public void setShellWeight(int value) {
                this.shellWeight = value;
            }

            /**
             * Gets the value of the armor property.
             */
            public int getArmor() {
                return armor;
            }

            /**
             * Sets the value of the armor property.
             */
            public void setArmor(int value) {
                this.armor = value;
            }

            /**
             * Gets the value of the trait property.
             * <p/>
             * <p/>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the trait property.
             * <p/>
             * <p/>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTrait().add(newItem);
             * </pre>
             * <p/>
             * <p/>
             * <p/>
             * Objects of the following unitType(s) are allowed in the list
             * {@link Trait }
             */
            public List<Trait> getTrait() {
                if (trait == null) {
                    trait = new ArrayList<Trait>();
                }
                return this.trait;
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

}
