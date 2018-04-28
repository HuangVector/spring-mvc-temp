package cn.vector.resume.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-13 10:16
 * User_info（实体类）
 * 对应数据库中的user_info表
 * 用户登录信息实体类
 */
@Entity
@Table(name = "user_info")
public class User_info {
    private int userId;//用户id，主键
    @Length(max = 20)
    private String Name;//登录名
    @Length(max = 20)
    private String Password;//登录密码

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true, nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "Name", length = 20)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(name = "Password", length = 20)
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
