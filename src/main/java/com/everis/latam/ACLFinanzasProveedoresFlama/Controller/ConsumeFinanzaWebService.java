package com.everis.latam.ACLFinanzasProveedoresFlama.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.latam.ACLFinanzasProveedoresFlama.Entity.Request;
import com.everis.latam.ACLFinanzasProveedoresFlama.Entity.Response;
import com.everis.latam.ACLFinanzasProveedoresFlama.Entity.Solicitud;
import com.everis.latam.ACLFinanzasProveedoresFlama.Exception.BadRequestException;
import com.everis.latam.ACLFinanzasProveedoresFlama.Exception.ExceptionPost;
import com.everis.latam.ACLFinanzasProveedoresFlama.URLs.URLs;
import com.everis.latam.ACLFinanzasProveedoresFlama.dto.RequestDto;
import com.everis.latam.ACLFinanzasProveedoresFlama.dto.SolicitudDto;

@RestController
public class ConsumeFinanzaWebService {
	private HttpHeaders headers = new HttpHeaders();
	@Autowired
	RestTemplate restTemplate;
	
	/*
	 * int idProveedor;
	String nombreArea;
	String responsable;
	String email;
	String ceco;
	int idAprovador;
	 * */
 
	@RequestMapping(value = URLs.inputURL, method = RequestMethod.POST)
	public ResponseEntity<Object> finanzasRequest(@RequestBody Request req, Solicitud solic) throws BadRequestException{
		SolicitudDto solicitudDto = new SolicitudDto(
				solic.getIdProveedor(),
				solic.getNombreArea(),
				solic.getResponsable(),
				solic.getEmail(),
				solic.getCeco(),
				solic.getIdAprovador());		
		RequestDto reqDto = new RequestDto(solicitudDto);
		try {
			
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<RequestDto> entity = new HttpEntity<>(reqDto,headers);
				
			Response res = restTemplate.exchange(
					URLs.apiURL, HttpMethod.POST, entity, Response.class).getBody();
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			throw new BadRequestException(ExceptionPost.error);
		}
		
		
	
		
		
		
	}
}
