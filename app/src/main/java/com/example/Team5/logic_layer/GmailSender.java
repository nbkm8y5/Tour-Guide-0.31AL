package com.example.Team5.logic_layer;

/**
 * Created by SpeedGrapher on 7/17/2016.
 * Don't touch this class.
 */

import android.util.Log;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Properties;

/**
 *
 */
public class GmailSender extends javax.mail.Authenticator {
    private String mailhost = "smtp.gmail.com";
    private String user = "choripandeveloperteam@gmail.com";
    private String password = "cen4010team5";
    private Session session;

    static {
        Security.addProvider(new JSSEProvider());
    }

    /**
     *
     */
    public GmailSender() {
        //this.user = user;
        //this.password = password;
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        session = Session.getDefaultInstance(props, this);
    }

    /**
     *
     * @return
     */
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
    }

    /**
     *
     * @param subject
     * @param body
     * @param sender
     * @param recipients
     * @throws Exception
     */
    public synchronized void sendMail(String subject, String body, String sender, String recipients) throws Exception {
        try {
            MimeMessage message = new MimeMessage(session);
            DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));
            message.setSender(new InternetAddress(sender));
            message.setSubject(subject);
            message.setDataHandler(handler);

            if (recipients.indexOf(',') > 0)
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            else
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
            System.out.println("RECIPIENT: " + recipients);
            Transport.send(message);
        } catch (Exception e) {
            Log.e("Transport", e.getMessage(), e);
        }
    }

    /**
     *
     */
    public class ByteArrayDataSource implements DataSource {
        private byte[] data;
        private String type;

        /**
         *
         * @param data
         * @param type
         */
        public ByteArrayDataSource(byte[] data, String type) {
            super();
            this.data = data;
            this.type = type;
        }

        /**
         *
         * @param data
         */
        public ByteArrayDataSource(byte[] data) {
            super();
            this.data = data;
        }

        /**
         *
         * @param type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         */
        public String getContentType() {
            if (type == null)
                return "application/octet-stream";
            else
                return type;
        }

        /**
         *
         * @return
         * @throws IOException
         */
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(data);
        }

        /**
         *
         * @return
         */
        public String getName() {
            return "ByteArrayDataSource";
        }

        /**
         *
         * @return
         * @throws IOException
         */
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("Not Supported");
        }
    }
}
