package org.tms.models.UI;

public class Users {

    private String validName = System.getProperty("validusername");
    private String validPassword = System.getProperty("validpassword");
    private String invalidPassword= System.getProperty("invalidpassword");

//    private String validName = "j768th@mail2run.com";
//    private String validPassword = "159zzz159";
//    private String invalidPassword = "111zzz159";


    public Users(){
    }

    public String getValidName() {
        return validName;
    }

    public void setValidName(String validName) {
        this.validName = validName;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }


}
