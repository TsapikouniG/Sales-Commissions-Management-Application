package input;

import java.io.File;


import data.Receipt;

public abstract class ReceiptsFileAdder {

    protected File fileToAppend;
    protected Receipt receipt;

    public abstract void setFileToAppend(File fileToAppend);

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    
    

    public void appendFile() {
        try {
            prepareFile();

            appendSpecificData();

            finalizeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void appendSpecificData();

    private void prepareFile() {
        System.out.println("Preparing file: " + fileToAppend.getAbsolutePath());
    }

    private void finalizeFile() {
    	System.out.println("Finalizing file: " + fileToAppend.getAbsolutePath());
    }
    
    
}
