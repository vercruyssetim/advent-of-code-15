package be.cegeka.brownbags.worldobject;

public enum Race {
    GOBLIN("G"), ELF("E");

    private String letterCode;

    Race(String letterCode) {
        this.letterCode = letterCode;
    }

    public String letterCode() {
        return letterCode;
    }
}
