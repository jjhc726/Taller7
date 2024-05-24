package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

public class Top10Dialog extends JDialog {

    public Top10Dialog(JFrame parent, Top10 top10) {
        super(parent, "Top 10 Scores", true);
        setLayout(new BorderLayout());
        setSize(300, 400);
        setLocationRelativeTo(parent);

        List<RegistroTop10> registros = new ArrayList<>(top10.darRegistros());
        JList<RegistroTop10> scoreList = new JList<>(registros.toArray(new RegistroTop10[0]));
        scoreList.setCellRenderer(new Top10CellRenderer());

        add(new JScrollPane(scoreList), BorderLayout.CENTER);
    }

    private static class Top10CellRenderer extends JLabel implements ListCellRenderer<RegistroTop10> {
        @Override
        public Component getListCellRendererComponent(JList<? extends RegistroTop10> list, RegistroTop10 value, int index, boolean isSelected, boolean cellHasFocus) {
            setText((index + 1) + ". " + value.darNombre() + ": " + value.darPuntos());
            setOpaque(true);
            setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
            setForeground(isSelected ? Color.BLACK : Color.BLACK);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            return this;
        }
    }
}
