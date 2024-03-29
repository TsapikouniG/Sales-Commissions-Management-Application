package gui;
import input.TXTInput;
import input.XMLInput;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

import data.Salesman;
import input.HTMLInput;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImportSalesmanFileWindow extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel inputWindowPanel = new JPanel();
	private DefaultListModel <String> listModel = new DefaultListModel <String>();
	private JList <String> salesmansList = new JList <String>();
	private ArrayList <Salesman> allSalesmans;
	private  Salesman salesman = new Salesman();
	private Salesman selectedSalesman = null;
	static ImportSalesmanFileWindow dialog = new ImportSalesmanFileWindow();
	@SuppressWarnings("unused")
	private File inputFile;
	private String fileTypeFlag;

	
	
	public static void main(String[] args) {
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
			for (int i = 0; i < installedLookAndFeels.length; i++) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ImportSalesmanFileWindow(){
		setForeground(new Color(0, 0, 0));
		
		initialise();
	}
	
	public void initialise() {
		allSalesmans = new ArrayList <Salesman>();
		
		setBackground(new Color(0, 0, 0)); 
		setBounds(100, 100, 736, 590);
		getContentPane().setLayout(new BorderLayout());
		inputWindowPanel.setForeground(new Color(0, 0, 0));
		inputWindowPanel.setBackground(new Color(230, 230, 250)); 
		getContentPane().add(inputWindowPanel, BorderLayout.EAST);


				JButton buttonTXTInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC TXT");
				buttonTXTInput.setForeground(new Color(255, 255, 240));
				buttonTXTInput.setFont(new Font("Times New Roman", Font.BOLD, 14));
				buttonTXTInput.setBackground(new Color(25, 25, 112));
				
				JButton buttonXMLInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC XML");
				buttonXMLInput.setForeground(new Color(255, 250, 250));
				buttonXMLInput.setFont(new Font("Times New Roman", Font.BOLD, 14));
				buttonXMLInput.setBackground(new Color(0, 0, 128));
				
				JButton buttonHTMLInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC HTML");
		        buttonHTMLInput.setForeground(new Color(255, 255, 240));
		        buttonHTMLInput.setFont(new Font("Times New Roman", Font.BOLD, 14));
		        buttonHTMLInput.setBackground(new Color(25, 25, 112));

				
				JLabel label = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03B5\u03AF\u03B4\u03BF\u03C2 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF\u03C5 \u03B3\u03B9\u03B1 \u03C6\u03CC\u03C1\u03C4\u03C9\u03C3\u03B7 \u03B1\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03C9\u03BD:");
				label.setBackground(new Color(240, 255, 255));
				label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				salesmansList.setForeground(new Color(107, 142, 35));
				salesmansList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						selectSalesman(e);
					}
				});
				
				salesmansList.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				salesmansList.setBackground(new Color(248, 248, 255));
				salesmansList.setBorder(new LineBorder(new Color(0, 0, 128)));
				
				
				JLabel label_1 = new JLabel("\u039B\u03B9\u03C3\u03C4\u03B1 \u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03BF\u03C3\u03CE\u03C0\u03C9\u03BD");
				label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				JButton button = new JButton("OK");
				button.setForeground(new Color(255, 250, 250));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						okButtonPressed(evt);						
					}

				
				});
				button.setToolTipText("");
				button.setFont(new Font("Courier New", Font.BOLD, 14));
				button.setBackground(new Color(0, 0, 128));
				
				JButton button_1 = new JButton("Cancel");
				button_1.setForeground(new Color(255, 250, 250));
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonPressed(e);
					}
				});
				button_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				button_1.setBackground(new Color(0, 0, 128));
				
				GroupLayout gl_inputWindowPanel = new GroupLayout(inputWindowPanel);
				gl_inputWindowPanel.setHorizontalGroup(
					gl_inputWindowPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addContainerGap(59, Short.MAX_VALUE)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_inputWindowPanel.createSequentialGroup()
											.addComponent(label)
											.addGap(10))
										.addGroup(gl_inputWindowPanel.createSequentialGroup()
											.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(buttonXMLInput, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(buttonTXTInput, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
												.addComponent(buttonHTMLInput, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
											.addGap(37)))
									.addGap(28)
									.addComponent(salesmansList, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
									.addGap(72))
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(99))
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addComponent(label_1)
									.addGap(144))))
				);
				gl_inputWindowPanel.setVerticalGroup(
					gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addGap(117)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonTXTInput, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(buttonXMLInput, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(buttonHTMLInput, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(179, Short.MAX_VALUE))
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addGap(95)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(salesmansList, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
							.addGap(30))
				);
				inputWindowPanel.setLayout(gl_inputWindowPanel);
				buttonTXTInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						insertFromTXT(evt);
					}
				});
				
				buttonXMLInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertFromXML(e);
					}
				});
				buttonHTMLInput.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent evt) {
		                insertFromHTML(evt);
		            }
		        });
	}
	
	
	private void cancelButtonPressed(ActionEvent e) {
		System.exit(0);	
	}
	
	private void insertFromHTML(ActionEvent evt) {
	    JFileChooser HTMLFileChooser = new JFileChooser();
	    HTMLFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    int result = HTMLFileChooser.showOpenDialog(null);
	    boolean salesmanDuplicate = false;

	    try {
	        if (result == JFileChooser.APPROVE_OPTION) {
	            File receiptFileHTML = HTMLFileChooser.getSelectedFile();
	            System.out.println("Selected File: " + receiptFileHTML.getAbsolutePath()); // Add this line for debugging
	            // Make sure inputFile is initialized before creating HTMLInput
	            this.inputFile = receiptFileHTML;
	            HTMLInput inputFileHTML = new HTMLInput(receiptFileHTML);
	            inputFileHTML.readFile();
	            salesman = inputFileHTML.getSalesman();
	            salesman.setFileType("HTML");
	            salesman.getReceiptsFileAdder().setFileToAppend(receiptFileHTML);
	            allSalesmans.add(salesman);

	            for (int i = 0; i < listModel.getSize(); i++) {
	                if (salesman.getName().equals(listModel.getElementAt(i))) {
	                    salesmanDuplicate = true;
	                }
	            }

	            if (salesmanDuplicate) {
	                JOptionPane.showMessageDialog(null, "The salesman is already on the list.");
	            } else {
	                listModel.addElement(salesman.getName());
	                salesmansList.setModel(listModel);
	                fileTypeFlag = "HTML";
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Add this line for debugging
	        JOptionPane.showMessageDialog(null, "Error reading the file. Please choose a valid file.");
	    }
	}


	
	private void insertFromTXT(ActionEvent evt){
		
		JFileChooser TXTFileChooser;
		TXTFileChooser = new JFileChooser();     
		TXTFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);		       
		TXTFileChooser.showOpenDialog(null);
		boolean salesmanDuplicate = false;
		try{
			File recieptFileTXT = TXTFileChooser.getSelectedFile();
			TXTInput inputFileTXT = new TXTInput(recieptFileTXT);	
			inputFileTXT.readFile();
			salesman = inputFileTXT.getSalesman();
			salesman.setFileType("TXT");
			salesman.getReceiptsFileAdder().setFileToAppend(recieptFileTXT);				
			allSalesmans.add(salesman);
			for(int i = 0; i< listModel.getSize(); i++){
				if(salesman.getName().equals(listModel.getElementAt(i))){
					salesmanDuplicate = true;

				}
			}
			if(salesmanDuplicate == true){
				JOptionPane.showMessageDialog(null,"The salesman is already on the list.");

			}
			else{
				listModel.addElement(salesman.getName());
				salesmansList.setModel(listModel);
				fileTypeFlag = "TXT";
			}
			
		}catch (NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"No file selected, please choose a file.");

		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null,"There was a problem during the opening of the file.");
		}
		
	}
	
	private void insertFromXML(ActionEvent evt2) {
	    JFileChooser XMLFileChooser;
	    XMLFileChooser = new JFileChooser();
	    XMLFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
	    XMLFileChooser.showOpenDialog(null);
	    boolean salesmanDuplicate = false;
	    try {
	        File receiptFileXML = XMLFileChooser.getSelectedFile();
	        // Make sure inputFile is initialized before creating XMLInput
	        this.inputFile = receiptFileXML;
	        XMLInput inputFileXML = new XMLInput(receiptFileXML);
	        inputFileXML.readFile();
	        salesman = inputFileXML.getSalesman();
	        salesman.setFileType("XML");
	        salesman.getReceiptsFileAdder().setFileToAppend(receiptFileXML);
	        allSalesmans.add(salesman);
	        for (int i = 0; i < listModel.getSize(); i++) {
	            if (salesman.getName().equals(listModel.getElementAt(i))) {
	                salesmanDuplicate = true;
	            }
	        }
	        if (salesmanDuplicate) {
	            JOptionPane.showMessageDialog(null, "The salesman is already on the list.");
	        } else {
	            listModel.addElement(salesman.getName());
	            salesmansList.setModel(listModel);
	            fileTypeFlag = "XML";
	        }
	    } catch (IllegalArgumentException e) {
	        JOptionPane.showMessageDialog(null, "No file selected, please choose a file.");
	    }
	}

	
	
	private void selectSalesman(MouseEvent e) {
	    String salesmanName;
	    if (salesmansList.getSelectedValue() != null) {
	        salesmanName = salesmansList.getSelectedValue().toString();
	        for (int i = 0; i < allSalesmans.size(); i++) {
	            if (salesmanName.equals(allSalesmans.get(i).getName())) {
	                selectedSalesman = allSalesmans.get(i);
	                break;
	            }
	        }
	    }
	}
	
	private void okButtonPressed(ActionEvent evt) {
		if(salesmansList.isSelectionEmpty()){
			JOptionPane.showMessageDialog(null,"Please, choose a salesman. ");

		}
		else{
			SelesmanReportManagerWindow sw = new SelesmanReportManagerWindow(dialog,selectedSalesman,fileTypeFlag);
			this.setVisible(false);
			sw.setVisible(true);
		}	
	}	
}
