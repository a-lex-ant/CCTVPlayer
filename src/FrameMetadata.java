import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FrameMetadata extends JFrame {

private JPanel content;

//epc.mediaPlayer().media().info().statistics().


public FrameMetadata() {
setTitle("Statistiche");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
content = new JPanel();
content.setBorder(new EmptyBorder(5, 5, 5, 5));
content.setLayout(new BorderLayout(0, 0));
setContentPane(content);

JPanel rootPanel = new JPanel();
content.add(rootPanel, BorderLayout.CENTER);
rootPanel.setLayout(new BorderLayout(0, 0));

JPanel panel = new JPanel();
panel.setBorder(new TitledBorder(null, "Statistiche sulla connessione", TitledBorder.LEADING, TitledBorder.TOP, null, null));
rootPanel.add(panel, BorderLayout.CENTER);

JPanel panel_1 = new JPanel();
panel_1.setBorder(new TitledBorder(null, "Informazioni sul media", TitledBorder.LEADING, TitledBorder.TOP, null, null));
content.add(panel_1, BorderLayout.SOUTH);
GridBagLayout gbl_panel_1 = new GridBagLayout();
gbl_panel_1.columnWidths = new int[] {2, 0, 0, 0};
gbl_panel_1.rowHeights = new int[] {2, 0, 0, 0};
gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
panel_1.setLayout(gbl_panel_1);

JLabel lblNewLabel = new JLabel("Audio Buffers Lost");
GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
gbc_lblNewLabel.gridx = 0;
gbc_lblNewLabel.gridy = 0;
panel_1.add(lblNewLabel, gbc_lblNewLabel);

JLabel lblAaa = new JLabel("---");
GridBagConstraints gbc_lblAaa = new GridBagConstraints();
gbc_lblAaa.insets = new Insets(0, 0, 5, 0);
gbc_lblAaa.gridx = 2;
gbc_lblAaa.gridy = 0;
panel_1.add(lblAaa, gbc_lblAaa);

JLabel lblPicturesLost = new JLabel("Pictures Lost");
GridBagConstraints gbc_lblPicturesLost = new GridBagConstraints();
gbc_lblPicturesLost.insets = new Insets(0, 0, 5, 5);
gbc_lblPicturesLost.gridx = 0;
gbc_lblPicturesLost.gridy = 1;
panel_1.add(lblPicturesLost, gbc_lblPicturesLost);

JLabel lblAaa_1 = new JLabel("---");
GridBagConstraints gbc_lblAaa_1 = new GridBagConstraints();
gbc_lblAaa_1.insets = new Insets(0, 0, 5, 0);
gbc_lblAaa_1.gridx = 2;
gbc_lblAaa_1.gridy = 1;
panel_1.add(lblAaa_1, gbc_lblAaa_1);

JLabel lblDemuxCorrupted = new JLabel("Demux Corrupted");
GridBagConstraints gbc_lblDemuxCorrupted = new GridBagConstraints();
gbc_lblDemuxCorrupted.insets = new Insets(0, 0, 0, 5);
gbc_lblDemuxCorrupted.gridx = 0;
gbc_lblDemuxCorrupted.gridy = 2;
panel_1.add(lblDemuxCorrupted, gbc_lblDemuxCorrupted);

JLabel label = new JLabel("---");
GridBagConstraints gbc_label = new GridBagConstraints();
gbc_label.gridx = 2;
gbc_label.gridy = 2;
panel_1.add(label, gbc_label);
}

}
