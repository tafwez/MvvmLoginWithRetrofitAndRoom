
package com.hassantafwez.loginmvvm.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "catimg",indices = @Index(value = {"id"},unique = true))
public class Datum {

    //if we want multiple data insert that we need to add autogenerate
    @PrimaryKey(autoGenerate = true)
    private int id;//if we gave id=1 than it replace the data again and again
    @NonNull
    @ColumnInfo
    @SerializedName("emp_id")
    @Expose
    private String empId;
    @SerializedName("emp_name")
    @Expose
    private String empName;
    @SerializedName("emp_email")
    @Expose
    private String empEmail;
    @SerializedName("emp_mobile")
    @Expose
    private String empMobile;
    @SerializedName("emp_password")
    @Expose
    private String empPassword;
    @SerializedName("emp_designation")
    @Expose
    private String empDesignation;
    @SerializedName("emp_gender")
    @Expose
    private String empGender;
    @SerializedName("emp_dob")
    @Expose
    private String empDob;
    @SerializedName("panel_attendance")
    @Expose
    private String panelAttendance;
    @SerializedName("panel_complaint")
    @Expose
    private String panelComplaint;
    @SerializedName("panel_examination")
    @Expose
    private String panelExamination;
    @SerializedName("panel_homework")
    @Expose
    private String panelHomework;
    @SerializedName("panel_leave")
    @Expose
    private String panelLeave;
    @SerializedName("panel_student")
    @Expose
    private String panelStudent;
   /* @SerializedName("class")
    @Expose
    private String _class;*/
    @SerializedName("section")
    @Expose
    private String section;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpDob() {
        return empDob;
    }

    public void setEmpDob(String empDob) {
        this.empDob = empDob;
    }

    public String getPanelAttendance() {
        return panelAttendance;
    }

    public void setPanelAttendance(String panelAttendance) {
        this.panelAttendance = panelAttendance;
    }

    public String getPanelComplaint() {
        return panelComplaint;
    }

    public void setPanelComplaint(String panelComplaint) {
        this.panelComplaint = panelComplaint;
    }

    public String getPanelExamination() {
        return panelExamination;
    }

    public void setPanelExamination(String panelExamination) {
        this.panelExamination = panelExamination;
    }

    public String getPanelHomework() {
        return panelHomework;
    }

    public void setPanelHomework(String panelHomework) {
        this.panelHomework = panelHomework;
    }

    public String getPanelLeave() {
        return panelLeave;
    }

    public void setPanelLeave(String panelLeave) {
        this.panelLeave = panelLeave;
    }

    public String getPanelStudent() {
        return panelStudent;
    }

    public void setPanelStudent(String panelStudent) {
        this.panelStudent = panelStudent;
    }

    /*public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }*/

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
