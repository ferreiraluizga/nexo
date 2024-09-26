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
    public static void formatarTelefone(JFormattedTextField txtTelefone) {
        try {
            MaskFormatter mask = new MaskFormatter("(##) #####-####");
            mask.setPlaceholderCharacter('_');
            mask.install(txtTelefone);
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
    
    // método para definir manhã, tarde e noite
    public static String getSaudacao() {
        LocalTime hora = LocalTime.now();
        if (hora.isBefore(LocalTime.NOON)) {
            return "Bom dia :)";
        } else if (hora.isBefore(LocalTime.of(18, 0))) {
            return "Boa tarde :)";
        } else {
            return "Boa noite :)";
        }
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
    
    public static void setLoadImage(JLabel lblImg, ImageIcon img) {
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

}
