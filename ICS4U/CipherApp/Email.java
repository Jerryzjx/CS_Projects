// import necessary libraries
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.mail.internet.MimeMultipart;

//Learned from https://netcorecloud.com/tutorials/send-email-in-java-using-gmail-smtp/

public class Email {
    /**
     sendEmail
     Purpose: Send the encrypted file or decrypted file to the user's email
     @Param: none
     @Return: void
     */
    public static void sendEmail() {
        
        String userFile = Main.userFile;
        // User's Email ID
        String to = Main.userEmail;

        // Sent from my email from yeah.net
        String from = "jerry_zjx@yeah.net";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server (yeah.net in this case)
        properties.put("mail.smtp.host", "smtp.yeah.net");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // and username and password since my email account requires password authentication
                return new PasswordAuthentication("jerry_zjx@yeah.net", "DUCJLWTEVIXAQDYW");

            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        try {
            // Create the MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set the email address of the sender
            message.setFrom(new InternetAddress(from));

            // Set the recipient's email
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set the subject of the email
            message.setSubject("Ciphered File");
            // create the body message part of the email
            BodyPart messageBody = new MimeBodyPart();
            messageBody.setText("Dear user: \nHello! Here is your encrypted / decrypted file!");
            // set the attachment of the email
            MimeBodyPart attachment = new MimeBodyPart();
            attachment.attachFile(new File(userFile));

            // add all previous BodyParts together to a multipart
            Multipart emailParts = new MimeMultipart();
            emailParts.addBodyPart(messageBody);
            emailParts.addBodyPart(attachment);
            
            // set the content of the email
            message.setContent(emailParts);

            System.out.println("Sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent file successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            // let the user know something wrong happened when sending email
            System.out.println("Sorry, something wrong happened when sending the email");
        } catch (IOException ex){
            System.out.println("Sorry, something wrong happened when sending the email");
        }

    }

}
