//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.02.01 at 03:57:39 PM EST 
//


package org.xframium.page.keyWord.provider.xsd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Step complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Step">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="parameter" type="{http://www.xframium.org/testRegistry}Parameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="token" type="{http://www.xframium.org/testRegistry}Token" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="step" type="{http://www.xframium.org/testRegistry}Step" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="site" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="CALL2"/>
 *             &lt;enumeration value="CLICK"/>
 *             &lt;enumeration value="EXISTS"/>
 *             &lt;enumeration value="FUNCTION"/>
 *             &lt;enumeration value="GESTURE"/>
 *             &lt;enumeration value="RETURN"/>
 *             &lt;enumeration value="SET"/>
 *             &lt;enumeration value="GET"/>
 *             &lt;enumeration value="WAIT"/>
 *             &lt;enumeration value="WAIT_FOR"/>
 *             &lt;enumeration value="ATTRIBUTE"/>
 *             &lt;enumeration value="LOOP"/>
 *             &lt;enumeration value="BREAK"/>
 *             &lt;enumeration value="DEVICE"/>
 *             &lt;enumeration value="FORK"/>
 *             &lt;enumeration value="VISIBLE"/>
 *             &lt;enumeration value="VERIFY_COLOR"/>
 *             &lt;enumeration value="VERIFY_CONTRAST"/>
 *             &lt;enumeration value="WINDOW"/>
 *             &lt;enumeration value="EXECJS"/>
 *             &lt;enumeration value="EXECWS"/>
 *             &lt;enumeration value="COMPARE2"/>
 *             &lt;enumeration value="STRING2"/>
 *             &lt;enumeration value="MATH"/>
 *             &lt;enumeration value="MOUSE"/>
 *             &lt;enumeration value="CACHE"/>
 *             &lt;enumeration value="REPORT"/>
 *             &lt;enumeration value="ADD_DEVICE"/>
 *             &lt;enumeration value="HAS_FOCUS"/>
 *             &lt;enumeration value="ALIGN"/>
 *             &lt;enumeration value="SYNC"/>
 *             &lt;enumeration value="AT"/>
 *             &lt;enumeration value="ELSE"/>
 *             &lt;enumeration value="STATE"/>
 *             &lt;enumeration value="ALERT"/>
 *             &lt;enumeration value="SQL"/>
 *             &lt;enumeration value="OPERATOR"/>
 *             &lt;enumeration value="NAVIGATE"/>
 *             &lt;enumeration value="VISUAL"/>
 *             &lt;enumeration value="SET_CONTENT_KEY"/>
 *             &lt;enumeration value="BROWSER"/>
 *             &lt;enumeration value="IS_ENABLED"/>
 *             &lt;enumeration value="ENABLED"/>
 *             &lt;enumeration value="COMMAND"/>
 *             &lt;enumeration value="EMAIL"/>
 *             &lt;enumeration value="APPLICATION"/>
 *             &lt;enumeration value="RANDOM"/>
 *             &lt;enumeration value="FLOW"/>
 *             &lt;enumeration value="CONSOLE"/>
 *             &lt;enumeration value="DATE"/>
 *             &lt;enumeration value="DEBUG"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="os" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="browser" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="poi" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="threshold" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" />
 *       &lt;attribute name="timed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="inverse" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="startAt" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="breakpoint" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="wait" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" />
 *       &lt;attribute name="failureMode" default="ERROR">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="ERROR"/>
 *             &lt;enumeration value="IGNORE"/>
 *             &lt;enumeration value="LOG_IGNORE"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="validation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="validationType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="REGEX"/>
 *             &lt;enumeration value="EMPTY"/>
 *             &lt;enumeration value="NOT_EMPTY"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="context" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="device" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tagNames" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="deviceTags" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="appContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="waitFor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Step", propOrder = {
    "parameter",
    "token",
    "step"
})
public class Step {

