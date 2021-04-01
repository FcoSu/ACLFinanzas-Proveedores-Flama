package com.everis.latam.ACLFinanzasProveedoresFlama.Entity;


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
