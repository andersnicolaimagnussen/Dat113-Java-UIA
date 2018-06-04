import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Assignment02Runner {
    public static void main(String[] args) {

        Object[] possibleValues = { "Euro", "Yen", };
        int userOption = JOptionPane.showOptionDialog(null, "Hva vil du konvertere?", "Velg",
                JOptionPane.YES_OPTION,
                JOptionPane.NO_OPTION,
                null,possibleValues, possibleValues[0]);
        try
        {
            if (userOption == JOptionPane.YES_OPTION)
            {
                double antallKroner = Double.parseDouble(JOptionPane.showInputDialog("Tast inn kroner"));
                JOptionPane.showMessageDialog(null,"Du tastet inn " + antallKroner);
                Assignment02Functions euroConverter = new Assignment02Functions();
                double Euroresult =  euroConverter.kronerTilEuro(antallKroner);
                JOptionPane.showMessageDialog(null,"I euro blir det " + Euroresult);
            }
            else if(userOption == JOptionPane.NO_OPTION)
            {
                double antallKroner = Double.parseDouble(JOptionPane.showInputDialog("Tast inn kroner"));
                JOptionPane.showMessageDialog(null,"Du tastet inn " + antallKroner);
                Assignment02Functions yencConverter = new Assignment02Functions();
                double yenResult = yencConverter.kronerTilYen(antallKroner);
                JOptionPane.showMessageDialog(null,"Kroner i Yen " + yenResult);
            }

        }
        catch (NumberFormatException exeption)
        {
            JOptionPane.showMessageDialog(null,"Du må taste inn et gyldig tall!" + "Error meldingen er \n" + exeption.getLocalizedMessage());
        }



    }


}
