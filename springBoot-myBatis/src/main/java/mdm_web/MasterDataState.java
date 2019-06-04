
package mdm_web;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MasterDataState的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="MasterDataState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="UNCHANGE"/>
 *     &lt;enumeration value="SEAL"/>
 *     &lt;enumeration value="UPDATED"/>
 *     &lt;enumeration value="DELETED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MasterDataState", namespace = "http://sharing.mdm07.itf.yonyou.com/MasterDataState")
@XmlEnum
public enum MasterDataState {

    NONE,
    UNCHANGE,
    SEAL,
    UPDATED,
    DELETED;

    public String value() {
        return name();
    }

    public static MasterDataState fromValue(String v) {
        return valueOf(v);
    }

}
