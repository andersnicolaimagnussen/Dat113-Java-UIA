import javax.swing.*;


public final class Spill {
    // Constructer
    public Spill() {
        Spill();
        String name = JOptionPane.showInputDialog("Tast inn navn");
        JOptionPane.showMessageDialog(null, "Welcome " + name);
        StartGame();
    }
    public void StartGame() {
        int randomTall = (int) (Math.random() * 100);
        boolean svarSjekk = true;
        int count = 0;
        while (svarSjekk) {
            try {
                int brukerTall = Integer.parseInt(JOptionPane.showInputDialog("Tast inn et tall"));
                count++;
                if (brukerTall == randomTall) {
                    JOptionPane.showMessageDialog(null, "Du tastet inn riktig tall");
                    Result();
                    svarSjekk = false;
                } else if (brukerTall > randomTall) {
                    JOptionPane.showMessageDialog(null, "Feil svar Tallet var lavere");
                } else if (brukerTall < randomTall) {
                    JOptionPane.showMessageDialog(null, "Feil svar Tallet var høyere");
                }
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "du må taste inn riktig tall ");
            }
        }
    }
    public static void Result() {
        Object[] options = {"Start på nytt", "Avslutt"};

        int svar = JOptionPane.showOptionDialog(null, "Klikk Start på nytt for å starte på nytt",
                "Hva vil du gjøre nå?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);

        if (svar == JOptionPane.YES_OPTION)
        {
            Spill spill = new Spill();
            spill.StartGame();


        } else if (svar == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null,"Takk for spillet, på gjensyn");
            System.exit(0);
        }
    }

    public static void Spill()
    {
        //Ber brukeren om å taste inn et tall - Del oppgave 1.
        int tall = Integer.parseInt(JOptionPane.showInputDialog("Tast inn tall"));
        JOptionPane.showMessageDialog( null, "Du tastet inn " + tall, "This is the title", JOptionPane.INFORMATION_MESSAGE);

        // Del oppgave 2.
        int randomTall = (int) (Math.random() * 100);
    }


}


