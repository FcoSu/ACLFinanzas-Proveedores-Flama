package com.everis.latam.ACLFinanzasProveedoresFlama.Entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Response {
	
	String estatus;
	int montoTotal;
	int idResolucion;
	@JsonFormat(pattern="yyyy-MM-dd")
	Timestamp fechaResolucion;
	int idSolicitud;
}

}
