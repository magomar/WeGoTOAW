
package wegotoaw.data.wrappers.scenario;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Precipitation.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="Precipitation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HEAVY"/>
 *     &lt;enumeration value="MODERATE"/>
 *     &lt;enumeration value="LIGHT"/>
 *     &lt;enumeration value="OCCASIONAL"/>
 *     &lt;enumeration value="NO_PRECIPITATIONS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "Precipitation", namespace = "wegotoaw")
@XmlEnum
public enum Precipitation {

    HEAVY,
    MODERATE,
    LIGHT,
    OCCASIONAL,
    NO_PRECIPITATIONS;

    public String value() {
        return name();
    }

    public static Precipitation fromValue(String v) {
        return valueOf(v);
    }

}
