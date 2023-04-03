
package pkg.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreTabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertar", propOrder = {
    "nombreTabla",
    "campos"
})
public class Insertar {

    protected String nombreTabla;
    protected String campos;

    /**
     * Obtiene el valor de la propiedad nombreTabla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * Define el valor de la propiedad nombreTabla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTabla(String value) {
        this.nombreTabla = value;
    }

    /**
     * Obtiene el valor de la propiedad campos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampos() {
        return campos;
    }

    /**
     * Define el valor de la propiedad campos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampos(String value) {
        this.campos = value;
    }

}
