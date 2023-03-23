/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pkg.webService;

import java.util.ArrayList;
import java.util.List;
import modelo.MDB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Manuel Jimeno
 */
@WebService(serviceName = "WSTortilleria")
public class WSTortilleria {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertar")
    public String insertar(@WebParam(name = "nombreTabla") final String nombreTabla, @WebParam(name = "campos") final String campos) {
        //TODO write your implementation code here:
        MDB adminBD = new MDB();        
        String resultado = adminBD.registrarAlta(nombreTabla, campos);        
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultar")
    public String consultar(@WebParam(name = "nombreTabla") final String nombreTabla, @WebParam(name = "datos") final String datos, @WebParam(name = "condicion") final String condicion) {
        //TODO write your implementation code here:
        MDB adminBD = new MDB();
        
        
        
        String [] extraer = new String[100];
        String info="";
        int i, j;
        
        List<ArrayList<String>> datosObtenidos = new ArrayList<ArrayList<String>>();
            ArrayList<String> infoReclutada= new ArrayList<String>();
            datosObtenidos= adminBD.consultarDatos(nombreTabla,datos,condicion);

                    for(i=0;i<datosObtenidos.size();i++){

                        infoReclutada = datosObtenidos.get(i);

                        for(j=0;j<infoReclutada.size();j++){
                            info = info + infoReclutada.get(j)+",";
                        }

                        extraer[i] = info;

                    }

                    return info;   
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public String eliminar(@WebParam(name = "nombreTabla") final String nombreTabla, @WebParam(name = "condicion") final String condicion) {
        //TODO write your implementation code here:
        MDB adminBD = new MDB();        
        String resultado = adminBD.borrarRegistro(nombreTabla, condicion);        
        return resultado;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificar")
    public String modificar(@WebParam(name = "nombreTabla") final String nombreTabla, @WebParam(name = "campos") final String campos, @WebParam(name = "condicion") final String condicion) {
        //TODO write your implementation code here:
        MDB adminBD = new MDB();        
        String resultado = adminBD.modificarRegistro(nombreTabla, campos, condicion);
        return resultado;        
    }
}
