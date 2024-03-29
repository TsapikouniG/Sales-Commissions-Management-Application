package gui;


import javax.swing.JButton;


import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import data.Salesman;
import data.Receipt;

import data.Address;
import javax.swing.SwingConstants;



public class SelesmanReportManagerWindow extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel selectionWindowPanel = new JPanel();
	private JTextField dateTextField;
	private JTextField kindTextField;
	private JTextField salesTextField;
	private JTextField itemsTextField;
	private JTextField companyTextField;
	private JTextField countryTextField;
	private JTextField cityTextField;
	private JTextField streetTextField;
	private JTextField receiptIDTextField;
	private JTextField numberTextField;
	private JTextField numOfReceiptsTextField;
	private JTextField salesmanNameTextField;
	private JLabel receiptIDLabel;
    private JLabel dateLabel;
    private JLabel kindLabel;
    private JLabel salesLabel;
    private JLabel itemsLabel;
    private JLabel companyLabel;
    private JLabel countryLabel;
    private JLabel cityLabel;
    private JLabel streetLabel;
    private JLabel numberLabel;
    private int numOfReceipts = 0;
	private double totalSales;
	private JCheckBox totalSalesCheckBox;
	private JCheckBox totalItemsCheckBox;
	private JCheckBox commissionCheckBox;
	private JCheckBox categoryCheckBox;
	private JRadioButton skirtRadio;
	private JRadioButton shirtRadio;
	private JRadioButton trousersRadio;
	private JRadioButton coatRadio;
	private int totalItems;
	private float shirtSales;
	private float skirtSales;
	private float coatsSales;
	private float trousersSales;
	private double commission;
	private ImportSalesmanFileWindow inputDialog;
	private Salesman selectedSalesman;
	@SuppressWarnings("unused")
	private String fileType;
	
	public SelesmanReportManagerWindow(ImportSalesmanFileWindow dialog, Salesman salesman, String fileTypeFlag) {
		inputDialog = dialog;
		selectedSalesman = salesman;
		fileType = fileTypeFlag;
		initialise();
		
	}
	

	public void initialise(){
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 717, 597);
		getContentPane().setLayout(null);
		
	    final int FIELD_WIDTH = 133;
	    final int FIELD_HEIGHT = 20;
	    final int FIELD_X = 543;
	    final int LABEL_X = 470;
		
		selectionWindowPanel.setBounds(0, 0, 701, 1);
		selectionWindowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(selectionWindowPanel);
		selectionWindowPanel.setLayout(null);
		totalSalesCheckBox = new JCheckBox("\u03A3\u03C5\u03BD\u03BF\u03BB\u03B9\u03BA\u03AE \u03B1\u03BE\u03AF\u03B1 \u03C0\u03C9\u03BB\u03AE\u03C3\u03B5\u03C9\u03BD");
		totalSalesCheckBox.setBackground(new Color(230, 230, 250));
		totalSalesCheckBox.setBounds(52, 129, 169, 25);
		totalSalesCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(totalSalesCheckBox);
		
		totalItemsCheckBox = new JCheckBox("\u03A3\u03C5\u03BD\u03BF\u03BB\u03B9\u03BA\u03CC\u03C2 \u03B1\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03C9\u03BB\u03AE\u03C3\u03B5\u03C9\u03BD");
		totalItemsCheckBox.setBackground(new Color(230, 230, 250));
		totalItemsCheckBox.setBounds(52, 170, 204, 25);
		totalItemsCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(totalItemsCheckBox);
		
		categoryCheckBox = new JCheckBox("\u03A0\u03C9\u03BB\u03AE\u03C3\u03B5\u03B9\u03C2 \u03C3\u03C5\u03B3\u03BA\u03B5\u03BA\u03C1\u03B9\u03BC\u03AD\u03BD\u03B7\u03C2 \u03BA\u03B1\u03C4\u03B7\u03B3\u03BF\u03C1\u03AF\u03B1\u03C2");
		categoryCheckBox.setBackground(new Color(230, 230, 250));
		
		categoryCheckBox.setBounds(52, 214, 257, 25);
		categoryCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(categoryCheckBox);
		
		shirtRadio = new JRadioButton("\u039C\u03C0\u03BB\u03BF\u03CD\u03B6\u03B5\u03C2");
		shirtRadio.setBackground(new Color(230, 230, 250));
		shirtRadio.setEnabled(false);
		shirtRadio.setBounds(119, 242, 125, 25);
		shirtRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(shirtRadio);
		
		trousersRadio = new JRadioButton("\u03A0\u03B1\u03BD\u03C4\u03B5\u03BB\u03CC\u03BD\u03B9\u03B1");
		trousersRadio.setBackground(new Color(230, 230, 250));
		trousersRadio.setEnabled(false);
		trousersRadio.setBounds(119, 270, 125, 25);
		trousersRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(trousersRadio);
		
		coatRadio = new JRadioButton("\u03A0\u03B1\u03BB\u03C4\u03AC");
		coatRadio.setBackground(new Color(230, 230, 250));
		coatRadio.setEnabled(false);
		coatRadio.setBounds(119, 298, 125, 25);
		coatRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(coatRadio);
		
		skirtRadio = new JRadioButton("\u03A6\u03BF\u03CD\u03C3\u03C4\u03B5\u03C2");
		skirtRadio.setBackground(new Color(230, 230, 250));
		skirtRadio.setEnabled(false);
		skirtRadio.setBounds(119, 326, 125, 25);
		skirtRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(skirtRadio);
		
		commissionCheckBox = new JCheckBox("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u03A0\u03C1\u03BF\u03BC\u03AE\u03B8\u03B5\u03B9\u03B1\u03C2");
		commissionCheckBox.setBackground(new Color(230, 230, 250));
		commissionCheckBox.setBounds(52, 375, 204, 25);
		commissionCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(commissionCheckBox);
		
		final JToggleButton addReceiptToggleButton = new JToggleButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03BD\u03AD\u03B1\u03C2 \u03B1\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7\u03C2");
		addReceiptToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addReceiptToggleButton.setBackground(new Color(216, 191, 216));
		
		addReceiptToggleButton.setBounds(411, 12, 265, 47);
		getContentPane().add(addReceiptToggleButton);

		receiptIDLabel = createLabel("ReceiptID:", LABEL_X, 84);
        dateLabel = createLabel("Date:", LABEL_X, 119);
        kindLabel = createLabel("Kind:", LABEL_X, 163);
        salesLabel = createLabel("Sales:", LABEL_X, 209);
        itemsLabel = createLabel("Items:", LABEL_X, 250);
        companyLabel = createLabel("Company:", LABEL_X, 287);
        countryLabel = createLabel("Country:", LABEL_X, 329);
        cityLabel = createLabel("City:", LABEL_X, 366);
        streetLabel = createLabel("Street:", LABEL_X, 407);
        numberLabel = createLabel("Number:", LABEL_X, 448);
        
	    receiptIDTextField = createTextField(FIELD_X, 81, FIELD_WIDTH, FIELD_HEIGHT);
	    dateTextField = createTextField(FIELD_X, 120, FIELD_WIDTH, FIELD_HEIGHT);
	    kindTextField = createTextField(FIELD_X, 163, FIELD_WIDTH, FIELD_HEIGHT);
	    salesTextField = createTextField(FIELD_X, 208, FIELD_WIDTH, FIELD_HEIGHT);
	    itemsTextField = createTextField(FIELD_X, 250, FIELD_WIDTH, FIELD_HEIGHT);
	    companyTextField = createTextField(FIELD_X, 287, FIELD_WIDTH, FIELD_HEIGHT);
	    countryTextField = createTextField(FIELD_X, 329, FIELD_WIDTH, FIELD_HEIGHT);
	    cityTextField = createTextField(FIELD_X, 367, FIELD_WIDTH, FIELD_HEIGHT);
	    streetTextField = createTextField(FIELD_X, 406, FIELD_WIDTH, FIELD_HEIGHT);
	    numberTextField = createTextField(FIELD_X, 445, FIELD_WIDTH, FIELD_HEIGHT);
		
		final JButton addReceiptButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addReceiptButton.setBackground(new Color(147, 112, 219));
		addReceiptButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		addReceiptButton.setVisible(false);
		addReceiptButton.setBounds(519, 482, 105, 39);
		getContentPane().add(addReceiptButton);
		
		JLabel lblNewLabel_10 = new JLabel("\u0391\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03B9\u03C2 \u03C0\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C3\u03B8\u03AD\u03B8\u03B7\u03BA\u03B1\u03BD:");
		lblNewLabel_10.setBounds(469, 532, 157, 14);
		getContentPane().add(lblNewLabel_10);
		
		numOfReceiptsTextField = new JTextField();
		numOfReceiptsTextField.setText("0");
		numOfReceiptsTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		numOfReceiptsTextField.setBounds(636, 528, 40, 20);
		getContentPane().add(numOfReceiptsTextField);
		numOfReceiptsTextField.setColumns(10);
		
		JButton okbutton = new JButton("OK");
		okbutton.setForeground(new Color(147, 112, 219));
		okbutton.setBackground(new Color(147, 112, 219));
		okbutton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okButtonPressed(evt);
				
			}
		});
		okbutton.setBounds(40, 483, 89, 32);
		getContentPane().add(okbutton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setForeground(new Color(147, 112, 219));
		cancelButton.setBackground(new Color(147, 112, 219));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonPressed(evt);
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cancelButton.setBounds(147, 483, 94, 32);
		getContentPane().add(cancelButton);
		
		JLabel lblNewLabel_11 = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03C0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2 \u03C0\u03C1\u03BF\u03C2 \u03B5\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(38, 93, 271, 29);
		getContentPane().add(lblNewLabel_11);
		
		JLabel salesmanNameLabel = new JLabel("\u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF\u03C2:");
		salesmanNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		salesmanNameLabel.setBounds(73, 12, 129, 25);
		getContentPane().add(salesmanNameLabel);
		
		salesmanNameTextField = new JTextField();
		salesmanNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		salesmanNameTextField.setBackground(new Color(230, 230, 250));
		salesmanNameTextField.setEditable(false);
		salesmanNameTextField.setFont(new Font("Segoe UI", Font.BOLD, 16));
		salesmanNameTextField.setBounds(52, 48, 174, 32);
		getContentPane().add(salesmanNameTextField);
		salesmanNameTextField.setColumns(10);
		
		categoryCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				skirtRadio.setEnabled(true);
				shirtRadio.setEnabled(true);
				coatRadio.setEnabled(true);
				trousersRadio.setEnabled(true);
				if(categoryCheckBox.isSelected()==false){
					if(skirtRadio.isSelected())
						skirtRadio.setSelected(false);
					
					if(shirtRadio.isSelected())
						shirtRadio.setSelected(false);
					
					if(coatRadio.isSelected())
						coatRadio.setSelected(false);
					
					if(trousersRadio.isSelected())
						trousersRadio.setSelected(false);
					
					skirtRadio.setEnabled(false);
					shirtRadio.setEnabled(false);
					coatRadio.setEnabled(false);
					trousersRadio.setEnabled(false);
				}
			}
		});
		
		addReceiptToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				receiptIDLabel.setVisible(true);;receiptIDTextField.setVisible(true);
				dateLabel.setVisible(true);dateTextField.setVisible(true);
				kindLabel.setVisible(true);kindTextField.setVisible(true);
				salesLabel.setVisible(true);salesTextField.setVisible(true);
				itemsLabel.setVisible(true);itemsTextField.setVisible(true);
				companyLabel.setVisible(true);companyTextField.setVisible(true);
				countryLabel.setVisible(true);countryTextField.setVisible(true);
				streetLabel.setVisible(true);streetTextField.setVisible(true);
				cityLabel.setVisible(true);cityTextField.setVisible(true);
				numberLabel.setVisible(true);numberTextField.setVisible(true);
				addReceiptButton.setVisible(true);
				if(addReceiptToggleButton.isSelected()==false){
					receiptIDLabel.setVisible(false);receiptIDTextField.setVisible(false);
					dateLabel.setVisible(false);dateTextField.setVisible(false);
					kindLabel.setVisible(false);kindTextField.setVisible(false);
					salesLabel.setVisible(false);salesTextField.setVisible(false);
					itemsLabel.setVisible(false);itemsTextField.setVisible(false);
					companyLabel.setVisible(false);companyTextField.setVisible(false);
					countryLabel.setVisible(false);countryTextField.setVisible(false);
					streetLabel.setVisible(false);streetTextField.setVisible(false);
					cityLabel.setVisible(false);cityTextField.setVisible(false);
					numberLabel.setVisible(false);numberTextField.setVisible(false);
					addReceiptButton.setVisible(false);
				}
			}
		});
		
		addReceiptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			
				addReceiptButtonPressed(evt);
				
			}
		});
		
		try{
			salesmanNameTextField.setText(selectedSalesman.getName());
		}catch(NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"Please, choose a salesman.");

		}
		
		
	}
	private JTextField createTextField(int x, int y, int width, int height) {
	    JTextField textField = new JTextField();
	    textField.setVisible(false);
	    textField.setBounds(x, y, width, height);
	    getContentPane().add(textField);
	    textField.setColumns(10);
	    return textField;
	}

	private JLabel createLabel(String labelText, int x, int y) {
	    JLabel label = new JLabel(labelText);
	    label.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
	    label.setVisible(false);
	    label.setBounds(x, y, 80, 20);
	    getContentPane().add(label);
	    return label;
	}

	protected void okButtonPressed(ActionEvent evt) {
	    try {
	        totalSales = totalSalesCheckBox.isSelected() ? selectedSalesman.calculateTotalSales() : -1;
	        totalItems = totalItemsCheckBox.isSelected() ? selectedSalesman.calculateTotalItems() : -1;
	        shirtSales = shirtRadio.isSelected() ? selectedSalesman.calculateShirtsSales() : -1;
	        skirtSales = skirtRadio.isSelected() ? selectedSalesman.calculateSkirtsSales() : -1;
	        coatsSales = coatRadio.isSelected() ? selectedSalesman.calculateCoatsSales() : -1;
	        trousersSales = trousersRadio.isSelected() ? selectedSalesman.calculateTrouserSales() : -1;
	        commission = commissionCheckBox.isSelected() ? selectedSalesman.calculateCommission() : -1;

	        ExtractSalesmanFileWindow rs = new ExtractSalesmanFileWindow(this, selectedSalesman, totalSales, totalItems, shirtSales, skirtSales, trousersSales, coatsSales, commission);
	        rs.setVisible(true);
	        this.setVisible(false);
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	}

	
	private void addReceiptButtonPressed(ActionEvent evt) {
	    if (areFieldsEmpty()) {
	        JOptionPane.showMessageDialog(null, "You must fill in all fields.");
	    } else {
	        addReceipt();
	        appendFile();
	    }

	    receiptIDTextField.setText("");
	    dateTextField.setText("");
	    kindTextField.setText("");
	    salesTextField.setText("");
	    itemsTextField.setText("");
	    companyTextField.setText("");
	    countryTextField.setText("");
	    cityTextField.setText("");
	    streetTextField.setText("");
	    numberTextField.setText("");
	}

	private boolean areFieldsEmpty() {
	    return isEmptyField(receiptIDTextField) || isEmptyField(dateTextField) || isEmptyField(kindTextField)
	            || isEmptyField(salesTextField) || isEmptyField(itemsTextField) || isEmptyField(companyTextField)
	            || isEmptyField(countryTextField) || isEmptyField(cityTextField) || isEmptyField(streetTextField)
	            || isEmptyField(numberTextField);
	}

	private boolean isEmptyField(JTextField textField) {
	    return textField.getText().isEmpty();
	}

	private void appendFile() {
		Receipt receipt = selectedSalesman.createReceipt(Integer.parseInt(receiptIDTextField.getText()),
                dateTextField.getText(),
                kindTextField.getText(),
                Double.parseDouble(salesTextField.getText()),
                Integer.parseInt(itemsTextField.getText()),
                companyTextField.getText(),
                countryTextField.getText(),
                cityTextField.getText(),
                streetTextField.getText(),
                Integer.parseInt(numberTextField.getText()));

        selectedSalesman.appendFile(receipt);
	}


	public void addReceipt() {
	    Receipt receipt = new Receipt();

	    
	    	String receiptIDInput = receiptIDTextField.getText().trim();
	        if (isValidInteger(receiptIDInput)) {
	            receipt.setReceiptID(Integer.parseInt(receiptIDInput));
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid Receipt ID. Please enter a valid integer.");
	            return; 
	        }

	       
	        String dateInput = dateTextField.getText();
	        if (isValidDateFormat(dateInput)) {
	            receipt.setDate(dateInput);
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid date format. Please use DD/MM/YYYY");
	            return; 
	        }

	        String kindInput = kindTextField.getText();
	        if (isValidKind(kindInput)) {
	            receipt.setKind(kindInput);
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid kind. Please use Coats, Shirts, Skirts, Trousers.");
	            return; 
	        }

	        String salesInput = salesTextField.getText().trim();
	        if (isValidDouble(salesInput)) {
	            receipt.setSales(Double.parseDouble(salesInput));
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid sales amount. Please enter a valid number.");
	            return; 
	        }

	        String itemsInput = itemsTextField.getText().trim();
	        if (isValidInteger(itemsInput)) {
	            receipt.setItems(Integer.parseInt(itemsInput));
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid number of items. Please enter a valid integer.");
	            return; 
	        }
	        String companyNameInput = companyTextField.getText().trim();
	        if (isValidStringInput(companyNameInput)) {
	            receipt.getCompany().setName(companyNameInput);
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid company name. Please enter a valid string.");
	            return; 
	        }

	        Address companyAddress = receipt.getCompany().getCompanyAddress();
	        String countryInput = countryTextField.getText().trim();
	        String cityInput = cityTextField.getText().trim();
	        String streetInput = streetTextField.getText().trim();

	        if (isValidString(countryInput) && isValidString(cityInput) && isValidString(streetInput)) {
	            companyAddress.setCountry(countryInput);
	            companyAddress.setCity(cityInput);
	            companyAddress.setStreet(streetInput);
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid  City or Country or Street name. Please enter valid strings.");
	            return; 
	        }

	        String numberInput = numberTextField.getText().trim();
	        if (isValidInteger(numberInput)) {
	            receipt.getCompany().getCompanyAddress().setStreetNumber(Integer.parseInt(numberInput));
	        } else {
	            JOptionPane.showMessageDialog(null, "Invalid street number. Please enter a valid integer.");
	            return; 
	        }

	        selectedSalesman.getReceipts().add(receipt);

	        numOfReceipts++;
	        numOfReceiptsTextField.setText(Integer.toString(numOfReceipts));
	        JOptionPane.showMessageDialog(null, "Receipt added successfully");

	   
	    
	    
	}
	
	private boolean isValidDouble(String input) {
	    try {
	        Double.parseDouble(input);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	private boolean isValidInteger(String input) {
	    try {
	        Integer.parseInt(input);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	private boolean isValidDateFormat(String date) {
	    String dateFormatRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";

	    if (date.matches(dateFormatRegex)) {
	        String[] dateParts = date.split("/");
	        int day = Integer.parseInt(dateParts[0]);
	        int month = Integer.parseInt(dateParts[1]);
	        int year = Integer.parseInt(dateParts[2]);

	        if (month >= 1 && month <= 12) {
	            if ((month == 4 || month == 6 || month == 9 || month == 11) && (day >= 1 && day <= 30)) {
	                return true;
	            } else if ((month == 1 || month == 3 || month == 5 || month == 7 ||
	                        month == 8 || month == 10 || month == 12) && (day >= 1 && day <= 31)) {
	                return true;
	            } else if (month == 2) {
	                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
	                    return day >= 1 && day <= 29;
	                } else {
	                    return day >= 1 && day <= 28;
	                }
	            }
	        }
	    }

	    return false;
	}

	private boolean isValidKind(String kind) {
	    if (kind != null && !kind.isEmpty()) {
	        if (kind.equals("Coats") || kind.equals("Shirts") || kind.equals("Skirts") || kind.equals("Trousers")) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private boolean isValidString(String input) {
        return input != null && !input.isEmpty() && !input.matches(".*\\d.*");
    }
	
	private boolean isValidStringInput(String input) {
        return isValidString(input) && !input.matches(".*\\d.*");
    }
	
	
	private void cancelButtonPressed(ActionEvent evt) {		
		dispose();
		inputDialog.setVisible(true);		
	}
	
	
}
