package resources.utilitaries;

import dao.Connect;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ferreiraluizga
 */
public class ImageDatabase {
    
    public static void saveImage(int cod_func, ImageIcon img_func) {
        String sql = "INSERT INTO img_func (Cod_Func, Img_Func) VALUES (?, ?)";
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            BufferedImage bufferedImage = new BufferedImage(
                img_func.getIconWidth(),
                img_func.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
            );
            bufferedImage.getGraphics().drawImage(img_func.getImage(), 0, 0, null);
            ImageIO.write(bufferedImage, "jpg", baos);

            byte[] imageBytes = baos.toByteArray();

            try (Connection conn = Connect.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, cod_func);
                pstmt.setBytes(2, imageBytes);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ImageIcon selectImage(int cod_func) {
        String sql = "SELECT Img_Func FROM img_func WHERE Cod_Func = ?";
        ImageIcon imageIcon = null;

        try (Connection conn = Connect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cod_func);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("Img_Func");
                if (imageBytes != null) {
                    // Converte os bytes para um BufferedImage
                    ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                    BufferedImage bufferedImage = ImageIO.read(bais);
                    // Cria o ImageIcon a partir do BufferedImage
                    imageIcon = new ImageIcon(bufferedImage);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return imageIcon;
    }
    
    public static void updateImage(int cod_func, ImageIcon img_func) {
        String sql = "UPDATE img_func SET Img_Func = ? WHERE Cod_Func = ?";
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            BufferedImage bufferedImage = new BufferedImage(
                img_func.getIconWidth(),
                img_func.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
            );
            bufferedImage.getGraphics().drawImage(img_func.getImage(), 0, 0, null);
            ImageIO.write(bufferedImage, "jpg", baos);

            byte[] imageBytes = baos.toByteArray();

            try (Connection conn = Connect.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, cod_func);
                pstmt.setBytes(2, imageBytes);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
