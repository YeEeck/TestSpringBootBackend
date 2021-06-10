package entity;

public class InfoBack1 {
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        Sclass = sclass;
    }

    public String _id;
    public String name;
    public String type;
    public String age;
    public String sex;
    public String idNo;
    public String Sclass;

    public InfoBack1(String _id, String name, String type, String age,String sex,String idNo,String Sclass){
        this._id = _id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.sex = sex;
        this.idNo = idNo;
        this.Sclass = Sclass;
    }


}
