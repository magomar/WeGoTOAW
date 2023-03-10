
package wegotoaw.data.wrappers.scenario;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Events complex unitType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Events">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="Event" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Trigger" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element name="Contingency" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                     &lt;element name="Effect" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element name="X" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                     &lt;element name="Y" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                     &lt;element name="Value" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                     &lt;element name="Turn" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                     &lt;element name="News" unitType="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                     &lt;element name="Variable" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Events", namespace = "wegotoaw", propOrder = {
        "event"
})
public class Events {

    @XmlElement(name = "Event", namespace = "wegotoaw", required = true)
    protected List<Event> event;

    /**
     * Gets the value of the event property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the event property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvent().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following unitType(s) are allowed in the list
     * {@link Event }
     */
    public List<Event> getEvent() {
        if (event == null) {
            event = new ArrayList<Event>();
        }
        return this.event;
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
     *         &lt;element name="Trigger" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Contingency" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="Effect" unitType="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="X" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="Y" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="Value" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="Turn" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="News" unitType="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Variable" unitType="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "trigger",
            "contingency",
            "effect",
            "x",
            "y",
            "value",
            "turn",
            "news",
            "variable"
    })
    public static class Event {

        @XmlElement(name = "Trigger", namespace = "wegotoaw", required = true)
        protected String trigger;
        @XmlElement(name = "Contingency", namespace = "wegotoaw")
        protected Integer contingency;
        @XmlElement(name = "Effect", namespace = "wegotoaw", required = true)
        protected String effect;
        @XmlElement(name = "X", namespace = "wegotoaw")
        protected Integer x;
        @XmlElement(name = "Y", namespace = "wegotoaw")
        protected Integer y;
        @XmlElement(name = "Value", namespace = "wegotoaw")
        protected Integer value;
        @XmlElement(name = "Turn", namespace = "wegotoaw")
        protected Integer turn;
        @XmlElement(name = "News", namespace = "wegotoaw")
        protected String news;
        @XmlElement(name = "Variable", namespace = "wegotoaw")
        protected Integer variable;
        @XmlAttribute(name = "id", required = true)
        protected int id;

        /**
         * Gets the value of the trigger property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getTrigger() {
            return trigger;
        }

        /**
         * Sets the value of the trigger property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setTrigger(String value) {
            this.trigger = value;
        }

        /**
         * Gets the value of the contingency property.
         *
         * @return possible object is
         *         {@link Integer }
         */
        public Integer getContingency() {
            return contingency;
        }

        /**
         * Sets the value of the contingency property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setContingency(Integer value) {
            this.contingency = value;
        }

        /**
         * Gets the value of the effect property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getEffect() {
            return effect;
        }

        /**
         * Sets the value of the effect property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setEffect(String value) {
            this.effect = value;
        }

        /**
         * Gets the value of the x property.
         *
         * @return possible object is
         *         {@link Integer }
         */
        public Integer getX() {
            return x;
        }

        /**
         * Sets the value of the x property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setX(Integer value) {
            this.x = value;
        }

        /**
         * Gets the value of the y property.
         *
         * @return possible object is
         *         {@link Integer }
         */
        public Integer getY() {
            return y;
        }

        /**
         * Sets the value of the y property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setY(Integer value) {
            this.y = value;
        }

        /**
         * Gets the value of the value property.
         *
         * @return possible object is
         *         {@link Integer }
         */
        public Integer getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setValue(Integer value) {
            this.value = value;
        }

        /**
         * Gets the value of the turn property.
         *
         * @return possible object is
         *         {@link Integer }
         */
        public Integer getTurn() {
            return turn;
        }

        /**
         * Sets the value of the turn property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setTurn(Integer value) {
            this.turn = value;
        }

        /**
         * Gets the value of the news property.
         *
         * @return possible object is
         *         {@link String }
         */
        public String getNews() {
            return news;
        }

        /**
         * Sets the value of the news property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNews(String value) {
            this.news = value;
        }

        /**
         * Gets the value of the variable property.
         *
         * @return possible object is
         *         {@link Integer }
         */
        public Integer getVariable() {
            return variable;
        }

        /**
         * Sets the value of the variable property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setVariable(Integer value) {
            this.variable = value;
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
