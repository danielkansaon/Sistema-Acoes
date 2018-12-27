package com.javaee.sistema_acoes.email;

public class EmailSender {

	public static void send(String toEmail, String subject, String body) {
		final String fromEmail = "******";
		final String password = "*********";
		
		System.out.println("Inicializando envio do email");
		
		EmailConfig config = new EmailConfig();		
		config.sendEmail(fromEmail, password, toEmail, subject, body);
	}
}