    protected List<Parameter> parameter;
    protected List<Token> token;
    protected List<Step> step;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "page")
    protected String page;
    @XmlAttribute(name = "site")
    protected String site;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "active")
    protected Boolean active;
    @XmlAttribute(name = "linkId")
    protected String linkId;
    @XmlAttribute(name = "os")
    protected String os;
    @XmlAttribute(name = "browser")
    protected String browser;
    @XmlAttribute(name = "poi")
    protected String poi;
    @XmlAttribute(name = "threshold")
    protected BigInteger threshold;
    @XmlAttribute(name = "timed")
    protected Boolean timed;
    @XmlAttribute(name = "inverse")
    protected Boolean inverse;
    @XmlAttribute(name = "startAt")
    protected Boolean startAt;
    @XmlAttribute(name = "breakpoint")
    protected Boolean breakpoint;
    @XmlAttribute(name = "wait")
    protected BigInteger wait;
    @XmlAttribute(name = "failureMode")
    protected String failureMode;
    @XmlAttribute(name = "validation")
    protected String validation;
    @XmlAttribute(name = "validationType")
    protected String validationType;
    @XmlAttribute(name = "context")
    protected String context;
    @XmlAttribute(name = "device")
    protected String device;
    @XmlAttribute(name = "tagNames")
    protected String tagNames;
    @XmlAttribute(name = "deviceTags")
    protected String deviceTags;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "appContext")
    protected String appContext;
    @XmlAttribute(name = "waitFor")
    protected String waitFor;

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parameter }
     * 
     * 
     */
    public List<Parameter> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<Parameter>();
        }
        return this.parameter;
    }

    /**
     * Gets the value of the token property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the token property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getToken().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Token }
     * 
     * 
     */
    public List<Token> getToken() {
        if (token == null) {
            token = new ArrayList<Token>();
        }
        return this.token;
    }

    /**
     * Gets the value of the step property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the step property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Step }
     * 
     * 
     */
    public List<Step> getStep() {
        if (step == null) {
            step = new ArrayList<Step>();
        }
        return this.step;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPage(String value) {
        this.page = value;
    }

    /**
     * Gets the value of the site property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSite() {
        return site;
    }

    /**
     * Sets the value of the site property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSite(String value) {
        this.site = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isActive() {
        if (active == null) {
            return true;
        } else {
            return active;
        }
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkId(String value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Gets the value of the browser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Sets the value of the browser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowser(String value) {
        this.browser = value;
    }

    /**
     * Gets the value of the poi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoi() {
        return poi;
    }

    /**
     * Sets the value of the poi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoi(String value) {
        this.poi = value;
    }

    /**
     * Gets the value of the threshold property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getThreshold() {
        if (threshold == null) {
            return new BigInteger("0");
        } else {
            return threshold;
        }
    }

    /**
     * Sets the value of the threshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setThreshold(BigInteger value) {
        this.threshold = value;
    }

    /**
     * Gets the value of the timed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTimed() {
        if (timed == null) {
            return false;
        } else {
            return timed;
        }
    }

    /**
     * Sets the value of the timed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimed(Boolean value) {
        this.timed = value;
    }

    /**
     * Gets the value of the inverse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isInverse() {
        if (inverse == null) {
            return false;
        } else {
            return inverse;
        }
    }

    /**
     * Sets the value of the inverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInverse(Boolean value) {
        this.inverse = value;
    }

    /**
     * Gets the value of the startAt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStartAt() {
        if (startAt == null) {
            return false;
        } else {
            return startAt;
        }
    }

    /**
     * Sets the value of the startAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStartAt(Boolean value) {
        this.startAt = value;
    }

    /**
     * Gets the value of the breakpoint property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBreakpoint() {
        if (breakpoint == null) {
            return false;
        } else {
            return breakpoint;
        }
    }

    /**
     * Sets the value of the breakpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBreakpoint(Boolean value) {
        this.breakpoint = value;
    }

    /**
     * Gets the value of the wait property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWait() {
        if (wait == null) {
            return new BigInteger("0");
        } else {
            return wait;
        }
    }

    /**
     * Sets the value of the wait property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWait(BigInteger value) {
        this.wait = value;
    }

    /**
     * Gets the value of the failureMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailureMode() {
        if (failureMode == null) {
            return "ERROR";
        } else {
            return failureMode;
        }
    }

    /**
     * Sets the value of the failureMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailureMode(String value) {
        this.failureMode = value;
    }

    /**
     * Gets the value of the validation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidation() {
        return validation;
    }

    /**
     * Sets the value of the validation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidation(String value) {
        this.validation = value;
    }

    /**
     * Gets the value of the validationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationType() {
        return validationType;
    }

    /**
     * Sets the value of the validationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationType(String value) {
        this.validationType = value;
    }

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        this.device = value;
    }

    /**
     * Gets the value of the tagNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagNames() {
        return tagNames;
    }

    /**
     * Sets the value of the tagNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagNames(String value) {
        this.tagNames = value;
    }

    /**
     * Gets the value of the deviceTags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceTags() {
        return deviceTags;
    }

    /**
     * Sets the value of the deviceTags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceTags(String value) {
        this.deviceTags = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the appContext property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppContext() {
        return appContext;
    }

    /**
     * Sets the value of the appContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppContext(String value) {
        this.appContext = value;
    }

    /**
     * Gets the value of the waitFor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitFor() {
        return waitFor;
    }

    /**
     * Sets the value of the waitFor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitFor(String value) {
        this.waitFor = value;
    }

}
