
package mdm_web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="string" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="string3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "string",
    "string1",
    "string2",
    "string3"
})
@XmlRootElement(name = "queryMdmcodeByGdCode")
public class QueryMdmcodeByGdCode {

    @XmlElementRef(name = "string", namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string;
    @XmlElementRef(name = "string1", namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string1;
    @XmlElementRef(name = "string2", namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string2;
    @XmlElementRef(name = "string3", namespace = "http://sharing.mdm07.itf.yonyou.com/IMdSharingCenterService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> string3;

    /**
     * 获取string属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString() {
        return string;
    }

    /**
     * 设置string属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString(JAXBElement<String> value) {
        this.string = value;
    }

    /**
     * 获取string1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString1() {
        return string1;
    }

    /**
     * 设置string1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString1(JAXBElement<String> value) {
        this.string1 = value;
    }

    /**
     * 获取string2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString2() {
        return string2;
    }

    /**
     * 设置string2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString2(JAXBElement<String> value) {
        this.string2 = value;
    }

    /**
     * 获取string3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getString3() {
        return string3;
    }

    /**
     * 设置string3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setString3(JAXBElement<String> value) {
        this.string3 = value;
    }

}
