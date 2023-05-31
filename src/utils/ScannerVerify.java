package utils;

public class ScannerVerify {
    private String entry;

    public ScannerVerify(String entry) {
        this.entry = entry;
    }


    public boolean isLetter(){ // Verifica se a entrada é uma letra
        boolean passed = false;
        if (this.entry.matches("[a-zA-Z]") && this.entry.length() == 1){
            passed = true;
        }
        return passed;
    }
}
