package resources.utilitaries;

import java.awt.*;
import java.io.File;
import java.text.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import javax.swing.text.*;

public class Utilitaries {

    // método para formatar campo de telefone
    public static void formatarCampo(JFormattedTextField textField, String pattern) {
        try {
            MaskFormatter mask = new MaskFormatter(pattern);
            mask.setPlaceholderCharacter('_');
            mask.install(textField);
        } catch (ParseException excp) {
            System.out.println(excp);
        }
    }

    // método para limpar campos de um JPanel
    public static void limparCampos(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }

    // método para buscar data local
    public static String setDataAtual() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataAtual.format(formatter);
    }

    // método para buscar hora local
    public static String getHoraAtual() {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }

    // método para definir a imagem da tela de login
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

    public static void setAltImage(JLabel lblImg, File f) {
        try {
            ImageIcon revivalLogo = new ImageIcon(f.getAbsolutePath());
            Image scaledImage = revivalLogo.getImage().getScaledInstance(
                    lblImg.getWidth(),
                    lblImg.getHeight(),
                    Image.SCALE_SMOOTH);
            lblImg.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setImage(JLabel lblImg, ImageIcon img) {
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

}
