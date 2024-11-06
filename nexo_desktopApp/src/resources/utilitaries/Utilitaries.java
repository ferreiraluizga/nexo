package resources.utilitaries;

import dao.Connect;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import java.sql.*;
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

    // método para apresentar imagens salvas no banco de dados
    public static ImageIcon getImageFromDatabase(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ImageIcon imageIcon = null;

        try {
            conn = Connect.getConnection();
            String sql = "SELECT Img_Func FROM img_func WHERE Cod_Func = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("Img_Func");
                ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
                BufferedImage bufferedImage = ImageIO.read(bis);
                imageIcon = new ImageIcon(bufferedImage);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return imageIcon;
    }
    
    // método para salvar imagens no banco de dados
    public static void saveImageIconToDatabase(int id, ImageIcon imageIcon) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ByteArrayOutputStream baos = null;

        try {
            BufferedImage bufferedImage = new BufferedImage(
                imageIcon.getIconWidth(),
                imageIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
            );
            bufferedImage.getGraphics().drawImage(imageIcon.getImage(), 0, 0, null);
            baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();

            conn = Connect.getConnection();

            String sql = "UPDATE img_func SET Img_Func = ? WHERE Cod_Func = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setBytes(1, imageBytes);
            stmt.setInt(2, id);

            stmt.executeUpdate();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) baos.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void imprimirRelatorio(Map<String, Object> parameters, String report, boolean salvarPdf, int id_compra) throws JRException, SQLException {
        try (Connection conn = Connect.getConnection()) {
            String jrxmlFile = "src/resources/reports/" + report;
            String jasperFile = JasperCompileManager.compileReportToFile(jrxmlFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, parameters, conn);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
            if (salvarPdf) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, "src/resources/comprovantes/compra_" + id_compra + ".pdf");
            }
        }
    }

    public static void abrirComprovanteCompra(int id_compra) {
        if (Desktop.isDesktopSupported()) {
            try {
                File arquivoPDF = new File("src/resources/comprovantes/compra_" + id_compra + ".pdf");
                if (arquivoPDF.exists()) {
                    Desktop.getDesktop().open(arquivoPDF);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateBody(JPanel body, Component com, boolean isSmallPanel) {
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

    public static float formatarPreco(String preco) {
        preco = preco.replace(",", ".");
        float precoFloat = Float.parseFloat(preco);
        return Math.round(precoFloat * 100.0f) / 100.0f;
    }

    public static String formatarPrecoParaTexto(float preco) {
        return String.format("%.2f", preco).replace(".", ",");
    }

}
