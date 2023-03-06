
package wegotoaw.data.wrappers.scenario;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Supplies complex unitType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Supplies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Force" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Node" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="x" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="y" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="supply" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "Supplies", namespace = "wegotoaw", propOrder = {
        "force"
})
public class Supplies {

    @XmlElement(name = "Force", namespace = "wegotoaw", required = true)
    protected List<Force> force;

    /**
     * Gets the value of the force property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the force property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForce().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following unitType(s) are allowed in the list
     * {@link Force }
     */
    public List<Force> getForce() {
        if (force == null) {
            force = new ArrayList<Force>();
        }
        return this.force;
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
     *         &lt;element name="Node" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="x" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="y" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="supply" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
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
            "node"
    })
    public static class Force {

        @XmlElement(name = "Node", namespace = "wegotoaw", required = true)
        protected List<Node> node;
        @XmlAttribute(name = "id", required = true)
        protected int id;

        /**
         * Gets the value of the node property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the node property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNode().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following unitType(s) are allowed in the list
         * {@link Node }
         */
        public List<Node> getNode() {
            if (node == null) {
                node = new ArrayList<Node>();
            }
            return this.node;
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
         *         &lt;element name="x" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="y" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="supply" unitType="{http://www.w3.org/2001/XMLSchema}int"/>
         *       &lt;/sequence>
         *       &lt;attribute name="id" use="required" unitType="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "x",
                "y",
                "supply"
        })
        public static class Node {

            @XmlElement(namespace = "wegotoaw")
            protected int x;
            @XmlElement(namespace = "wegotoaw")
            protected int y;
            @XmlElement(namespace = "wegotoaw")
            protected int supply;
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
