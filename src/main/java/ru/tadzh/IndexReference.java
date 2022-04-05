package ru.tadzh;

public class IndexReference {
    String numIndicator;
    String nameIndicator;
    public IndexReference(String numIndicator, String nameIndicator){
        this.numIndicator = numIndicator;
        this.nameIndicator = nameIndicator;
    }

    public String getNumIndicator() {
        return numIndicator;
    }

    public void setNumIndicator(String numIndicator) {
        this.numIndicator = numIndicator;
    }

    public String getNameIndicator() {
        return nameIndicator;
    }

    public void setNameIndicator(String nameIndicator) {
        this.nameIndicator = nameIndicator;
    }

    @Override
    public String toString() {
        return "IndexReference{" +
                "numIndicator='" + numIndicator + '\'' +
                ", nameIndicator='" + nameIndicator + '\'' +
                '}';
    }
}
