public class CreditsFrame extends javax.swing.JFrame {


// Variables declaration - do not modify
private java.awt.Label About;
private java.awt.Label About1;
private javax.swing.JEditorPane jEditorPane1;
private javax.swing.JEditorPane jEditorPane2;
private javax.swing.JEditorPane jEditorPane4;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JPanel jPanel3;
private javax.swing.JPanel jPanel4;
private javax.swing.JPanel jPanel5;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JScrollPane jScrollPane2;
private javax.swing.JScrollPane jScrollPane4;
private java.awt.Label label2;
private java.awt.ScrollPane scrollPane1;
private java.awt.ScrollPane scrollPane2;
private java.awt.ScrollPane scrollPane4;
// End of variables declaration

public CreditsFrame() {
initComponents();
}

private void initComponents() {

jPanel4 = new javax.swing.JPanel();
jPanel1 = new javax.swing.JPanel();
About = new java.awt.Label();
scrollPane1 = new java.awt.ScrollPane();
jScrollPane1 = new javax.swing.JScrollPane();
jEditorPane1 = new javax.swing.JEditorPane();
jPanel3 = new javax.swing.JPanel();
About1 = new java.awt.Label();
scrollPane4 = new java.awt.ScrollPane();
jScrollPane4 = new javax.swing.JScrollPane();
jEditorPane4 = new javax.swing.JEditorPane();
jPanel2 = new javax.swing.JPanel();
label2 = new java.awt.Label();
scrollPane2 = new java.awt.ScrollPane();
jScrollPane2 = new javax.swing.JScrollPane();
jEditorPane2 = new javax.swing.JEditorPane();
jPanel5 = new javax.swing.JPanel();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

jPanel4.setLayout(new java.awt.GridLayout(3, 1));

jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
jPanel1.setLayout(new java.awt.BorderLayout());

About.setAlignment(java.awt.Label.CENTER);
About.setText("About");
jPanel1.add(About, java.awt.BorderLayout.NORTH);

jEditorPane1.setEditable(false);
jEditorPane1.setBackground(new java.awt.Color(254, 254, 254));
jEditorPane1.setContentType("text/html"); // NOI18N
jEditorPane1.setText("<html>\n  <head>\n\n  </head>\n  <body>\n<p style=\"text-align: center;\">Developed with &hearts; by Anna A. Antonini (<a href=\"mailto:a.antonini011@studenti.unibs.it\">a.antonini011@studenti.unibs.it</a>)</p>\n<p style=\"text-align: center;\">Original project available freely on my <a href=\"https://github.com/a-lex-ant\">GitHub profile</a>.</p>\n<p style=\"text-align: center;\">&nbsp;</p>\n<p style=\"text-align: center;\">This program is free software: you can redistribute it and/or modify it under the terms of</p>\n<p style=\"text-align: center;\">the <strong>GNU General Public License</strong> as published by the Free Software Foundation, either</p>\n<p style=\"text-align: center;\">version 3 of the License, or (at your option) any later version. This program is distributed</p>\n<p style=\"text-align: center;\">in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the</p>\n<p style=\"text-align: center;\">implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.</p>\n<p style=\"text-align: center;\">See the GNU General Public License for more details.</p>\n<p style=\"text-align: center;\">You should have received a copy of the GNU General Public License along with this</p>\n<p style=\"text-align: center;\">program. If not, see &lt;https://www.gnu.org/licenses/&gt;.</p>\n<p>&nbsp;</p>\n  </body>\n</html>\n");
jScrollPane1.setViewportView(jEditorPane1);

scrollPane1.add(jScrollPane1);

jPanel1.add(scrollPane1, java.awt.BorderLayout.CENTER);

jPanel4.add(jPanel1);

jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
jPanel3.setLayout(new java.awt.BorderLayout());

About1.setAlignment(java.awt.Label.CENTER);
About1.setText("External Library Credits");
jPanel3.add(About1, java.awt.BorderLayout.NORTH);
About1.getAccessibleContext().setAccessibleName("External Library Credits");

jEditorPane4.setContentType("text/html"); // NOI18N
jEditorPane4.setText("<html>\n  <head>\n\n  </head>\n  <body>\n <p style=\"text-align: center;\">This program wouldn't have been possible without this awesome libraries:</p>\n<p style=\"text-align: center;\"><strong>Vlcj<br /></strong><em><span class=\"text-gray-dark mr-2\">Java framework for the vlc media player.</span></em></p>\n<p style=\"text-align: center;\"><a href=\"http://www.capricasoftware.co.uk/projects/vlcj\"><span class=\"text-gray-dark mr-2\">Official page on the Caprica Software website</span></a></p>\n<p style=\"text-align: center;\"><a href=\"https://github.com/caprica/vlcj\"><span class=\"text-gray-dark mr-2\">Official GitHub Repository</span></a></p>\n<p style=\"text-align: center;\"><strong><span class=\"text-gray-dark mr-2\">JFreeChart<br /></span></strong><em><span class=\"text-gray-dark mr-2\">A 2D chart library for Java application.</span></em></p>\n<p style=\"text-align: center;\"><a href=\"A%202D chart library for Java applications \"><span class=\"text-gray-dark mr-2\">Official web page</span></a></p>\n<p style=\"text-align: center;\"><a href=\"https://github.com/jfree/jfreechart\"><span class=\"text-gray-dark mr-2\">Official GitHub Repository</span></a></p>\n<p style=\"text-align: center;\">...And the <a href=\"https://stackoverflow.com/\">StackOverflow</a>'s community :)</p>\n  </body>\n</html>\n");
jScrollPane4.setViewportView(jEditorPane4);

scrollPane4.add(jScrollPane4);

jPanel3.add(scrollPane4, java.awt.BorderLayout.CENTER);

jPanel4.add(jPanel3);

jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
jPanel2.setLayout(new java.awt.BorderLayout());

label2.setAlignment(java.awt.Label.CENTER);
label2.setText("Icon Credits");
jPanel2.add(label2, java.awt.BorderLayout.NORTH);

jEditorPane2.setEditable(false);
jEditorPane2.setContentType("text/html"); // NOI18N
jEditorPane2.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p style=\"text-align: center;\">Nearly all icons are from the <a href=\"https://feathericons.com/\">Feather Icons project</a> by <a href=\"https://twitter.com/colebemis\">Cole Bemis</a>.</p>\n<p style=\"text-align: center;\"><a href=\"https://icons8.com/icons/set/italy\" target=\"_blank\" rel=\"noopener\">Italy icon</a> and <a href=\"https://icons8.com/icons/set/usa\" target=\"_blank\" rel=\"noopener\">USA icon</a> by <a href=\"https://icons8.com\" target=\"_blank\" rel=\"noopener\">Icons8</a>.</p>\n<p>&nbsp;</p>\n  </body>\n</html>\n");
jScrollPane2.setViewportView(jEditorPane2);

scrollPane2.add(jScrollPane2);

jPanel2.add(scrollPane2, java.awt.BorderLayout.CENTER);

javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
jPanel5.setLayout(jPanel5Layout);
jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 524, Short.MAX_VALUE)
);
jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
);

jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

jPanel4.add(jPanel2);

getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

pack();
}

}
