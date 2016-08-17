package model;


import java.io.Serializable;

/*
 * Created by Ahmed on 08-Aug-16.
 */
@SuppressWarnings("unused")
public class Record implements Serializable, Comparable {
    private String name;
    private String email;
    private String phone;
    private String id;
    private String attendance;

    public Record() {
        this.name = "";
        this.email = "";
        this.phone = "";
        this.id = "-1";
        this.attendance = "false";
    }

    public Record(String name, String email, String phone, String id, String attendance) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return name + ',' + email + ',' + phone + ',' + id + ',' + attendance + '\n';
    }

    public String getAttendance() {
        return this.attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
