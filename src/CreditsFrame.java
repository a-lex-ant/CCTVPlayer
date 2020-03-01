import javax.swing.*;

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

		LinkListener linkListener = new LinkListener();

		JPanel         jPanel4  = new JPanel();
		JPanel jPanel1 = new JPanel();
		java.awt.Label aboutLbl = new java.awt.Label();
		java.awt.ScrollPane scrollPane1 = new java.awt.ScrollPane();
		JScrollPane jScrollPane1    = new JScrollPane();
		JEditorPane editorPaneAbout = new JEditorPane();
		JPanel      jPanel3         = new JPanel();
		java.awt.Label extLibLbl = new java.awt.Label();
		java.awt.ScrollPane scrollPane4 = new java.awt.ScrollPane();
		JScrollPane    jScrollPane4        = new JScrollPane();
		JEditorPane editorPaneExtLibraries = new JEditorPane();
		JPanel      jPanel2                = new JPanel();
		java.awt.Label iconCreditsLabel    = new java.awt.Label();
		java.awt.ScrollPane scrollPane2    = new java.awt.ScrollPane();
		JScrollPane jScrollPane2          = new JScrollPane();
		JEditorPane editorPaneIconsCredit = new JEditorPane();
		JPanel      jPanel5               = new JPanel();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		jPanel4.setLayout(new java.awt.GridLayout(3, 1));

		jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		jPanel1.setLayout(new java.awt.BorderLayout());

		aboutLbl.setAlignment(java.awt.Label.CENTER);

		aboutLbl.setText("About");
		aboutLbl.setForeground(new java.awt.Color(224, 98, 52));
		jPanel1.add(aboutLbl, java.awt.BorderLayout.NORTH);

		editorPaneAbout.setContentType("text/html");
		editorPaneAbout.setText("<html>\n  <head>\n<style>\n</style>\n  </head>\n  <body>\n<p style=\"text-align: center;\">Developed " +
		                        "with &hearts; by Anna A. Antonini (<a href=\"mailto:a.antonini011@studenti.unibs.it\">a" +
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

		jPanel1.add(scrollPane1, java.awt.BorderLayout.CENTER);

		jPanel4.add(jPanel1);

		jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		jPanel3.setLayout(new java.awt.BorderLayout());

		extLibLbl.setAlignment(java.awt.Label.CENTER);
		extLibLbl.setText("External Library Credits");
		extLibLbl.setForeground(new java.awt.Color(224, 98, 52));
		jPanel3.add(extLibLbl, java.awt.BorderLayout.NORTH);

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

		jPanel3.add(scrollPane4, java.awt.BorderLayout.CENTER);

		jPanel4.add(jPanel3);

		jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		jPanel2.setLayout(new java.awt.BorderLayout());

		iconCreditsLabel.setAlignment(java.awt.Label.CENTER);
		iconCreditsLabel.setText("Icon Credits");
		iconCreditsLabel.setForeground(new java.awt.Color(224, 98, 52));
		jPanel2.add(iconCreditsLabel, java.awt.BorderLayout.NORTH);

		editorPaneIconsCredit.setContentType("text/html");
		editorPaneIconsCredit.setText("<html>\n  <head>\n<style>\n</style>\n  </head>\n  <body>\n    <p style=\"text-align: center;\">Nearly" +
		                              " all icons are from the <a href=\"https://feathericons.com/\">Feather Icons project</a> by <a " +
		                              "href=\"https://twitter.com/colebemis\">Cole Bemis</a>.</p>\n<p style=\"text-align: center;\"><a " +
		                              "href=\"https://icons8.com/icons/set/italy\" target=\"_blank\" rel=\"noopener\">Italy icon</a> and <a " +
		                              "href=\"https://icons8.com/icons/set/usa\" target=\"_blank\" rel=\"noopener\">USA icon</a> by <a " +
		                              "href=\"https://icons8.com\" target=\"_blank\" rel=\"noopener\">Icons8</a>.</p>\n<p>&nbsp;</p>\n  " +
		                              "</body>\n</html>\n");
		editorPaneIconsCredit.setMaximumSize(new java.awt.Dimension(91, 30));
		editorPaneIconsCredit.setMinimumSize(new java.awt.Dimension(91, 30));
		editorPaneIconsCredit.setEditable(false);
		editorPaneIconsCredit.addHyperlinkListener(linkListener);

		jScrollPane2.setViewportView(editorPaneIconsCredit);

		scrollPane2.add(jScrollPane2);

		jPanel2.add(scrollPane2, java.awt.BorderLayout.CENTER);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                              .addGap(0, 524, Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                                            .addGap(0, 100, Short.MAX_VALUE));

		jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

		jPanel4.add(jPanel2);

		getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

		pack();
		}

	}
