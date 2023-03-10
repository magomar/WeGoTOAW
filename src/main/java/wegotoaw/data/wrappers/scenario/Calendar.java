
package wegotoaw.data.wrappers.scenario;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Calendar complex unitType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Calendar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TurnLength" unitType="{ares}TurnLength"/>
 *         &lt;element name="StartQuarterDay" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartDate" unitType="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CurrentTurn" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FinalTurn" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Calendar", namespace = "wegotoaw", propOrder = {
        "turnLength",
        "startQuarterDay",
        "startDate",
        "currentTurn",
        "finalTurn"
})
public class Calendar {

    @XmlElement(name = "TurnLength", namespace = "wegotoaw", required = true)
    protected TurnLength turnLength;
    @XmlElement(name = "StartQuarterDay", namespace = "wegotoaw")
    protected int startQuarterDay;
    @XmlElement(name = "StartDate", namespace = "wegotoaw", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "CurrentTurn", namespace = "wegotoaw")
    protected int currentTurn;
    @XmlElement(name = "FinalTurn", namespace = "wegotoaw")
    protected int finalTurn;

    /**
     * Gets the value of the turnLength property.
     *
     * @return possible object is
     *         {@link TurnLength }
     */
    public TurnLength getTurnLength() {
        return turnLength;
    }

    /**
     * Sets the value of the turnLength property.
     *
     * @param value allowed object is
     *              {@link TurnLength }
     */
    public void setTurnLength(TurnLength value) {
        this.turnLength = value;
    }

    /**
     * Gets the value of the startQuarterDay property.
     */
    public int getStartQuarterDay() {
        return startQuarterDay;
    }

    /**
     * Sets the value of the startQuarterDay property.
     */
    public void setStartQuarterDay(int value) {
        this.startQuarterDay = value;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the currentTurn property.
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Sets the value of the currentTurn property.
     */
    public void setCurrentTurn(int value) {
        this.currentTurn = value;
    }

    /**
     * Gets the value of the finalTurn property.
     */
    public int getFinalTurn() {
        return finalTurn;
    }

    /**
     * Sets the value of the finalTurn property.
     */
    public void setFinalTurn(int value) {
        this.finalTurn = value;
    }

}
