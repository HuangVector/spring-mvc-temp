package cn.vector.resume.model;

import cn.vector.base.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-13 10:20
 * Basic_info（实体类）
 * 对应数据库中的basic_info表
 * 简历的基本信息实体类
 */
@Entity
@Table(name = "basic_info")
public class Basic_info extends BaseEntity {
//    @NotEmpty
//    @NotNull
    private int ID;//主键，ID
    @NotEmpty(message = "姓名不能为空")
    @Length(max=20,message = "姓名不超过20个字符")
    private String Name;//姓名
    @Length(max = 20)
    private String Gender;//性别
    private int Age;//年龄
    @Length(max = 20)
    private String Address;//地址
    @Length(max = 20)
    private String Email;//邮件
    @Length(max = 20)
    private String Tel;//电话
    @Length(max = 20)
    private String School;//毕业院校
    @Length(max = 10000)
    private String Introduce;//自我介绍
    private int UserId;//用户ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    @Column(name = "Name",length = 20)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    @Column(name = "Gender",length = 20)
    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
    @Column(name = "Age")
    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
    @Column(name = "Address",length = 20)
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    @Column(name = "Email",length = 20)
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    @Column(name = "Tel",length = 20)
    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }
    @Column(name = "School",length = 20)
    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
    @Column(name = "Introduce",length = 10000)
    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }
    @Column(name = "UserId")
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
