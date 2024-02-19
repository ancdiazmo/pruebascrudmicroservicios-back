package com.pruebascrudmicroservicios.exception;

public class SqlException extends Exception {

	private static final long serialVersionUID = 1L;

	public SqlException (String mensaje) {
		super (mensaje);
	}
}
