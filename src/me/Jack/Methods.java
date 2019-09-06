package me.Jack;

public class Methods {

    public void clearChat(){
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public String padL(String string, int padding){
        return String.format("%1$" + padding + "s", string);
    }

    public String padR(String string, int padding){
        return String.format("%1$-" + padding + "s", string);
    }

}
