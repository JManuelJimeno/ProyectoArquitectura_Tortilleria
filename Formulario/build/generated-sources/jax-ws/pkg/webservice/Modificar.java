
package pkg.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para modificar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="modificar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreTabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="condicion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modificar", propOrder = {
    "nombreTabla",
    "campos",
    "condicion"
})
public class Modificar {

    protected String nombreTabla;
    protected String campos;
    protected String condicion;

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

    /**
     * Obtiene el valor de la propiedad condicion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Define el valor de la propiedad condicion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondicion(String value) {
        this.condicion = value;
    }

}
