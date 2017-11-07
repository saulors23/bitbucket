package com.fellows.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fellows.entity.Clock;

@Path("/clock")
public class JSONService {

	private static Clock[][] lista = new Clock[13][60];

	public JSONService() {
	}

	@GET
	@Path("{hora}/{minuto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Clock getClockInJSON(@PathParam("hora") int hora, @PathParam("minuto") int minuto) {

		Clock c = null;

		int _hora = hora;
		int _minuto = minuto;

		if (_hora < 0) {
			_hora = 0;
		}
		if (_hora > 11) {
			_hora = 12;
		}
		if (_minuto < 0) {
			_minuto = 0;
		}
		if (_minuto > 59) {
			_minuto = 0;
		}

		if (JSONService.lista[hora][minuto] == null) {
			c = new Clock();
			c.setHour(hora);
			c.setMinute(minuto);
			JSONService.lista[hora][minuto] = c;
		} else {
			System.out.println("from cache");
			c = JSONService.lista[hora][minuto];
		}

		return c;
	}

	@GET
	@Path("{hora}")
	@Produces(MediaType.APPLICATION_JSON)
	public Clock getClockInJSON(@PathParam("hora") int hora) {
		return getClockInJSON(hora, 0);
	}

}