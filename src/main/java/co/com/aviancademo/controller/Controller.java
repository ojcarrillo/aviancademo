/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.aviancademo.controller;

import co.com.aviancademo.model.Reserva;
import co.com.aviancademo.model.Response;

/**
 *
 * @author Sala BD
 */
public interface Controller {
    
    public Reserva consultarReserva(String idReserva);
    public Response cancelarReserva(String idReserva);
    public Response crearReserva(Reserva reserva);
    
}
