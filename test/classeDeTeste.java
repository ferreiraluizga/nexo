import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class classeDeTeste {

    public static void main(String[] args) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateInString = "07/12/2013";
            LocalDate date = LocalDate.parse(dateInString, formatter);
            
            // Imprimindo a data analisada
            System.out.println("Data analisada: " + date);
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao analisar a data: " + e.getMessage());
        }
    }
}
