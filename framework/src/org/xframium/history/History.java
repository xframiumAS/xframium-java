//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.08 at 01:03:54 PM EDT 
//


package org.xframium.history;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for History complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="History"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="testCase" type="{http://www.xframium.org/tcHistory}TestCase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="suite" type="{http://www.xframium.org/tcHistory}TestSuite" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "History", propOrder = {
    "testCase",
    "suite"
})
public class History {

    protected List<TestCase> testCase;
    protected List<TestSuite> suite;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the testCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the testCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTestCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TestCase }
     * 
     * 
     */
    public List<TestCase> getTestCase() {
        if (testCase == null) {
            testCase = new ArrayList<TestCase>();
        }
        return this.testCase;
    }

    /**
     * Gets the value of the suite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TestSuite }
     * 
     * 
     */
    public List<TestSuite> getSuite() {
        if (suite == null) {
            suite = new ArrayList<TestSuite>();
        }
        return this.suite;
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

}
