/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.aviancademo.controller;

import co.com.aviancademo.model.Reserva;
import co.com.aviancademo.model.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Sala BD
 */
public class Controlador implements Controller{
    protected static HashMap memoria ;
    
    public Controlador(){
        memoria = new HashMap();
    }
    @Override
    public Reserva consultarReserva(String idReserva) {
        Reserva res = new Reserva();
        
        if(memoria.containsKey(idReserva)){
            res = (Reserva)memoria.get(idReserva);
        }
        return res;
    }

    @Override
    public Response cancelarReserva(String idReserva) {
        Response respuesta = new Response();
        if(memoria.containsKey(idReserva)){
            memoria.remove(idReserva);
            respuesta.setCodigo("00");
            respuesta.setEstado("SUCCESS");
            respuesta.setMensaje("Reserva Cancelada Exitosamente.");
        }else{
            respuesta.setCodigo("01");
            respuesta.setEstado("ERROR");
            respuesta.setMensaje("La Reserva No Existe");
        }
        return respuesta;
    }

    @Override
    public Response crearReserva(Reserva reserva) {
        Response respuesta = new Response();
        String idReserva = "AR"+Calendar.getInstance().get(Calendar.YEAR)+new Date().getTime();
        respuesta.setCodigo("00");
        respuesta.setEstado("SUCCESS");
        respuesta.setMensaje(""+idReserva);
        memoria.put(idReserva, reserva);
        return respuesta;
    }
    
    
}
