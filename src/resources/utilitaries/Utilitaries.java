package resources.utilitaries;

import dao.Connect;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.text.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.view.JasperViewer;

public class Utilitaries {

    public static void formatarCampo(JFormattedTextField textField, String pattern) {
        try {
            MaskFormatter mask = new MaskFormatter(pattern);
            mask.setPlaceholderCharacter('_');
            mask.install(textField);
        } catch (ParseException excp) {
            System.out.println(excp);
        }
    }

    public static void limparCampos(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }

    public static String setDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataAtual.format(formatter);
    }

    public static String getHoraAtual() {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }

    public static void setImage(JLabel lblImg, String img) {
        try {
            ImageIcon image = new ImageIcon(Utilitaries.class.getResource("/resources/img/" + img));
            Image scaledImage = image.getImage().getScaledInstance(
                    lblImg.getWidth(),
                    lblImg.getHeight(),
                    Image.SCALE_SMOOTH);
            lblImg.setIcon(new ImageIcon(scaledImage));
            lblImg.setHorizontalAlignment(JLabel.CENTER);
            lblImg.setVerticalAlignment(JLabel.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFileImage(JLabel lblImg, File f) {
        try {
            ImageIcon image = new ImageIcon(f.getAbsolutePath());
            Image scaledImage = image.getImage().getScaledInstance(
                    lblImg.getWidth(),
                    lblImg.getHeight(),
                    Image.SCALE_SMOOTH);
            lblImg.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setLabelImageIcon(JLabel lblImg, ImageIcon img) {
        try {
            Image scaledImage = img.getImage().getScaledInstance(
                    lblImg.getWidth(),
                    lblImg.getHeight(),
                    Image.SCALE_SMOOTH);
            lblImg.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LocalDate convertStringToDate(String dateInString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateInString, formatter);
        return date;
    }

    public static String convertDateToString(LocalDate dateInDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateInDate.format(formatter);
    }

    public static String encryptString(String input) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] messageDigest = m.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1, messageDigest);
        return String.format("%032x", bigInt);
    }
    
    public static void saveImageFromJLabel(JLabel label, String destinationPath) {
        ImageIcon icon = (ImageIcon) label.getIcon();
        if (icon != null) {
            BufferedImage image = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB
            );
            image.getGraphics().drawImage(icon.getImage(), 0, 0, null);
            File destinationFile = new File(destinationPath);
            try {
                ImageIO.write(image, "png", destinationFile);
                System.out.println("Imagem salva com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void imprimirRelatorio(Map<String, Object> parameters, String report) throws JRException, SQLException {
        try (Connection conn = Connect.getConnection()) {
            String jrxmlFile = "src/resources/reports/" + report;
            String jasperFile = JasperCompileManager.compileReportToFile(jrxmlFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
            //JasperExportManager.exportReportToPdfFile(jasperPrint, "src/connect/relatorio.pdf");
        }
    }
    
    public static void updateBody(JPanel body,Component com, boolean isSmallPanel) {
        body.removeAll();
        if (isSmallPanel) {
            JPanel wrapper = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            wrapper.add(com, gbc);
            body.add(wrapper, BorderLayout.CENTER);
        } else {
            body.add(com, BorderLayout.CENTER);
        }
        body.invalidate();
        body.revalidate();
        body.repaint();
    }

}
