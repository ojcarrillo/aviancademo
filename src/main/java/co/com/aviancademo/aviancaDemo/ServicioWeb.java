/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.aviancademo.aviancaDemo;

import co.com.aviancademo.controller.Controlador;
import co.com.aviancademo.model.Reserva;
import co.com.aviancademo.model.Response;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Sala BD
 */
@WebService(name = "Avianca")
public class ServicioWeb {
    
    
    private static Controlador cont = new Controlador();
    
    @WebMethod(action = "consultarReserva" , operationName = "ConsultarReserva")
    @WebResult(name = "Reserva")
    public Reserva consultarReserva(@WebParam(name = "IdReserva") String idReserva){
        return cont.consultarReserva(idReserva);
    }
    @WebMethod(action = "realizarReserva" , operationName = "RealizarReserva")
    @WebResult(name = "Response")
    public Response realizarReserva(@WebParam(name = "Reserva") Reserva reserva){
        return cont.crearReserva(reserva);
    } 
    @WebMethod(action = "cancelarReserva" , operationName = "CancelarReserva")
    @WebResult(name = "Response")
    public Response cancelarReserva(@WebParam(name = "IdReserva") String idReserva){
        return cont.cancelarReserva(idReserva);
    }
    
    public static void main(String[] args) {
		//SpringApplication.run(AviancaDemoApplication.class, args);
                final String uri = "http://localhost:7001/Avianca";
                System.out.println("DEPLOYING");
                
                System.out.println("Endpoint WSDL >> "+uri);
                Endpoint.publish(uri, new ServicioWeb() );
                System.out.println("DEPLOYED");
	}
    
}
