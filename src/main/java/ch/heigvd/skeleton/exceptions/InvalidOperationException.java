/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.heigvd.skeleton.exceptions;

/**
 *
 * @author komanda.phanzu
 */
public class InvalidOperationException extends Exception{
	
	public enum OperationEnum{
		Undefined, Create, Read, Update, Delete, Unknown;
	}
	OperationEnum operation=OperationEnum.Undefined;
	public InvalidOperationException() {
	}
	
	public InvalidOperationException(OperationEnum operation) {
		this.operation=operation;
	}

	public InvalidOperationException(OperationEnum operation, String message) {
		super(message);
		this.operation=operation;
	}

	public InvalidOperationException(OperationEnum operation, String message, Throwable cause) {
		super(message, cause);
		this.operation=operation;
	}

	public InvalidOperationException(OperationEnum operation, Throwable cause) {
		super(cause);
		this.operation=operation;
	}

	public InvalidOperationException(OperationEnum operation, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.operation=operation;
	}

	public OperationEnum getOperation() {
		return operation;
	}
	
	
}
