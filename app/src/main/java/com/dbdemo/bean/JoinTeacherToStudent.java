package com.dbdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by app on 2017/10/20.
 */
@Entity
public class JoinTeacherToStudent {

    @Id
    private long id;
    private long tId;
    private long sId;
    @Generated(hash = 663515261)
    public JoinTeacherToStudent(long id, long tId, long sId) {
        this.id = id;
        this.tId = tId;
        this.sId = sId;
    }
    @Generated(hash = 756546384)
    public JoinTeacherToStudent() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTId() {
        return this.tId;
    }
    public void setTId(long tId) {
        this.tId = tId;
    }
    public long getSId() {
        return this.sId;
    }
    public void setSId(long sId) {
        this.sId = sId;
    }

}
