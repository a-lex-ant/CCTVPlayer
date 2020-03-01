import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * The Credits frame.
 */
public class CreditsFrame extends javax.swing.JFrame
	{
	
	/**
	 * Instantiates a new Credits frame.
	 */
	public CreditsFrame()
		{
		initComponents();
		}

	/**
	 * Initializes components.
	 * Uses HTML.
	 */
	private void initComponents()
		{
		Color arancio = new Color(224, 98, 52);

		LinkListener linkListener = new LinkListener();

		JPanel      contenitore                = new JPanel();
		JPanel      panelAbout                = new JPanel();
		ScrollPane  scrollPane1            = new ScrollPane();
		JScrollPane jScrollPane1           = new JScrollPane();
		JEditorPane editorPaneAbout        = new JEditorPane();
		JPanel      panelExtLib                = new JPanel();
		ScrollPane  scrollPane4            = new ScrollPane();
		JScrollPane jScrollPane4           = new JScrollPane();
		JEditorPane editorPaneExtLibraries = new JEditorPane();
		JPanel      panelIcons                = new JPanel();
		Label       iconCreditsLabel       = new Label();
		ScrollPane scrollPane2    = new ScrollPane();
		JScrollPane jScrollPane2          = new JScrollPane();
		JEditorPane editorPaneIconsCredit = new JEditorPane();
		JPanel      spacerPanel               = new JPanel();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		contenitore.setLayout(new GridLayout(3, 1));

		TitledBorder borderAbout = BorderFactory.createTitledBorder("About");
		TitledBorder borderExtLib =  BorderFactory.createTitledBorder("External Library Credits");
		TitledBorder borderIcon = BorderFactory.createTitledBorder("Icon Credits");
		borderAbout.setTitleColor(arancio);
		borderExtLib.setTitleColor(arancio);
		borderIcon.setTitleColor(arancio);

		panelAbout.setBorder(javax.swing.BorderFactory.createCompoundBorder(borderAbout, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panelAbout.setLayout(new BorderLayout());


		editorPaneAbout.setContentType("text/html");
		editorPaneAbout.setText("<html>\n  <head>\n<style>\n</style>\n  </head>\n  <body>\n<p style=\"text-align: center;\">Developed " +
		                        "by Anna A. Antonini (<a href=\"mailto:a.antonini011@studenti.unibs.it\">a" +
		                        ".antonini011@studenti.unibs.it</a>)</p>\n<p style=\"text-align: center;\">Original project available " +
		                        "freely on my <a href=\"https://github.com/a-lex-ant\">GitHub profile</a>.</p>\n<p style=\"text-align:" +
		                        " center;\">&nbsp;</p>\n<p style=\"text-align: center;\">This program is free software: you can " +
		                        "redistribute it and/or modify it under the terms of</p>\n<p style=\"text-align: center;\">the " +
		                        "<strong>GNU General Public License</strong> as published by the Free Software Foundation, " +
		                        "either</p>\n<p style=\"text-align: center;\">version 3 of the License, or (at your option) any later " +
		                        "version. This program is distributed</p>\n<p style=\"text-align: center;\">in the hope that it will " +
		                        "be useful, but WITHOUT ANY WARRANTY; without even the</p>\n<p style=\"text-align: center;\">implied " +
		                        "warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.</p>\n<p style=\"text-align: center;" +
		                        "\">See the GNU General Public License for more details.</p>\n<p style=\"text-align: center;\">You " +
		                        "should have received a copy of the GNU General Public License along with this</p>\n<p " +
		                        "style=\"text-align: center;\">program. If not, see &lt;https://www.gnu.org/licenses/&gt;" +
		                        ".</p>\n<p>&nbsp;</p>\n  </body>\n</html>\n");
		editorPaneAbout.setEditable(false);
		editorPaneAbout.addHyperlinkListener(linkListener);
		jScrollPane1.setViewportView(editorPaneAbout);

		scrollPane1.add(jScrollPane1);

		panelAbout.add(scrollPane1, BorderLayout.CENTER);

		contenitore.add(panelAbout);

		panelExtLib.setBorder(javax.swing.BorderFactory.createCompoundBorder(borderExtLib, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panelExtLib.setLayout(new BorderLayout());


		editorPaneExtLibraries.setContentType("text/html");
		editorPaneExtLibraries.setText("<html>\n  <head>\n<style>\n</style>\n  </head>\n  <body>\n<p style=\"text-align: center;\">This " +
		                               "program wouldn't have been possible without this awesome libraries:</p>\n<p style=\"text-align: " +
		                               "center;\"><strong>Vlcj<br /></strong><em><span class=\"text-gray-dark mr-2\">Java framework for the " +
		                               "vlc media player.</span></em></p>\n<p style=\"text-align: center;\"><a href=\"http://www" +
		                               ".capricasoftware.co.uk/projects/vlcj\"><span class=\"text-gray-dark mr-2\">Official page on the " +
		                               "Caprica Software website</span></a></p>\n<p style=\"text-align: center;\"><a href=\"https://github" +
		                               ".com/caprica/vlcj\"><span class=\"text-gray-dark mr-2\">Official GitHub Repository</span></a></p>\n<p" +
		                               " style=\"text-align: center;\"><strong><span class=\"text-gray-dark mr-2\">JFreeChart<br " +
		                               "/></span></strong><em><span class=\"text-gray-dark mr-2\">A 2D chart library for Java application" +
		                               ".</span></em></p>\n<p style=\"text-align: center;\"><a href=\"A%202D chart library for Java " +
		                               "applications \"><span class=\"text-gray-dark mr-2\">Official web page</span></a></p>\n<p " +
		                               "style=\"text-align: center;\"><a href=\"https://github.com/jfree/jfreechart\"><span " +
		                               "class=\"text-gray-dark mr-2\">Official GitHub Repository</span></a></p>\n<p style=\"text-align: " +
		                               "center;\"><strong><span class=\"text-gray-dark mr-2\">FlatLaf<br /></span></strong><em><span " +
		                               "class=\"text-gray-dark mr-2\">Flat Look and Feel </span></em></p>\n<p style=\"text-align: center;" +
		                               "\"><a href=\"https://www.formdev.com/flatlaf/\">Official Web Page</a></p>\n<p style=\"text-align: " +
		                               "center;\"><a href=\"https://github.com/JFormDesigner/FlatLaf\">Official GitHub Repository</a></p>\n<p" +
		                               " style=\"text-align: center;\">(<em>Atom One Dark Contrast Theme</em> by <a href=\"https://github" +
		                               ".com/mallowigi/\">Elior Boukhobza (mallowigi)</a>)</p>\n<p style=\"text-align: center;\">&nbsp;" +
		                               "</p>\n<p style=\"text-align: center;\">...And the <a href=\"https://stackoverflow" +
		                               ".com/\">StackOverflow</a>'s community :)</p>\n  </body>\n</html>\n");
		editorPaneExtLibraries.setEditable(false);
		editorPaneExtLibraries.addHyperlinkListener(linkListener);

		jScrollPane4.setViewportView(editorPaneExtLibraries);

		scrollPane4.add(jScrollPane4);

		panelExtLib.add(scrollPane4, BorderLayout.CENTER);

		contenitore.add(panelExtLib);

		panelIcons.setBorder(javax.swing.BorderFactory.createCompoundBorder(borderIcon, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		panelIcons.setLayout(new BorderLayout());

		panelIcons.add(iconCreditsLabel, BorderLayout.NORTH);

		editorPaneIconsCredit.setContentType("text/html");
		editorPaneIconsCredit.setText("<html>\n  <head>\n<style>\n</style>\n  </head>\n  <body>\n    <p style=\"text-align: center;\">Nearly" +
		                              " all icons are from the <a href=\"https://feathericons.com/\">Feather Icons project</a> by <a " +
		                              "href=\"https://twitter.com/colebemis\">Cole Bemis</a>.</p>\n<p style=\"text-align: center;\"><a " +
		                              "href=\"https://icons8.com/icons/set/italy\" target=\"_blank\" rel=\"noopener\">Italy icon</a> and <a " +
		                              "href=\"https://icons8.com/icons/set/usa\" target=\"_blank\" rel=\"noopener\">USA icon</a> by <a " +
		                              "href=\"https://icons8.com\" target=\"_blank\" rel=\"noopener\">Icons8</a>.</p>\n<p>&nbsp;</p>\n  " +
		                              "</body>\n</html>\n");
		editorPaneIconsCredit.setMaximumSize(new Dimension(91, 30));
		editorPaneIconsCredit.setMinimumSize(new Dimension(91, 30));
		editorPaneIconsCredit.setEditable(false);
		editorPaneIconsCredit.addHyperlinkListener(linkListener);

		jScrollPane2.setViewportView(editorPaneIconsCredit);

		scrollPane2.add(jScrollPane2);

		panelIcons.add(scrollPane2, BorderLayout.CENTER);

		javax.swing.GroupLayout spacerPanelLayout = new javax.swing.GroupLayout(spacerPanel);
		spacerPanel.setLayout(spacerPanelLayout);
		spacerPanelLayout.setHorizontalGroup(spacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                              .addGap(0, 524, Short.MAX_VALUE));
		spacerPanelLayout.setVerticalGroup(spacerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                            .addGap(0, 100, Short.MAX_VALUE));

		panelIcons.add(spacerPanel, BorderLayout.PAGE_END);

		contenitore.add(panelIcons);

		getContentPane().add(contenitore, BorderLayout.CENTER);

		pack();
		}

	}
