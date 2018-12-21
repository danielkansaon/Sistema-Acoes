package com.javaee.sistema_acoes.emailsender;

public class EmailSender {

	public static void send(String toEmail, String subject, String body) {
		final String fromEmail = "kansaonp@gmail.com";
		final String password = "*********";
		
		System.out.println("Inicializando envio do email");
		
		EmailConfig config = new EmailConfig();		
		config.sendEmail(fromEmail, password, toEmail, subject, body);
	}

}