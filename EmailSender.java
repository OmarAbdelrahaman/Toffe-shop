import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public OTPGenerator otpGenerator =new OTPGenerator() ;
    protected String otp = otpGenerator.generateOTP();

    protected String getCodeOTP (){
        return otp ;
    }

    public String sendOTP(String toEmail) throws Exception{
        // Generate a random OTP
        //String otp = generateOTP();
        String from = "bodyabokamar100@gmail.com";

        String password = "fxmjyiuwddnjjzps\n" ;

        String host = "smtp.gmail.com";


        // Send the OTP to the user's email
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");



        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);

            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("OTP");
            message.setText("محل الحلويات دا 100 100 : " + otp);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }
        return otp;
    }
}