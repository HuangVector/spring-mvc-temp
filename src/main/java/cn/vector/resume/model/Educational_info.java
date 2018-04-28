package cn.vector.resume.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-13 10:24
 * Educational_info（实体类）
 * 对应数据库中的educational_info表
 * 教育信息实体类
 */
@Entity
@Table(name = "educational_info")
public class Educational_info {
    private int Eduid;//主键
    @Length(max = 20)
    private String School;//学校
    @Length(max = 20)
    private String Major;//专业
    @Length(max = 20)
    private String Education;//学历
    @Length(max = 40)
    private String Graduation;//毕业时间
    private int Userid;//用户

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Eduid", unique = true, nullable = false)
    public int getEduid() {
        return Eduid;
    }

    public void setEduid(int eduid) {
        Eduid = eduid;
    }

    @Column(name = "School", length = 20)
    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    @Column(name = "Major", length = 20)
    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    @Column(name = "Education", length = 20)
    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Column(name = "Graduation", length = 40)
    public String getGraduation() {
        return Graduation;
    }

    public void setGraduation(String graduation) {
        Graduation = graduation;
    }

    @Column(name = "Userid")
    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }
}
