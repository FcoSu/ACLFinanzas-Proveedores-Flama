package com.everis.latam.ACLFinanzasProveedoresFlama.Entity;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Solicitud {
	
	int idProveedor;
	String nombreArea;
	String responsable;
	String email;
	String ceco;
	int idAprovador;
}
