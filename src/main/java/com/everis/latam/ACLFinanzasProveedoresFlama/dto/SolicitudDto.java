package com.everis.latam.ACLFinanzasProveedoresFlama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SolicitudDto {
	
	int idProveedor;
	String nombreArea;
	String responsable;
	String email;
	String ceco;
	int idAprovador;
	
}
