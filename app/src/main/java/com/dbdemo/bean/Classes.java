package com.dbdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by app on 2017/10/17.
 */
@Entity
public class Classes {

    @Id(autoincrement = true)
    private long id;
    private String cName;
    @Generated(hash = 820627018)
    public Classes(long id, String cName) {
        this.id = id;
        this.cName = cName;
    }
    @Generated(hash = 11797154)
    public Classes() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCName() {
        return this.cName;
    }
    public void setCName(String cName) {
        this.cName = cName;
    }

}
