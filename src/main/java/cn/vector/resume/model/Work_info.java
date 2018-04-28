package cn.vector.resume.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-13 10:27
 * Work_info（实体类）
 * 对应数据库中的work_info表
 * 工作经历实体类
 */
@Entity
@Table(name = "work_info")
public class Work_info {
    private int Workid;//主键
    @Length(max = 20)
    private String Company;//企业名
    @Length(max = 20)
    private String Position;//职位
    @Length(max = 100)
    private String Duty;//职责
    @Length(max = 20)
    private String Departure;//离职时间
    private int Userid;//用户

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Workid", unique = true, nullable = false)
    public int getWorkid() {
        return Workid;
    }

    public void setWorkid(int workid) {
        Workid = workid;
    }

    @Column(name = "Company", length = 20)
    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    @Column(name = "Position", length = 20)
    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Column(name = "Duty", length = 100)
    public String getDuty() {
        return Duty;
    }

    public void setDuty(String duty) {
        Duty = duty;
    }

    @Column(name = "Departure", length = 20)
    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    @Column(name = "Userid")
    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }
}
