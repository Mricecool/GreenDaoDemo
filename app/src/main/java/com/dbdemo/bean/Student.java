package com.dbdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.dbdemo.dao.DaoSession;
import com.dbdemo.dao.TeacherDao;
import com.dbdemo.dao.ClassesDao;
import org.greenrobot.greendao.annotation.NotNull;
import com.dbdemo.dao.StudentDao;

/**
 * Created by app on 2017/10/17.
 */
@Entity
public class Student {

    @Id(autoincrement = true)
    private long id;
    @Unique
    private long sId;
    private String sName;
    private String sPhone;
    private long cId;
    @ToOne(joinProperty = "cId")
    private Classes classes;
//    @ToMany(referencedJoinProperty = "sId")
//    private List<Teacher> teachers;
    @ToMany
    @JoinEntity(entity = JoinTeacherToStudent.class,sourceProperty = "sId",targetProperty = "tId")
    private List<Teacher> teachers;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    @Generated(hash = 1949161261)
    public Student(long id, long sId, String sName, String sPhone, long cId) {
        this.id = id;
        this.sId = sId;
        this.sName = sName;
        this.sPhone = sPhone;
        this.cId = cId;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getSId() {
        return this.sId;
    }
    public void setSId(long sId) {
        this.sId = sId;
    }
    public String getSName() {
        return this.sName;
    }
    public void setSName(String sName) {
        this.sName = sName;
    }
    public String getSPhone() {
        return this.sPhone;
    }
    public void setSPhone(String sPhone) {
        this.sPhone = sPhone;
    }
    public long getCId() {
        return this.cId;
    }
    public void setCId(long cId) {
        this.cId = cId;
    }
    @Generated(hash = 929604645)
    private transient Long classes__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 715337146)
    public Classes getClasses() {
        long __key = this.cId;
        if (classes__resolvedKey == null || !classes__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ClassesDao targetDao = daoSession.getClassesDao();
            Classes classesNew = targetDao.load(__key);
            synchronized (this) {
                classes = classesNew;
                classes__resolvedKey = __key;
            }
        }
        return classes;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 557525136)
    public void setClasses(@NotNull Classes classes) {
        if (classes == null) {
            throw new DaoException(
                    "To-one property 'cId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.classes = classes;
            cId = classes.getId();
            classes__resolvedKey = cId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1400050783)
    public List<Teacher> getTeachers() {
        if (teachers == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TeacherDao targetDao = daoSession.getTeacherDao();
            List<Teacher> teachersNew = targetDao._queryStudent_Teachers(id);
            synchronized (this) {
                if (teachers == null) {
                    teachers = teachersNew;
                }
            }
        }
        return teachers;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 456331696)
    public synchronized void resetTeachers() {
        teachers = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
}
