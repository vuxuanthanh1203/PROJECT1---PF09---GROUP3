package group3.persistance;

public class Admin extends Customer {

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPass() {
        return super.getPass();
    }

    @Override
    public String getTel() {
        return super.getTel();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPass(String pass) {
        super.setPass(pass);
    }

    @Override
    public void setTel(String tel) {
        super.setTel(tel);
    }   
}